/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Seguimiento;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author Felipe
 */
@Local
public interface SeguimientoLogicaLocal {
    public void insertar(Seguimiento seguimiento) throws Exception;    
    public void modificar(Seguimiento seguimiento) throws Exception;
    public Seguimiento consultarPorId(int codigoseguimiento) throws Exception;
    public List<Seguimiento> consultar() throws Exception;
}
