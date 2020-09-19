/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Coordinador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FELIPE
 */

@Local
public interface ICoordinadorDAO {
    
    public void eliminar(Coordinador coordinador) throws Exception;
    public void modificar(Coordinador coordinador) throws Exception;
    public void insertar(Coordinador coordinador) throws Exception;
    public Coordinador consultarPorId(Long documentocoordinador) throws Exception;
    public List<Coordinador> consultar() throws Exception;
    
}
