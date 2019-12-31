/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Programa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FELIPE
 */

@Local
public interface IProgramaDAO {
    
    public void insertar(Programa programa) throws Exception;
    public void modificar(Programa programa) throws Exception;
    public void eliminar(Programa programa) throws Exception;
    public Programa consultarPorId(Integer codigoprograma) throws Exception;
    public List<Programa> consultar() throws Exception;
    
}
