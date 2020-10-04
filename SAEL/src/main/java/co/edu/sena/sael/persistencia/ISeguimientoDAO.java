/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Seguimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Felipe
 */
@Local
public interface ISeguimientoDAO {
    public void insertar(Seguimiento seguimiento) throws Exception;    
    public void modificar(Seguimiento seguimiento) throws Exception;
    public Seguimiento consultarPorId(int codigoseguimiento) throws Exception;
    public List<Seguimiento> consultar() throws Exception;
}
