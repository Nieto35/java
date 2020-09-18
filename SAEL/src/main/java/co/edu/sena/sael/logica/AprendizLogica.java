/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Aprendiz;
import co.edu.sena.sael.modelo.Fichatitulacion;
import co.edu.sena.sael.modelo.Personal;
import co.edu.sena.sael.persistencia.IAprendizDAO;
import co.edu.sena.sael.persistencia.IFichaTitulacionDAO;
import co.edu.sena.sael.persistencia.IPersonalDAO;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author Felipe
 */
@Stateless
public class AprendizLogica implements AprendizLogicaLocal {
    @EJB
    private IAprendizDAO aprendizDAO;
    @EJB
    private IPersonalDAO personalDAO;
    @EJB
    private IFichaTitulacionDAO fichaTitulacionDAO;
    @EJB
    private PersonalLogicaLocal personalLogica;
    
    private int personasInsertadas = 0;
    private int personasExistentes = 0;
    private int aprendicesInsertados=0;    
    private int aprendicesExistentes=0; 

    @Override
    public void registrar(Aprendiz aprendiz) throws Exception {
        if (aprendiz == null) {
            throw new Exception("El aprendiz es nulo");
        }

        //consulta si el aprendiz ya Existe
        Aprendiz entityAprendiz = aprendizDAO.consultarPorId(aprendiz.getDocumentoaprendiz());
        if (entityAprendiz != null) {
            throw new Exception("El aprendiz ya existe");
        }

        aprendizDAO.insertar(aprendiz);
    }

    @Override
    public void modificar(Aprendiz aprendiz) throws Exception {
        if (aprendiz == null) {
            throw new Exception("El aprendiz es nulo");
        }
        //consulta si el instructor ya Existe
        Aprendiz entityAprendiz = aprendizDAO.consultarPorId(aprendiz.getDocumentoaprendiz());
        if (entityAprendiz == null) {
            throw new Exception("El aprendiz no existe");
        }
        //se envia el objeto entity a modificar porque es quien tiene el valor del cliente si existe
        entityAprendiz.setEstado(aprendiz.getEstado());
        //Modificar                
        aprendizDAO.modificar(aprendiz);
    }

    @Override
    public void eliminar(Aprendiz aprendiz) throws Exception {
        if (aprendiz == null) {
            throw new Exception("El aprendiz es nulo");
        }

        if (aprendiz.getDocumentoaprendiz() == null || aprendiz.getDocumentoaprendiz() == 0) {
            throw new Exception("La identificación es obligatoria");
        }
        //consulta si el instructor ya Existe
        Aprendiz entityAprendiz = aprendizDAO.consultarPorId(aprendiz.getDocumentoaprendiz());
        if (entityAprendiz == null) {
            throw new Exception("El aprendiz no existe");
        }
        //Eliminar               
        aprendizDAO.eliminar(entityAprendiz);
    }

    @Override
    public Aprendiz consultarPorId(Long documentoaprendiz) throws Exception {
        if (documentoaprendiz == null || documentoaprendiz == 0) {
            throw new Exception("La Identificación es obligatoria");
        }

        return aprendizDAO.consultarPorId(documentoaprendiz);
    }

    @Override
    public List<Aprendiz> consultar() throws Exception {
        return aprendizDAO.consultar();
    }

    @Override
    public Map importarAprendices(String archivo) throws Exception {
        Workbook archivoExcel = Workbook.getWorkbook(new File(archivo));
        //System.out.println("Número de Hojas\t" + archivoExcel.getNumberOfSheets());
        //Recorrer las filas de la primera hoja
        Sheet hoja = archivoExcel.getSheet(0);
        int numColumnas = hoja.getColumns();
        int numFilas = hoja.getRows();
        //System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(0).getName());
        //System.out.println("Número de Filas\t" + hoja.getRows());

        personasInsertadas = 0;
        personasExistentes = 0;
        aprendicesInsertados=0;    
        aprendicesExistentes=0; 
                
        List<String> mensajesError=new ArrayList<String>(); //lista de mensajes de error

        for (int fila = 1; fila < numFilas; fila++) { // Recorre cada 
            Personal nuevoPersonal = new Personal();
            try {
                nuevoPersonal.setDocumentopersonal(Long.parseLong(hoja.getCell(0, fila).getContents()));
                nuevoPersonal.setNombre(hoja.getCell(1, fila).getContents());
                nuevoPersonal.setApellido(hoja.getCell(2, fila).getContents());
                nuevoPersonal.setCorreoinstitucional(hoja.getCell(3, fila).getContents());
                nuevoPersonal.setTelefono(hoja.getCell(4, fila).getContents());
                nuevoPersonal.setClave(hoja.getCell(0, fila).getContents());
                boolean personalValido = personalLogica.validarDatosPersonal(nuevoPersonal);

                if (personalValido) {
                    //consulta si el personal y la ficha ya existe
                    Personal personalEntity = personalDAO.consultarPorId(nuevoPersonal.getDocumentopersonal());
                    //TODO
                    //Fichatitulacion fichaEntity=fichaTitulacionDAO.consultarPorId(Integer.parseInt(hoja.getCell(5, fila).getContents()));
                   Fichatitulacion fichaEntity=null;
                    if (personalEntity == null) {
                        personalDAO.insertar(nuevoPersonal);
                        personasInsertadas++;                        
                        
                        if (fichaEntity == null)
                        {
                            mensajesError.add("La fila "+(fila+1)+" del archivo no posee una Ficha existente en el sistema, No fue agregado como Aprendiz");
                        }
                        else
                        {
                            //si la persona no existe y la ficha existe importa al aprendiz
                            importarAprendiz(nuevoPersonal, fichaEntity);        
                        }
                    
                    } else {                        
                        personasExistentes++;
                        //si la persona ya existe y la ficha existe se importa el aprendiz
                        importarAprendiz(nuevoPersonal, fichaEntity);  
                    }
                }
                else
                {
                    mensajesError.add("La fila "+(fila+1)+" del archivo no posee todos los datos obligatorios del aprendiz, No fue agregado como Aprendiz");
                }
            } catch (NumberFormatException nfe) {
                mensajesError.add("La fila "+(fila+1)+" del archivo no posee todos los datos obligatorios del aprendiz, Aprendiz No agregado");
            }
                                  
        }
        
        /*System.out.println("Se crearon " + personasInsertadas + " personas");
        System.out.println(personasExistentes + " registros ya existian como personas");
        System.out.println("Se crearon " + aprendicesInsertados + " aprendices");
        System.out.println(aprendicesExistentes + " registros ya existian como aprendices");*/
        
        List<String> mensajesInfo=new ArrayList<>();    //lista de mensajes de informacion
        mensajesInfo.add("Se crearon " + aprendicesInsertados + " Aprendices");
        mensajesInfo.add(aprendicesExistentes + " registros ya existían como Aprendices");
        //tabla hash para almacenar las listas de mensajes
        Map mensajes = new HashMap();
        mensajes.put("Errores", mensajesError);        
        mensajes.put("Info", mensajesInfo);        
        
        return mensajes;
    }
    
    public void importarAprendiz(Personal persona, Fichatitulacion ficha) throws Exception
    {
        Aprendiz nuevoAprendiz=new Aprendiz();
        nuevoAprendiz.setPersonal(persona);
        //TODO: pendiente agregar fichas
        //nuevoAprendiz.setFichatitulacion(ficha);
        
        Aprendiz aprendizEntity=aprendizDAO.consultarPorId(persona.getDocumentopersonal());
        if(aprendizEntity == null)
        {
            aprendizDAO.insertar(nuevoAprendiz);
            aprendicesInsertados++;
        }
        else
        {
            aprendicesExistentes++;
        }      
    }
    
}
