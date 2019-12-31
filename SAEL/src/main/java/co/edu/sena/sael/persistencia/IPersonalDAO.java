/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Personal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FELIPE
 */

@Local
public interface IPersonalDAO {
    
    public void insertar(Personal personal) throws Exception;
    public void modificar(Personal personal) throws Exception;
    public void eliminar(Personal personal) throws Exception; 
    public Personal consultarPorId(Long documento) throws Exception;
    public List<Personal> consultar() throws Exception;
    
}
