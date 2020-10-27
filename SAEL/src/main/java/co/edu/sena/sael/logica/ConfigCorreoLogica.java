/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.ConfigCorreo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import co.edu.sena.sael.persistencia.IConfigCorreoDAO;

/**
 *
 * @author digital
 */
@Stateless
public class ConfigCorreoLogica implements ConfigCorreoLogicaLocal {
    @EJB
    private IConfigCorreoDAO configCorreoDAO;


    @Override
    public void modificar(ConfigCorreo configCorreo) throws Exception {
        if(configCorreo == null){
            throw new Exception("el configCorreo esta vacia");
        }
        
        if(configCorreo.getSmtp()== null){
            throw new Exception("el TipoCorreo es obligatoria");
        }
        if(configCorreo.getStarttls()== null){
            throw new Exception("la Starttls es obligatoria");
        }
        if(configCorreo.getPuerto()== 0){
            throw new Exception("el Puerto es obligatoria");
        }
        if(configCorreo.getUsuario()== null){
            throw new Exception("el Usuario es obligatoria");
        }
        if(configCorreo.getClave()== null){
            throw new Exception("la Clave es obligatoria");
        }
        if(configCorreo.getAuth()== null){
            throw new Exception("las Credenciales son obligatoria");
        }
        
        ConfigCorreo configCorreoExistente = configCorreoDAO.consultarPorId(configCorreo.getId());
        
        if(configCorreoExistente == null){
            throw new Exception("el id del correo no existe");
        }
        
        configCorreo.setId(configCorreoExistente.getId());
        configCorreo.setSmtp(configCorreoExistente.getSmtp());
        configCorreo.setStarttls(configCorreoExistente.getStarttls());
        configCorreo.setPuerto(configCorreoExistente.getPuerto());
        configCorreo.setUsuario(configCorreoExistente.getUsuario());
        configCorreo.setClave(configCorreoExistente.getClave());
        configCorreo.setAuth(configCorreoExistente.getAuth());
         
        configCorreoDAO.modificar(configCorreoExistente);
        
        
    }
    
    @Override
    public ConfigCorreo consultarPorId(int id) throws Exception {
        if(id==0){
            throw new Exception("El id es obligatoria!");
        }
        
        return configCorreoDAO.consultarPorId(id);
    }
   
    @Override
    public List<ConfigCorreo> consultar() throws Exception {
        return configCorreoDAO.consultar();
    }

}
