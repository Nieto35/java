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
            nuevoPersonal.setNombre(txtNombre.getValue().toString().toUpperCase());
            nuevoPersonal.setApellido(txtApellido.getValue().toString().toUpperCase());
            nuevoPersonal.setCorreo(txtCorreo.getValue().toString().toUpperCase());
            nuevoPersonal.setCorreoinstitucional(txtCorreoInstitucional.getValue().toString().toUpperCase());
            nuevoPersonal.setTelefono(txtTelefono.getValue().toString());            
            //se asigna por defecto como contraseña el numero de documento
            nuevoPersonal.setClave(String.valueOf(documento)); 
            
            //revisa la variable de sesion
            String existePersonal = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("existePersonal");
            if (existePersonal.equals("no")) {
                personalLogica.insertar(nuevoPersonal);
            }else {
                personalLogica.modificar(nuevoPersonal);    //por si el usuario cambia algún dato del personal
            }

            instructor.setDocumentoinstructor(documento);
            instructor.setPersonal(nuevoPersonal);
            instructor.setPerfilocupacional(txtPerfilOcupacional.getValue().toString().toUpperCase());
            instructor.setTipo(cmbTipoInstructor.getValue().toString());

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
            miPersonal.setNombre(txtNombre.getValue().toString().toUpperCase());
            miPersonal.setApellido(txtApellido.getValue().toString().toUpperCase());
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
            txtNombre.setValue(entityPersonal.getNombre());
            txtApellido.setValue(entityPersonal.getApellido());
            txtCorreo.setValue(entityPersonal.getCorreo());
            txtCorreoInstitucional.setValue(entityPersonal.getCorreoinstitucional());
            txtTelefono.setValue(entityPersonal.getTelefono());
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
            txtNombre.setValue(entityInstructor.getPersonal().getNombre());
            txtApellido.setValue(entityInstructor.getPersonal().getApellido());
            txtCorreo.setValue(entityInstructor.getPersonal().getCorreo());
            txtCorreoInstitucional.setValue(entityPersonal.getCorreoinstitucional());
            txtTelefono.setValue(entityInstructor.getPersonal().getTelefono()); 
            txtPerfilOcupacional.setValue(entityInstructor.getPerfilocupacional());
            cmbTipoInstructor.setValue(entityInstructor.getTipo());

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
        txtNombre.setValue(instructor.getPersonal().getNombre());
        txtApellido.setValue(instructor.getPersonal().getApellido());
        txtCorreo.setValue(instructor.getPersonal().getCorreo());
        txtCorreoInstitucional.setValue(instructor.getPersonal().getCorreoinstitucional());
        txtTelefono.setValue(instructor.getPersonal().getTelefono());
        txtPerfilOcupacional.setValue(instructor.getPerfilocupacional());
        cmbTipoInstructor.setValue(instructor.getTipo());

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
