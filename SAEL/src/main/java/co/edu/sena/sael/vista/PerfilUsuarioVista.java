/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import co.edu.sena.sael.logica.PersonalLogicaLocal;
import co.edu.sena.sael.modelo.Personal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.bootsfaces.component.commandButton.CommandButton;
import net.bootsfaces.component.inputText.InputText;
import net.bootsfaces.component.selectOneMenu.SelectOneMenu;

/**
 * @version 1
 * @author g1
 * fecha de modificacion: 01/11/2020
 */
@Named(value = "perfilUsuarioVista")
@RequestScoped
public class PerfilUsuarioVista {
    
     @EJB
    private PersonalLogicaLocal personalLogica;
    
   
    private InputText txtIdentificacion;
    private InputText txtNombre;
    private InputText txtApellido;
    private InputText txtCorreo;
    private InputText txtTelefono;
    private SelectOneMenu selectSexo;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;

    /**
     * Creates a new instance of PerfilUsuarioVista
     */
    public PerfilUsuarioVista() {
    }

    public SelectOneMenu getSelectSexo() {
        return selectSexo;
    }

    public void setSelectSexo(SelectOneMenu selectSexo) {
        this.selectSexo = selectSexo;
    }
    
    
    public InputText getTxtIdentificacion() {
        return txtIdentificacion;
    }

    public void setTxtIdentificacion(InputText txtIdentificacion) {
        this.txtIdentificacion = txtIdentificacion;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(InputText txtApellido) {
        this.txtApellido = txtApellido;
    }


    public InputText getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(InputText txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
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
    
    
    public void limpiarAction() {
        
        txtNombre.setValue("");
        txtApellido.setValue("");
        txtCorreo.setValue("");
        txtTelefono.setValue("");
    
    }
    
      public void modificarAction() {
        //System.out.println("Modificar Instructor");
        
        try {
            
            Long documento = Long.parseLong(txtIdentificacion.getValue().toString());
            Personal miPersonal = new Personal();
            miPersonal.setDocumentopersonal(documento);
            miPersonal.setNombre(txtNombre.getValue().toString().toUpperCase());
            miPersonal.setApellido(txtApellido.getValue().toString().toUpperCase());
            miPersonal.setCorreo(txtCorreo.getValue().toString().toUpperCase());
            miPersonal.setTelefono(txtTelefono.getValue().toString().toUpperCase());
            String  sexo = selectSexo.getValue().toString();
           char caracter = sexo.charAt(0);
            miPersonal.setSexo(caracter);
            personalLogica.modificar(miPersonal);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "El perfil se modificó con éxito"));
            
        } catch (NumberFormatException nfe) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "El documento debe ser numérico!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }

        
    }
    
    
    

    
}
