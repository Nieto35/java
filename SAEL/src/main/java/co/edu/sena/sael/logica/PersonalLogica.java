/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Personal;
import co.edu.sena.sael.persistencia.IPersonalDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Felipe
 */
@Stateless
public class PersonalLogica implements PersonalLogicaLocal {

    @EJB
    private IPersonalDAO personalDAO;

    @Override
    public void insertar(Personal personal) throws Exception {

        validarDatos(personal);
        
        if (personal.getClave() == null || personal.getClave().equals("") == true) {
            throw new Exception("La clave es obligatoria!");
        }

        //consulta si el personal ya existe
        Personal entity = personalDAO.consultarPorId(personal.getDocumentopersonal());
        if (entity != null) {
            throw new Exception("El personal ya existe!");
        }

        //se encripta la contraseña digitada
        String passEncriptado = encriptarContraseña(personal.getClave());
        personal.setClave(passEncriptado);

        personalDAO.insertar(personal);
    }

    @Override
    public void modificar(Personal personal) throws Exception {
        //validaciones
        
        validarDatos(personal);

        /*if(personal.getClave()==null || personal.getClave().equals("")==true) {
            throw new Exception("La clave es obligatoria!");
        }*/
        //consulta si el personal ya Existe
        Personal entityPersonal = personalDAO.consultarPorId(personal.getDocumentopersonal());
        if (entityPersonal == null) {
            throw new Exception("El personal no existe!");
        }

        entityPersonal.setNombre(personal.getNombre());
        entityPersonal.setApellido(personal.getApellido());
        entityPersonal.setCorreo(personal.getCorreo());
        entityPersonal.setCorreoinstitucional(personal.getCorreoinstitucional());
        entityPersonal.setTelefono(personal.getTelefono());

        //modificar
        personalDAO.modificar(entityPersonal);
    }

    @Override
    public void eliminar(Personal personal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personal consultarPorId(Long documento) throws Exception {
        if (documento == null || documento == 0) {
            throw new Exception("La Identificación es Obligatoria!");
        }

        return personalDAO.consultarPorId(documento);
    }

    @Override
    public List<Personal> consultar() throws Exception {
        return personalDAO.consultar();
    }
    
    
    // valida la info del personal, ya sea aprendiz o instructor
    @Override
    public boolean validarDatosPersonal(Personal personal) throws Exception {
        //validaciones
        if (personal == null) {
            return false;
        }

        if (personal.getDocumentopersonal() == null || personal.getDocumentopersonal() == 0) {
            return false;
        }

        if (personal.getNombre() == null || personal.getNombre().equals("") == true) {
            return false;
        }

        if (personal.getApellido() == null || personal.getApellido().equals("") == true) {
            return false;
        }

        if (personal.getClave() == null || personal.getClave().equals("") == true) {
            return false;
        }

        return true;
    }
    
    /**
     * valida los datos obligatorios a la hora de crear o modificar el personal
     * @param personal
     * @throws Exception 
     */
    public void validarDatos(Personal personal) throws Exception {
        //validaciones
        if (personal == null) {
            throw new Exception("El Personal es nulo!");
        }

        if (personal.getDocumentopersonal() == null || personal.getDocumentopersonal() == 0) {
            throw new Exception("La identificación es obligatoria!");
        }

        if (personal.getNombre() == null || personal.getNombre().equals("") == true) {
            throw new Exception("El nombre es obligatorio!");
        }

        if (personal.getApellido() == null || personal.getApellido().equals("") == true) {
            throw new Exception("El apellido es obligatorio!");
        }


    }

    public String encriptarContraseña(String password) {
        String encriptMD5 = DigestUtils.md5Hex(password);
        //System.out.println("md5:" + encriptMD5);

        return encriptMD5;
    }

}
