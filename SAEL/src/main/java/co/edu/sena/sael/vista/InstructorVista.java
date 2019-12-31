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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Felipe
 */
public class InstructorVista {

    @EJB
    private InstructorLogicaLocal instructorLogica;
    @EJB
    private PersonalLogicaLocal personalLogica;
    
    private SelectOneMenu cmbTipoInstructor;
    private InputText txtIdentificacion;
    private InputText txtNombre;
    private InputText txtApellido;
    private InputText txtCorreo;
    private InputText txtCorreoInstitucional;
    private InputText txtTelefono;
    private InputText txtPerfilOcupacional;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    private Instructor selectedInstructor;
    private List<Instructor> listaInstructores = null;
    
    /**
     * Creates a new instance of InstructorVista
     */
    public InstructorVista() {
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

    public InputText getTxtCorreoInstitucional() {
        return txtCorreoInstitucional;
    }

    public void setTxtCorreoInstitucional(InputText txtCorreoInstitucional) {
        this.txtCorreoInstitucional = txtCorreoInstitucional;
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


    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public Instructor getSelectedInstructor() {
        return selectedInstructor;
    }

    public void setSelectedInstructor(Instructor selectedInstructor) {
        this.selectedInstructor = selectedInstructor;
    }

    public List<Instructor> getListaInstructores() {
        if (listaInstructores == null) {
            try {
                setListaInstructores(instructorLogica.consultar());
            } catch (Exception ex) {
                Logger.getLogger(InstructorVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaInstructores;
    }

    public void setListaInstructores(List<Instructor> listaInstructores) {
        this.listaInstructores = listaInstructores;
    }
    
    public void crearAction() {
               
        try {
            Instructor instructor = new Instructor();
            Long documento = Long.parseLong(txtIdentificacion.getValue().toString());
            Personal nuevoPersonal = new Personal();
            nuevoPersonal.setDocumentopersonal(documento);
            nuevoPersonal.setNombrepersonal(txtNombre.getValue().toString().toUpperCase());
            nuevoPersonal.setApellidopersonal(txtApellido.getValue().toString().toUpperCase());
            nuevoPersonal.setCorreopersonal(txtCorreo.getValue().toString().toUpperCase());
            nuevoPersonal.setCorreoinstitucionalpersonal(txtCorreoInstitucional.getValue().toString().toUpperCase());
            nuevoPersonal.setTelefonopersonal(txtTelefono.getValue().toString());            
            //se asigna por defecto como contraseña el numero de documento
            nuevoPersonal.setClavepersonal(String.valueOf(documento)); 
            
            //revisa la variable de sesion
            String existePersonal = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("existePersonal");
            if (existePersonal.equals("no")) {
                personalLogica.insertar(nuevoPersonal);
            }else {
                personalLogica.modificar(nuevoPersonal);    //por si el usuario cambia algún dato del personal
            }

            instructor.setDocumentoinstructor(documento);
            instructor.setPersonal(nuevoPersonal);
            instructor.setPerfilocupacionalinstructor(txtPerfilOcupacional.getValue().toString().toUpperCase());
            instructor.setTipoinstructor(cmbTipoInstructor.getValue().toString());

            instructorLogica.registrar(instructor);            

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "El Instructor se registró con éxito"));

            limpiarAction();
        } catch (NumberFormatException nfe) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "El documento debe ser numérico!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }

        listaInstructores = null;  
    }

    public void modificarAction() {
        //System.out.println("Modificar Instructor");
        
        try {
            Instructor instructor = new Instructor();
            Long documento = Long.parseLong(txtIdentificacion.getValue().toString());
            Personal miPersonal = new Personal();
            miPersonal.setDocumentopersonal(documento);
            miPersonal.setNombrepersonal(txtNombre.getValue().toString().toUpperCase());
            miPersonal.setApellidopersonal(txtApellido.getValue().toString().toUpperCase());
            miPersonal.setCorreopersonal(txtCorreo.getValue().toString().toUpperCase());
            miPersonal.setCorreoinstitucionalpersonal(txtCorreoInstitucional.getValue().toString().toUpperCase());
            miPersonal.setTelefonopersonal(txtTelefono.getValue().toString().toUpperCase());
           
            personalLogica.modificar(miPersonal);

            instructor.setDocumentoinstructor(documento);
            instructor.setPersonal(miPersonal);
            instructor.setTipoinstructor(cmbTipoInstructor.getValue().toString());
            instructor.setPerfilocupacionalinstructor(txtPerfilOcupacional.getValue().toString().toUpperCase());

            instructorLogica.modificar(instructor);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "El Instructor se modificó con éxito"));
            limpiarAction();
        } catch (NumberFormatException nfe) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "El documento debe ser numérico!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }

        listaInstructores = null;         
    }

    public void borrarAction() {
        //System.out.println("Borrar Instructor");
        
        try {

            Long documento = Long.parseLong(txtIdentificacion.getValue().toString());            
            Instructor instructor = new Instructor();           
            instructor.setDocumentoinstructor(documento);
            instructorLogica.eliminar(instructor);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "El Instructor se eliminó con éxito"));
            limpiarAction();
        } catch (NumberFormatException nfe) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "El documento debe ser numérico!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }

        listaInstructores = null;        
    }

    public void limpiarAction() {
        //System.out.println("Limpiar");
        
        cmbTipoInstructor.setValue("-1");
        txtIdentificacion.setValue("");
        txtIdentificacion.setDisabled(false);
        txtNombre.setValue("");
        txtApellido.setValue("");
        txtCorreo.setValue("");
        txtCorreoInstitucional.setValue("");
        txtTelefono.setValue("");
        txtPerfilOcupacional.setValue("");
        btnRegistrar.setDisabled(false);
        btnEliminar.setDisabled(true);
        btnModificar.setDisabled(true);     
    }
    
    public void txtIdentificacionListener() {
        //System.out.println("listener txtIdentificacion Instrcutor");
        Instructor entityInstructor = null;
        Personal entityPersonal = null;

        try {
            Long documento = Long.parseLong(txtIdentificacion.getValue().toString());
            entityPersonal = personalLogica.consultarPorId(documento);
            entityInstructor = instructorLogica.consultarPorId(documento);
        } catch (NumberFormatException nfe) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "El documento debe ser numérico!"));
        } catch (Exception ex) {
            Logger.getLogger(InstructorVista.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
        }

        //si el Instructor no existe limpia los campos y habilita el boton de crear y deshabilita modificar
        //y eliminar
        if (entityPersonal == null) //si la persona no existe
        {
            btnModificar.setDisabled(true);
            btnEliminar.setDisabled(true);
            btnRegistrar.setDisabled(false);

            txtNombre.setValue("");
            txtApellido.setValue("");
            txtCorreo.setValue("");
            txtCorreoInstitucional.setValue("");
            txtTelefono.setValue("");
            txtPerfilOcupacional.setValue("");
            cmbTipoInstructor.setValue("-1");

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("existePersonal", "no");
        } else if (entityInstructor == null) //si la persona existe pero no como instructor
        {
            txtNombre.setValue(entityPersonal.getNombrepersonal());
            txtApellido.setValue(entityPersonal.getApellidopersonal());
            txtCorreo.setValue(entityPersonal.getCorreopersonal());
            txtCorreoInstitucional.setValue(entityPersonal.getCorreoinstitucionalpersonal());
            txtTelefono.setValue(entityPersonal.getTelefonopersonal());
            txtPerfilOcupacional.setValue("");
            cmbTipoInstructor.setValue("-1");

            btnModificar.setDisabled(true);
            btnEliminar.setDisabled(true);
            btnRegistrar.setDisabled(false);
            //el personal ya existe por tanto guarda el estado en una variable de sesion
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("existePersonal", "si");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso: ", "Existen datos personales, para crear el instructor complete sus datos y de clic en Crear"));
        } else //si ya existe como coordinador
        {
            txtNombre.setValue(entityInstructor.getPersonal().getNombrepersonal());
            txtApellido.setValue(entityInstructor.getPersonal().getApellidopersonal());
            txtCorreo.setValue(entityInstructor.getPersonal().getCorreopersonal());
            txtCorreoInstitucional.setValue(entityPersonal.getCorreoinstitucionalpersonal());
            txtTelefono.setValue(entityInstructor.getPersonal().getTelefonopersonal()); 
            txtPerfilOcupacional.setValue(entityInstructor.getPerfilocupacionalinstructor());
            cmbTipoInstructor.setValue(entityInstructor.getTipoinstructor());

            btnModificar.setDisabled(false);
            btnEliminar.setDisabled(false);
            btnRegistrar.setDisabled(true);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("existePersonal", "si");
        }
        
    }

    public void onRowSelect(SelectEvent event) {
        // System.out.println("Selecciono el Instructor");        
        Instructor instructor = (Instructor) event.getObject();    
        txtIdentificacion.setValue(instructor.getDocumentoinstructor());
        txtNombre.setValue(instructor.getPersonal().getNombrepersonal());
        txtApellido.setValue(instructor.getPersonal().getApellidopersonal());
        txtCorreo.setValue(instructor.getPersonal().getCorreopersonal());
        txtCorreoInstitucional.setValue(instructor.getPersonal().getCorreoinstitucionalpersonal());
        txtTelefono.setValue(instructor.getPersonal().getTelefonopersonal());
        txtPerfilOcupacional.setValue(instructor.getPerfilocupacionalinstructor());
        cmbTipoInstructor.setValue(instructor.getTipoinstructor());

        btnRegistrar.setDisabled(true);
        btnEliminar.setDisabled(false);
        btnModificar.setDisabled(false);
        
    }
    
    public void onEliminacionConfirm(ActionEvent actionEvent) {
        borrarAction();
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        //System.out.println("Evento File upload!!!");

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String rutaDestino = (String) servletContext.getRealPath("/excel"); // Sustituye "/" por el directorio ej: "/upload"

        //System.out.println("Ruta Server: " + rutaDestino);
        try {
            copyFile(rutaDestino, event.getFile().getFileName(), event.getFile().getInputstream());
            Map resultado = instructorLogica.importarInstructores(rutaDestino + File.pathSeparator + event.getFile().getFileName());

            List<String> mensajesErrores = (List<String>) resultado.get("Errores");
            List<String> mensajesInfo = (List<String>) resultado.get("Info");

            for (int i = 0; i < mensajesInfo.size(); i++) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok: ", mensajesInfo.get(i)));
            }

            for (int i = 0; i < mensajesErrores.size(); i++) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errores: ", mensajesErrores.get(i)));
            }

        } catch (IOException e) {
            //e.printStackTrace();
            Logger.getLogger(InstructorVista.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception ex) {
            Logger.getLogger(InstructorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void copyFile(String rutaDestino, String fileName, InputStream in) {
        try {
            OutputStream out = new FileOutputStream(new File(rutaDestino + File.pathSeparator + fileName));
            //System.out.println("Ruta Archivo: " + rutaDestino + "\\" +fileName);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            //System.out.println("New file created!");
        } catch (IOException e) {
            Logger.getLogger(InstructorVista.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
