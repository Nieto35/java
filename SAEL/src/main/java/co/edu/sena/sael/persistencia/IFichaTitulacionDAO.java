/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;



import co.edu.sena.sael.modelo.Fichatitulacion;
import co.edu.sena.sael.modelo.Instructor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FELIPE
 */

@Local
public interface IFichaTitulacionDAO {
    
    public void insertar(Fichatitulacion fichaTitulacion) throws Exception;
    public void modificar(Fichatitulacion fichaTitulacion) throws Exception;
    public void eliminar(Fichatitulacion fichaTitulacion) throws Exception;
    public Fichatitulacion consultarPorId(int ficha) throws Exception;
    public List<Fichatitulacion> consultar() throws Exception;
    
    public List<Fichatitulacion> consultarDisponibles(Instructor instructor) throws Exception;
    public List<Fichatitulacion>  consultarAsignadas(Instructor instructor) throws Exception;
    //public void registrarFichas(AsignaFichas asignafichas) throws Exception;
    //public void retirarFichas(AsignaFichas asignafichas) throws Exception;
    
}
