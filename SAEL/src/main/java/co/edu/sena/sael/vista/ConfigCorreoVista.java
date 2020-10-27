/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import co.edu.sena.sael.logica.ConfigCorreoLogicaLocal;
import co.edu.sena.sael.modelo.ConfigCorreo;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.bootsfaces.component.commandButton.CommandButton;
import net.bootsfaces.component.inputText.InputText;

/**
 *
 * @author Yorgueson Matasea
 */
public class ConfigCorreoVista {
    
    @EJB
    private ConfigCorreoLogicaLocal configCorreoLogica;  //aqui siemore se llama a LogicaLocal
    
    private InputText txtIdConfigCorreo;
    private InputText txtSmpt;
    private InputText txtStarttls;
    private InputText txtPuerto;
    private InputText txtUsuario;
    private InputText txtClave;
    private InputText txtAuth;
    private List<ConfigCorreo> listaConfigCorreo = null;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;

    public InputText getTxtIdConfigCorreo() {
        return txtIdConfigCorreo;
    }

    public void setTxtIdConfigCorreo(InputText txtIdConfigCorreo) {
        this.txtIdConfigCorreo = txtIdConfigCorreo;
    }

    public InputText getTxtSmpt() {
        return txtSmpt;
    }

    public void setTxtSmpt(InputText txtSmpt) {
        this.txtSmpt = txtSmpt;
    }



    public InputText getTxtStarttls() {
        return txtStarttls;
    }

    public void setTxtStarttls(InputText txtStarttls) {
        this.txtStarttls = txtStarttls;
    }

    public InputText getTxtPuerto() {
        return txtPuerto;
    }

    public void setTxtPuerto(InputText txtPuerto) {
        this.txtPuerto = txtPuerto;
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public InputText getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(InputText txtClave) {
        this.txtClave = txtClave;
    }

    public InputText getTxtAuth() {
        return txtAuth;
    }

    public void setTxtAuth(InputText txtAuth) {
        this.txtAuth = txtAuth;
    }



    public List<ConfigCorreo> getListaConfigCorreo() {
        
        if (listaConfigCorreo == null) {
            try {
                setListaConfigCorreo(configCorreoLogica.consultar());
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
            }
        }
        
        return listaConfigCorreo;
    }

    public void setListaConfigCorreo(List<ConfigCorreo> listaConfigCorreo) {
        this.listaConfigCorreo = listaConfigCorreo;
    }


    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public ConfigCorreoVista() {
    }
    
    public void limpiarAction() { 
        txtIdConfigCorreo.setValue("");
        txtIdConfigCorreo.setReadonly(false);
        txtSmpt.setValue("");
        txtStarttls.setValue("");
        txtUsuario.setValue("");
        txtClave.setValue("");
        txtAuth.setValue("");
        btnModificar.setDisabled(true);      
    }
    
    
    public void modificarAction() {
        
        try {
            //Modificar       
            ConfigCorreo configCorreo = new ConfigCorreo();
            configCorreo.setId(Integer.parseInt(txtIdConfigCorreo.getValue().toString()));
            configCorreo.setSmpt(txtSmpt.getValue().toString());
            configCorreo.setStarttls((txtStarttls.getValue().toString()));
            configCorreo.setPuerto(Integer.parseInt(txtPuerto.getValue().toString()));
            configCorreo.setUsuario(txtUsuario.getValue().toString());
            configCorreo.setClave(txtClave.getValue().toString());
            configCorreo.setAuth(txtAuth.getValue().toString());

            configCorreoLogica.modificar(configCorreo);                

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "Se modificó con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }
        
        setListaConfigCorreo(null);
    }
    
    public void cargarDatos() throws Exception{
        
        ConfigCorreo configCorreo = configCorreoLogica.consultar().get(0);
        
        txtIdConfigCorreo.setValue(configCorreo.getId().toString());
        txtIdConfigCorreo.setReadonly(true);
        txtSmpt.setValue(configCorreo.getSmtp());
        txtStarttls.setValue(configCorreo.getStarttls());
        txtPuerto.setValue(configCorreo.getPuerto());
        txtUsuario.setValue(configCorreo.getUsuario());
        txtClave.setValue(configCorreo.getClave());
        txtAuth.setValue(configCorreo.getAuth());
        btnModificar.setDisabled(false);
        
    }
    
}
