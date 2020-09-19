/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Coordinador;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author DILOVE
 */
@Local
public interface CoordinadorLogicaLocal {
    public void registrar(Coordinador coordinador) throws Exception;
    public void modificar(Coordinador  coordinado) throws Exception;
    public void eliminar(Coordinador  coordinado) throws Exception;
    public Coordinador consultarPorId(Long documentocoordinador) throws Exception;
    public List<Coordinador> consultar() throws Exception;
    public Map importarCoordinadores(String archivo) throws Exception;
}

