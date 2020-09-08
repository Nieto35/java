/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import java.io.PrintWriter;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.StringWriter;

/**
 * ErrorVista
 * @version 1
 * Fecha de última modificación: 
 * @author grupo 6
 */
@Named(value = "errorVista")
@SessionScoped
public class ErrorVista implements Serializable {

    /**
     * Creates a new instance of ErrorVista
     */
    public ErrorVista() {
    }
    
    public String printStackTrace(Throwable exception){
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.toString();
    }
    
}

