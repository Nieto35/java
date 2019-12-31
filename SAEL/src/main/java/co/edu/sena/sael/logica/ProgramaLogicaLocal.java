/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Programa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DILOVE
 */
@Local
public interface ProgramaLogicaLocal {
    public void registrar(Programa programa) throws Exception;
    public void modificar(Programa programa) throws Exception;
    public void eliminar(Programa programa) throws Exception;
    public Programa consultarPorId(Integer codPrograma) throws Exception;
    public List<Programa> consultar() throws Exception;
}
