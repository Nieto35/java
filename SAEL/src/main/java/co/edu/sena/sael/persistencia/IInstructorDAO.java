/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Instructor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FELIPE
 */

@Local
public interface IInstructorDAO {
    
    public void eliminar(Instructor instructor) throws Exception;
    public void modificar(Instructor instructor) throws Exception;
    public void insertar(Instructor instructor) throws Exception;
    public Instructor consultarPorId(Long documento) throws Exception;
    public List<Instructor> consultar() throws Exception;
    
}
