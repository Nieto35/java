/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Fichatitulacion;
import co.edu.sena.sael.modelo.Instructor;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DILOVE
 */
@Local
public interface FichaTitulacionLogicaLocal {
    public void registrar(Fichatitulacion ficha) throws Exception;
    public void modificar(Fichatitulacion ficha) throws Exception;
    public void eliminar(Fichatitulacion ficha) throws Exception;
    //public void asignarFichas(AsignaFichas asignafichas) throws Exception;
    //public void retirarFichas(AsignaFichas asignafichas) throws Exception;
    public Fichatitulacion consultarPorId(Integer fichatitulacion) throws Exception;
    public List<Fichatitulacion> consultar() throws Exception;
    public List<Fichatitulacion> consultarDisponibles(Instructor instructor) throws Exception;
    public List<Fichatitulacion> consultarAsignadas(Instructor instructor) throws Exception;
    public List<Fichatitulacion> consultarFichasDisponibles(Date fechaActual) throws Exception;
}
