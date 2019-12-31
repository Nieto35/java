package co.edu.sena.sael.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author win8
 */
public class GestionProperties {
    private final String TAG=GestionProperties.class.getSimpleName();
   
    public List<String> getPropertiesConstantes(String key) {
        
        List<String> estadosFicha=new LinkedList<>();
        String value="";
        
        try {
            Properties propiedades = new Properties();           
            propiedades.load(getClass().getResourceAsStream("constantes.properties"));
            
            if (!propiedades.isEmpty()) 
            {
                // next value loading defined in condition part
                for(int i = 0; (value = propiedades.getProperty(key + "." + i)) != null; i++) {
                    estadosFicha.add(value);
                }                
            }
            else
            {
                Logger.getLogger(TAG).log(Level.WARNING,"Archivo Properties Vacío");
            }

        } catch (IOException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE,"Error leyendo properties", ex);
        } 
        
        return estadosFicha;
    }

    
}
