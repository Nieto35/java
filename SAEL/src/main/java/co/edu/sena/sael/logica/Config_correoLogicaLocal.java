/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.ConfigCorreo;
import co.edu.sena.sael.persistencia.IConfig_correoDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author digital
 */
@Stateless
public class Config_correoLogicaLocal implements Config_correoLogicaLocalLocal {
    @EJB
    private IConfig_correoDAO config_correoDAO;

    @Override
    public void modificar(ConfigCorreo configCorreo) throws Exception {
        if(configCorreo == null){
            throw new Exception("el configCorreo esta vacia");
        }
        if(configCorreo.getId()== null){
            throw new Exception("el id es obligatoria");
        }
        if(configCorreo.getTipoCorreo()== null){
            throw new Exception("la TipoCorreo es obligatoria");
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
        if(configCorreo.getCredenciales()== null){
            throw new Exception("las Credenciales son obligatoria");
        }
        
        config_correoDAO.insertar(configCorreo);
    }

    @Override
    public void insertar(ConfigCorreo configCorreo) throws Exception {
        if(configCorreo == null){
            throw new Exception("el configCorreo esta vacia");
        }
        if(configCorreo.getId()== null){
            throw new Exception("el id es obligatoria");
        }
        if(configCorreo.getTipoCorreo()== null){
            throw new Exception("la TipoCorreo es obligatoria");
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
        if(configCorreo.getCredenciales()== null){
            throw new Exception("las Credenciales son obligatoria");
        }
        
        ConfigCorreo configCorreoExistente = config_correoDAO.consultarPorId(configCorreo.getId());
        
        if(configCorreoExistente == null){
            throw new Exception("el id del correo  no existe");
        }
        
        configCorreoExistente.setTipoCorreo(configCorreo.getTipoCorreo());
        configCorreoExistente.setStarttls(configCorreo.getStarttls());
        configCorreoExistente.setPuerto(configCorreo.getPuerto());
        configCorreoExistente.setUsuario(configCorreo.getUsuario());
        configCorreoExistente.setClave(configCorreo.getClave());
        configCorreoExistente.setCredenciales(configCorreo.getCredenciales());
         
        config_correoDAO.modificar(configCorreoExistente);
        
        
    }
    
    @Override
    public ConfigCorreo consultarPorId(int id) throws Exception {
        if(id==0){
            throw new Exception("El id es obligatoria!");
        }
        
        return config_correoDAO.consultarPorId(id);
    }
   
    @Override
    public List<ConfigCorreo> consultar() throws Exception {
        return config_correoDAO.consultar();
    }

}
