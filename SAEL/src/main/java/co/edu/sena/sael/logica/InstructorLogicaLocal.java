/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Instructor;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author DILOVE
 */
@Local
public interface InstructorLogicaLocal {
    public void registrar(Instructor instructor) throws Exception;
    public void modificar(Instructor instructor) throws Exception;
    public void eliminar(Instructor instructor) throws Exception;
    public Instructor consultarPorId(Long documentoinstructor) throws Exception;
    public List<Instructor> consultar() throws Exception;
    public Map importarInstructores(String archivo) throws Exception;
}
