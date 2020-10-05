/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Programarseguimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Felipe
 */
@Local
public interface ProgramarSeguimientoLogicaLocal {
    public void modificar(Programarseguimiento programarSeguimiento) throws Exception;
    public void insertar(Programarseguimiento programarSeguimiento) throws Exception;
    public Programarseguimiento consultarPorId(int id) throws Exception;
    public List<Programarseguimiento> consultar() throws Exception;
    public List<Programarseguimiento> consultarPorEstado(String estado) throws Exception;  
}
