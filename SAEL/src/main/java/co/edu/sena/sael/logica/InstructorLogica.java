/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Instructor;
import co.edu.sena.sael.modelo.Personal;
import co.edu.sena.sael.persistencia.IInstructorDAO;
import co.edu.sena.sael.persistencia.IPersonalDAO;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.chart.Chart;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author DILOVE
 */
@Stateless
public class InstructorLogica implements InstructorLogicaLocal {

    @EJB
    private IInstructorDAO instructorDAO;
    @EJB
    private IPersonalDAO personalDAO;
    @EJB
    private PersonalLogicaLocal personalLogica;
    private int personasInsertadas = 0;
    private int personasExistentes = 0;
    private int instructoresInsertados=0;    
    private int instructoresExistentes=0; 
    
    @Override
    public void registrar(Instructor instructor) throws Exception {
        if(instructor==null) {
            throw new Exception("El instructor es nulo!");
        }
        
        if(instructor.getTipo()==null || instructor.getTipo().equals("")==true) {
            throw new Exception("El tipo es obligatorio!");
        }        
             
        //consulta si el instructor ya Existe
        Instructor entityInstructor=instructorDAO.consultarPorId(instructor.getDocumentoinstructor());
        if(entityInstructor!=null){
            throw new Exception("El instructor ya existe!"); 
        }
          
        instructorDAO.insertar(instructor);
    }

    @Override
    public void modificar(Instructor instructor) throws Exception {
        if(instructor==null) {
            throw new Exception("El instructor es nulo!");
        }

        //consulta si el instructor ya Existe
        Instructor entityInstructor=instructorDAO.consultarPorId(instructor.getDocumentoinstructor());
        if(entityInstructor==null){
            throw new Exception("El instructor no existe!"); 
        }
        //se envia el objeto entity a modificar porque es quien tiene el valor del instructor si existe
        entityInstructor.setTipo(instructor.getTipo());
        //modificar
        instructorDAO.modificar(entityInstructor);        
    }

    @Override
    public void eliminar(Instructor instructor) throws Exception {
        if(instructor==null) {
            throw new Exception("El Instructor es nulo!");
        }
        
        if(instructor.getDocumentoinstructor()==null || instructor.getDocumentoinstructor()==0) {
            throw new Exception("La identificación es obligatoria!");
        }
        //consulta si el instructor ya Existe
        Instructor entityInstructor=instructorDAO.consultarPorId(instructor.getDocumentoinstructor());
        if(entityInstructor==null){
            throw new Exception("El instructor no existe!"); 
        }       
        //eliminar
        instructorDAO.eliminar(entityInstructor);           
    }

    @Override
    public Instructor consultarPorId(Long documentoinstructor) throws Exception {
        if(documentoinstructor==null || documentoinstructor==0){
            throw new Exception("La identificación es obligatoria!");
        }
        
        return instructorDAO.consultarPorId(documentoinstructor);
    }

    @Override
    public List<Instructor> consultar() throws Exception {
        return instructorDAO.consultar();
    }
        
    public String encriptarContraseña(String password) {
        String encriptMD5 = DigestUtils.md5Hex(password);
        //System.out.println("md5:" + encriptMD5);
        
        return encriptMD5;
    }

    @Override
    public Map importarInstructores(String archivo) throws Exception {
        Workbook archivoExcel = Workbook.getWorkbook(new File(archivo));
        //Recorrer las filas de la primera hoja
        Sheet hoja = archivoExcel.getSheet(0);
        int numFilas = hoja.getRows();
        
        
        
        personasInsertadas = 0;
        personasExistentes = 0;
        instructoresInsertados=0;    
        instructoresExistentes=0; 
                
        List<String> mensajesError=new ArrayList<>(); //lista de mensajes de error

        for (int fila = 1; fila < numFilas; fila++) { // Recorre cada 
            Personal nuevoPersonal = new Personal();
            try {
                nuevoPersonal.setDocumentopersonal(Long.parseLong(hoja.getCell(0, fila).getContents()));
                nuevoPersonal.setNombre(hoja.getCell(1,fila).getContents().toUpperCase());
                nuevoPersonal.setApellido(hoja.getCell(2, fila).getContents().toUpperCase());
                nuevoPersonal.setCorreo(hoja.getCell(3, fila).getContents().toUpperCase());
                nuevoPersonal.setTelefono(hoja.getCell(4, fila).getContents());
                //String sexo =  s;
                nuevoPersonal.setSexo(hoja.getCell(5,fila).getContents().charAt(0));
                nuevoPersonal.setClave(hoja.getCell(0, fila).getContents());
                
                boolean personalValido = personalLogica.validarDatosPersonal(nuevoPersonal);

                if (personalValido) {
                    //consulta si el personal y la ficha ya existe
                    Personal personalEntity = personalDAO.consultarPorId(nuevoPersonal.getDocumentopersonal());
                    String tipo=hoja.getCell(5, fila).getContents().toUpperCase();
                   
                    if (personalEntity == null) {
                        personalDAO.insertar(nuevoPersonal);
                        personasInsertadas++; 
                        //Si la persona no existe la agrego y ahora agrega al instructor con el tipo
                        importarInstructor(nuevoPersonal, tipo);
                    
                    } else {                        
                        personasExistentes++;
                        //si la persona ya existe no la crea y va a importar solo el instructor
                        importarInstructor(nuevoPersonal, tipo);  
                    }
                }
                else
                {
                    mensajesError.add("La fila "+(fila+1)+" del archivo no posee todos los datos obligatorios del Instructor. NO pudo ser registrado.");
                }
            } catch (NumberFormatException nfe) {
                mensajesError.add("La fila "+(fila+1)+" del archivo no posee todos los datos obligatorios del Instructor, Instructor No agregado");
            }                                  
        }
        
        System.out.println("Se crearon " + personasInsertadas + " personas");
        System.out.println(personasExistentes + " registros ya existian como personas");
        System.out.println("Se crearon " + instructoresInsertados + " Instructores");
        System.out.println(instructoresExistentes + " registros ya existian como instructores");
        
        List<String> mensajesInfo=new ArrayList<>();    //lista de mensajes de informacion
        mensajesInfo.add("Se crearon " + instructoresInsertados + " Instructores");
        mensajesInfo.add(instructoresExistentes + " registros ya existían como instructores");
        //tabla hash para almacenar las listas de mensajes
        Map mensajes = new HashMap();
        mensajes.put("Errores", mensajesError);        
        mensajes.put("Info", mensajesInfo);        
        
        return mensajes;
    }
    
    public void importarInstructor(Personal persona, String tipo) throws Exception
    {
        Instructor nuevoInstructor=new Instructor();
        nuevoInstructor.setDocumentoinstructor(persona.getDocumentopersonal());
        nuevoInstructor.setPersonal(persona);
        nuevoInstructor.setTipo(tipo);
        
        Instructor instructorEntity=instructorDAO.consultarPorId(nuevoInstructor.getDocumentoinstructor());
        if(instructorEntity == null)
        {
            instructorDAO.insertar(nuevoInstructor);
            instructoresInsertados++;
        }
        else
        {
            instructoresExistentes++;
        }      
    }
}
