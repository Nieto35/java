/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Programarseguimiento;
import co.edu.sena.sael.persistencia.IProgramarSeguimientoDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DILOVE
 */
@Stateless
public class ProgramarSeguimientoLogica implements ProgramarSeguimientoLogicaLocal {
    
    @EJB
    private IProgramarSeguimientoDAO programarSeguimientoDAO;

    @Override
    public void insertar(Programarseguimiento programarSeguimiento) throws Exception {
        if(programarSeguimiento == null){
            throw new Exception("la programarSeguimiento esta vacia");
        }
        if(programarSeguimiento.getFecha() == null){
            throw new Exception("la fecha es obligatoria");
        }
        if(programarSeguimiento.getHoraInicio()== null){
            throw new Exception("La hora de inicio es obligatorio");
        }
        if(programarSeguimiento.getHoraFinal()== null){
            throw new Exception("La hora final es obligatorio");
        }
        if(programarSeguimiento.getIdCoordinador()== null){
            throw new Exception("el id programarSeguimientor es obligatorio");
        }
        if(programarSeguimiento.getDocumentoPersonal()== null){
            throw new Exception("el documento personal es obligatorio");
        }
        if(programarSeguimiento.getNumeroFicha()== null){
            throw new Exception("el numero de ficha es obligatorio");
        }
        
        programarSeguimientoDAO.insertar(programarSeguimiento);
    }

    @Override
    public void modificar(Programarseguimiento programarSeguimiento) throws Exception {
        
        if(programarSeguimiento == null){
            throw new Exception("la programarSeguimiento esta vacia");
        }
        if(programarSeguimiento.getFecha() == null){
            throw new Exception("la fecha es obligatoria");
        }
        if(programarSeguimiento.getHoraInicio()== null){
            throw new Exception("La hora de inicio es obligatorio");
        }
        if(programarSeguimiento.getHoraFinal()== null){
            throw new Exception("La hora final es obligatorio");
        }
        if(programarSeguimiento.getIdCoordinador()== null){
            throw new Exception("el id programarSeguimientor es obligatorio");
        }
        if(programarSeguimiento.getDocumentoPersonal()== null){
            throw new Exception("el documento personal es obligatorio");
        }
        
        if(programarSeguimiento.getId()== null){
            throw new Exception("el id es obligatorio");
        }
        
        if(programarSeguimiento.getNumeroFicha()== null){
            throw new Exception("el numero de ficha es obligatorio");
        }
        
        Programarseguimiento programarSeguimientoExistente = programarSeguimientoDAO.consultarPorId(programarSeguimiento.getId());
        
        if(programarSeguimientoExistente == null){
            throw new Exception("el id de programar Seguimiento no existe");
        }
        
        programarSeguimientoExistente.setFecha(programarSeguimiento.getFecha());
        programarSeguimientoExistente.setHoraInicio(programarSeguimiento.getHoraInicio());
        programarSeguimientoExistente.setHoraFinal(programarSeguimiento.getHoraFinal());
        programarSeguimientoExistente.setDocumentoPersonal(programarSeguimiento.getDocumentoPersonal());
        programarSeguimientoExistente.setIdCoordinador(programarSeguimiento.getIdCoordinador());
        programarSeguimientoExistente.setEstado(programarSeguimiento.getEstado());
         
        programarSeguimientoDAO.modificar(programarSeguimientoExistente);
    }

   

    @Override
    public Programarseguimiento consultarPorId(int id) throws Exception {
        if(id==0){
            throw new Exception("El id es obligatoria!");
        }
        
        return programarSeguimientoDAO.consultarPorId(id);
    }
   
    @Override
    public List<Programarseguimiento> consultar() throws Exception {
        return programarSeguimientoDAO.consultar();
    }

    @Override
    public List<Programarseguimiento> consultarPorEstado(String estado) throws Exception {
        System.out.println("estado: " + estado );
        return programarSeguimientoDAO.consultarPorEstado(estado);
    }


}

    