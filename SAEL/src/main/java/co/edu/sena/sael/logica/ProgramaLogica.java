/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Programa;
import co.edu.sena.sael.persistencia.IProgramaDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DILOVE
 */
@Stateless
public class ProgramaLogica implements ProgramaLogicaLocal {

    @EJB
    private IProgramaDAO programaDAO;
    
    @Override
    public void registrar(Programa programa) throws Exception {
        validarDatosPrograma(programa);
        //consulta si el programa ya Existe
        Programa entityPrograma = programaDAO.consultarPorId(programa.getCodigoprograma());
        if(entityPrograma!=null){
            throw new Exception("El programa ya existe!"); 
        }        
        programaDAO.insertar(programa);       
    }

    @Override
    public void modificar(Programa programa) throws Exception {
         validarDatosPrograma(programa);
        //consulta si el instructor ya Existe
        Programa entityPrograma = programaDAO.consultarPorId(programa.getCodigoprograma());
        if(entityPrograma==null){
            throw new Exception("El programa a modificar No existe!"); 
        }
        //se envia el objeto entity a modificar porque es quien tiene el valor del cliente si existe
        entityPrograma.setCodigoprograma(programa.getCodigoprograma());
        entityPrograma.setNombre(programa.getNombre());
      
        //Modificar
        programaDAO.modificar(programa);
    }

    @Override
    public void eliminar(Programa programa) throws Exception {
        if(programa==null) {
            throw new Exception("El programa es Nulo!");
        }
        
        if(programa.getCodigoprograma()==0) {
            throw new Exception("El código del programa es obligatoria!");
        }
        //consulta si el programa ya Existe
        Programa entityPrograma=programaDAO.consultarPorId(programa.getCodigoprograma());
        if(entityPrograma==null){
            throw new Exception("El programa no existe!"); 
        }
        
        //Eliminar
        programaDAO.eliminar(entityPrograma);        
    }

    @Override
    public Programa consultarPorId(Integer codPrograma) throws Exception {
         if(codPrograma==null || codPrograma==0){
            throw new Exception("El código es obligatorio!");
        }
        return programaDAO.consultarPorId(codPrograma);
    }

    @Override
    public List<Programa> consultar() throws Exception {
        return programaDAO.consultar();
    }

    private void validarDatosPrograma(Programa programa) throws Exception
    {
        if(programa==null)
        {
            throw new Exception("El programa es nulo!");
        }
        if(programa.getCodigoprograma()==0){
            throw new Exception("El código del programa es obligatoria!");
        }
        if(programa.getNombre()==null || programa.getNombre().equals("")==true) {
            throw new Exception("El nombre es obligatorio!");
        }   
    }

}
