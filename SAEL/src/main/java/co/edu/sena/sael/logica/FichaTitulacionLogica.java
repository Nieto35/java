/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;


import co.edu.sena.sael.modelo.Fichatitulacion;
import co.edu.sena.sael.modelo.Instructor;
import co.edu.sena.sael.persistencia.IFichaTitulacionDAO;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DILOVE
 */
@Stateless
public class FichaTitulacionLogica implements FichaTitulacionLogicaLocal {

    @EJB
    private IFichaTitulacionDAO fichaDAO;
    
    @Override
    public void registrar(Fichatitulacion ficha) throws Exception {
        validarDatosFicha(ficha);
        //consulta si la ficha ya Existe
        Fichatitulacion entityFichaTitulacion = fichaDAO.consultarPorId(ficha.getNumeroficha());
        if(entityFichaTitulacion!=null){
            throw new Exception("La ficha ya existe!"); 
        }
        
        fichaDAO.insertar(ficha);        
    }

    @Override
    public void modificar(Fichatitulacion ficha) throws Exception {
        validarDatosFicha(ficha);
        //consulta si el instructor ya Existe
        Fichatitulacion entityFicha = fichaDAO.consultarPorId(ficha.getNumeroficha());
        if(entityFicha==null){
            throw new Exception("La ficha no existe!"); 
        }
        //se envia el objeto entity a modificar porque es quien tiene el valor del cliente si existe
        entityFicha.setNumeroficha(ficha.getNumeroficha());
        entityFicha.setJornada(ficha.getJornada());
        entityFicha.setCodigoprograma(ficha.getCodigoprograma());
        entityFicha.setDocumentoinstructor(ficha.getDocumentoinstructor());
        entityFicha.setFechainicio(ficha.getFechainicio());
        entityFicha.setFechafin(ficha.getFechafin());
        //Modificar
        fichaDAO.modificar(entityFicha);
    }

    @Override
    public void eliminar(Fichatitulacion ficha) throws Exception {
        if(ficha==null) {
            throw new Exception("La ficha es nula!");
        }
        
        if(ficha.getNumeroficha()==0) {
            throw new Exception("La ficha es obligatoria!");
        }
        //consulta si la ficha ya Existe
        Fichatitulacion entityFicha = fichaDAO.consultarPorId(ficha.getNumeroficha());
        if(entityFicha==null){
            throw new Exception("La ficha no existe!"); 
        }
        //Eliminar
        fichaDAO.eliminar(entityFicha);
    }

    @Override
    public Fichatitulacion consultarPorId(Integer fichatitulacion) throws Exception {
        if(fichatitulacion==null || fichatitulacion==0){
            throw new Exception("La Ficha es Obligatoria!");
        }
        return fichaDAO.consultarPorId(fichatitulacion);
    }

    @Override
    public List<Fichatitulacion> consultar() throws Exception {
       return fichaDAO.consultar();
    }

    private void validarDatosFicha(Fichatitulacion fichatitulacion) throws Exception
    {
        if(fichatitulacion==null)
        {
            throw new Exception("La ficha es nula!");
        }
        if(fichatitulacion.getNumeroficha()==0){
            throw new Exception("La ficha es obligatoria!");
        }
        if(fichatitulacion.getJornada()==null || fichatitulacion.getJornada().equals("")==true) {
            throw new Exception("La jornada es obligatoria!");
        } 
        if(fichatitulacion.getCodigoprograma()==null) {
            throw new Exception("El programa de formación es obligatorio!");
        } 
    }

    @Override
    public List<Fichatitulacion> consultarDisponibles(Instructor instructor) throws Exception{
        return fichaDAO.consultarDisponibles(instructor);
    }

    @Override
    public List<Fichatitulacion> consultarAsignadas(Instructor instructor) throws Exception {
        return fichaDAO.consultarAsignadas(instructor);
    }

    @Override
    public List<Fichatitulacion> consultarFichasDisponibles(Date fechaActual) throws Exception {
        return fichaDAO.consultarFichasDisponibles(fechaActual);
    }

    

}
