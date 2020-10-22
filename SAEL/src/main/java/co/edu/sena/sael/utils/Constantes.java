/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public final class Constantes {
    public static final String FICHA_ESTADO_ACTIVA="EN FORMACION";
    public static final String FICHA_ESTADO_1="EN FORMACION";
    public static final String FICHA_ESTADO_2="INDUCCION";
    public static final String FICHA_ESTADO_3="CANCELADO";
    public static final String FICHA_ESTADO_4="RETIRO VOLUNTARIO";
    public static final String FICHA_ESTADO_5="APLAZAMIENTO";
    public static final String FICHA_ESTADO_6="POR CERTIFICAR";
    public static final String FICHA_ESTADO_7="CERTIFICADO";
    public static final String[] LIST_ESTADOS_FORMACION={ "EN FORMACION", "INDUCCION", "CANCELADO", "RETIRO VOLUNTARIO",
                                                          "APLAZAMIENTO", "POR CERTIFICAR", "CERTIFICADO"}; 
    public static final String[] LIST_TIPOS_USUARIO={ "COORDINADOR", "INSTRUCTOR" };
    public static final String[] LIST_JORNADAS_FICHAS={ "DIURNA", "NOCTURNA", "MIXTA" }; 
    public static final String[] LIST_TIPO_INSTRUCTOR={ "CONTRATISTA", "PLANTA" };
    public static final String[] LIST_ESTADO_PROG_SEGUIMIENTO = {"POR APROBAR", "APROBADO", "CANCELADO"};
    
    public static final String[] LIST_PAGES_COORDINADOR={
        "CambiaPassword",
        "aprobar_seguimiento",
        "gestionAprendicesC",
        "gestionFichaAprendizC",
        "gestionFichasC",
        "gestionInstructoresC",
        "gestionSeguimientosC",
        "indexCoordinador",
        "programar_seguimiento",
        "reportes"
    };
    
    public static final String[] LIST_PAGES_INSTRUCTOR = {
        "CambiaPassword",
        "gestionAprendices",
        "gestionInstructores",
        "gestionSeguimientosIns",
        "indexInstructor",
        "programar_seguimiento",
        "reportes"
    };
    
    
    private Constantes(){
        //this prevents even the native class from 
        //calling this ctor as well :
        throw new AssertionError();
    }
}
