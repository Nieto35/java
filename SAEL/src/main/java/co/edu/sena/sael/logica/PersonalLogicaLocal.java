/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Personal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Felipe
 */
@Local
public interface PersonalLogicaLocal {
    public void insertar(Personal personal) throws Exception;
    public void modificar(Personal personal) throws Exception;
    public void eliminar(Personal personal) throws Exception; 
    public Personal consultarPorId(Long documento) throws Exception;
    public List<Personal> consultar() throws Exception;
    public boolean validarDatosPersonal(Personal personal) throws Exception;
}
