/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Personal;
import co.edu.sena.sael.persistencia.IPersonalDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Felipe
 */
@Stateless
public class UsuarioLogica implements UsuarioLogicaLocal {

    @EJB
    private IPersonalDAO personalDAO;
    
    @Override
    public void autenticar(Personal personal) throws Exception {
        if(personal==null)
        {
            throw new Exception("El personal es nulo!");
        }
        
        if (personal.getDocumentopersonal()== null || personal.getDocumentopersonal()== 0) {
            throw new Exception("El documento es obligatorio!");
        }

        if (personal.getClave()== null || personal.getClave().equals("")) {
            throw new Exception("La contraseña es obligatoria!");
        }
        
        //verifica si el coordinador con ese documento existe
        Personal entity = personalDAO.consultarPorId(personal.getDocumentopersonal());
        if (entity == null) {
            throw new Exception("Usuario incorrecto!");
        }

        //se encripta la contraseña digitada en el logeo antes de compararla en la bd
        String passEncriptado=encriptarContraseña(personal.getClave());        
        //si la contraseña no coincide...
        if (!entity.getClave().equals(passEncriptado)) {
            throw new Exception("Usuario incorrecto!");
        }      
    }

    @Override
    public boolean validarSesion() {
        String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        //System.out.println("usuario: " + user);
        //System.out.println("Tipo usuario: " + (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tipoUsuario"));

        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    public String encriptarContraseña(String password) {
        String encriptMD5 = DigestUtils.md5Hex(password);
        //System.out.println("md5:" + encriptMD5);
        
        return encriptMD5;
    }

    @Override
    public void cambiarContraseña(Long documento, String passOld, String passNew, String passNew2) throws Exception {
        if (passOld == null || passNew == null || passNew2 == null
                || passOld.equals("") || passNew.equals("") || passNew2.equals("")) {
            throw new Exception("La contraseña actual, la nueva y su confirmación son obligatorias!");
        }

        if (!passNew.equals(passNew2)) {
            throw new Exception("La contraseña nueva debe coincidir con su confirmación!");
        }

        //se encripta la contraseña digitada antes de compararla en la bd
        String passEncriptado=encriptarContraseña(passOld);
        
        //verifica si el coordinador con ese documento existe
        Personal entityPersonal=personalDAO.consultarPorId(documento);
        if (entityPersonal == null) {
           throw new Exception("Usuario incorrecto!");
        }
        
        //si la contraseña no coincide
        if (!entityPersonal.getClave().equals(passEncriptado)) {
            throw new Exception("La contraseña otorgada No es correcta para el usuario!");
        }    
        
        
        entityPersonal.setClave(encriptarContraseña(passNew));        
        personalDAO.modificar(entityPersonal);
    }
    
}
