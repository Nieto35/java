/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Personal;
import javax.ejb.Local;

/**
 *
 * @author Felipe
 */
@Local
public interface UsuarioLogicaLocal {
    public void autenticar(Personal personal)throws Exception; 
    public boolean validarSesion();
    public void cambiarContraseña(Long documento, String passOld, String passNew, String passNew2) throws Exception;
}
