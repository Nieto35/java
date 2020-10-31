/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import co.edu.sena.sael.logica.InstructorLogicaLocal;
import co.edu.sena.sael.logica.PersonalLogicaLocal;
import co.edu.sena.sael.modelo.Instructor;
import co.edu.sena.sael.modelo.Personal;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.bootsfaces.component.commandButton.CommandButton;
import net.bootsfaces.component.inputText.InputText;
import net.bootsfaces.component.selectOneMenu.SelectOneMenu;



/**
 *
 * @author Felipe
 */
public class perfilUsuario {

    @EJB
    private InstructorLogicaLocal instructorLogica;
    @EJB
    private PersonalLogicaLocal personalLogica;
    
    private SelectOneMenu cmbTipoInstructor;
    private InputText txtIdentificacion;
    private InputText txtNombre;
    private InputText txtApellido;
    private SelectOneMenu selectSexo;
    private InputText txtCorreo;
    private InputText txtCorreoInstitucional;
    private InputText txtTelefono;
    private InputText txtPerfilOcupacional;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;
   
    
    /**
     * Creates a new instance of InstructorVista
     */
    public perfilUsuario() {
    }

    public SelectOneMenu getSelectSexo() {
        return selectSexo;
    }

    public void setSelectSexo(SelectOneMenu selectSexo) {
        this.selectSexo = selectSexo;
    }

    public SelectOneMenu getCmbTipoInstructor() {
        return cmbTipoInstructor;
    }

    public void setCmbTipoInstructor(SelectOneMenu cmbTipoInstructor) {
        this.cmbTipoInstructor = cmbTipoInstructor;
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

    public InputText getTxtPerfilOcupacional() {
        return txtPerfilOcupacional;
    }

    public void setTxtPerfilOcupacional(InputText txtPerfilOcupacional) {
        this.txtPerfilOcupacional = txtPerfilOcupacional;
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


    public void modificarAction() {
        //System.out.println("Modificar Instructor");
        
        try {
            Instructor instructor = new Instructor();
            Long documento = Long.parseLong(txtIdentificacion.getValue().toString());
            Personal miPersonal = new Personal();
            miPersonal.setDocumentopersonal(documento);
            miPersonal.setNombre(txtNombre.getValue().toString().toUpperCase());
            miPersonal.setApellido(txtApellido.getValue().toString().toUpperCase());
            miPersonal.setSexo((char)(selectSexo.getValue())) ;
            miPersonal.setCorreo(txtCorreo.getValue().toString().toUpperCase());
            miPersonal.setCorreoinstitucional(txtCorreoInstitucional.getValue().toString().toUpperCase());
            miPersonal.setTelefono(txtTelefono.getValue().toString().toUpperCase());
           
            personalLogica.modificar(miPersonal);

            instructor.setDocumentoinstructor(documento);
            instructor.setPersonal(miPersonal);
            instructor.setTipo(cmbTipoInstructor.getValue().toString());
            instructor.setPerfilocupacional(txtPerfilOcupacional.getValue().toString().toUpperCase());

            instructorLogica.modificar(instructor);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "El Instructor se modificó con éxito"));
            limpiarAction();
        } catch (NumberFormatException nfe) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "El documento debe ser numérico!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }
       
    }

    public void limpiarAction() {
        //System.out.println("Limpiar");
        
        cmbTipoInstructor.setValue("-1");
        txtIdentificacion.setValue("");
        txtIdentificacion.setDisabled(false);
        txtNombre.setValue("");
        txtApellido.setValue("");
        selectSexo.setValue("");
        txtCorreo.setValue("");
        txtCorreoInstitucional.setValue("");
        txtTelefono.setValue("");
        txtPerfilOcupacional.setValue("");
        btnModificar.setDisabled(true);     
    }
 
}
