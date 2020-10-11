/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import co.edu.sena.sael.logica.FichaTitulacionLogicaLocal;
import co.edu.sena.sael.logica.InstructorLogicaLocal;
import co.edu.sena.sael.logica.ProgramaLogicaLocal;
import co.edu.sena.sael.modelo.Fichatitulacion;
import co.edu.sena.sael.modelo.Instructor;
import co.edu.sena.sael.modelo.Programa;
import co.edu.sena.sael.utils.Constantes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import net.bootsfaces.component.commandButton.CommandButton;
import net.bootsfaces.component.inputText.InputText;
import net.bootsfaces.component.selectOneMenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Felipe
 */
public class FichasVista {
    
    @EJB
    private FichaTitulacionLogicaLocal fichaLogica;  
    @EJB
    private ProgramaLogicaLocal programaLogica;  
    @EJB
    private InstructorLogicaLocal instructorLogica;
    
    private InputText txtDocumento;
    private String txtNombreInstructor;
    private InputText txtFicha;
    private Date fechaInicio;
    private Date fechaFin;
    private SelectOneMenu cmbPrograma;
    private SelectOneMenu cmbJornada;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    private Fichatitulacion selectedFicha;
    private List<Fichatitulacion> listaFichas = null; 
    private String[] listaJornadas = Constantes.LIST_JORNADAS_FICHAS; 
    private ArrayList<SelectItem> itemsProgramas = null;
    
    /**
     * Creates a new instance of LideresVista
     */
    public FichasVista() {
    }       

    public InputText getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(InputText txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

    public String getTxtNombreInstructor() {
        return txtNombreInstructor;
    }

    public void setTxtNombreInstructor(String txtNombreInstructor) {
        this.txtNombreInstructor = txtNombreInstructor;
    }
    
    public SelectOneMenu getCmbJornada() {
        return cmbJornada;
    }

    public void setCmbJornada(SelectOneMenu cmbJornada) {
        this.cmbJornada = cmbJornada;
    }    

    public InputText getTxtFicha() {
        return txtFicha;
    }

    public void setTxtFicha(InputText txtFicha) {
        this.txtFicha = txtFicha;
    }    

    public SelectOneMenu getCmbPrograma() { 
        return cmbPrograma;
    }

    public void setCmbPrograma(SelectOneMenu cmbPrograma) {
        this.cmbPrograma = cmbPrograma;
    }

    public String[] getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(String[] listaJornadas) {
        this.listaJornadas = listaJornadas;
    } 

    public ArrayList<SelectItem> getItemsProgramas() {
        if (itemsProgramas == null) {
            itemsProgramas = new ArrayList<>();
            List<Programa> listaProgramas;
            try {
                listaProgramas = programaLogica.consultar();
                for (Programa programa : listaProgramas) {
                    itemsProgramas.add(new SelectItem(programa.getCodigoprograma(), programa.getNombre()));
                }
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
            }
        }
        
        return itemsProgramas;
    }

    public void setItemsProgramas(ArrayList<SelectItem> itemsProgramas) {
        this.itemsProgramas = itemsProgramas;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    public Fichatitulacion getSelectedFicha() {
        return selectedFicha;
    }

    public void setSelectedFicha(Fichatitulacion selectedFicha) {
        this.selectedFicha = selectedFicha;
    }

    public List<Fichatitulacion> getListaFichas() {
        if (listaFichas == null) {
            try {
                listaFichas = fichaLogica.consultar();
            } catch (Exception ex) {
                Logger.getLogger(FichasVista.class.getName()).log(Level.SEVERE, null, ex);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
            }
        }
        
        return listaFichas;
    }

    public void setListaFichas(List<Fichatitulacion> listaFichas) {
        this.listaFichas = listaFichas;
    }
    
    public void crearAction() {
        
        try {                        
            Fichatitulacion fichatitulacion = new Fichatitulacion();
            Instructor instructor = instructorLogica.consultarPorId(Long.parseLong(txtDocumento.getValue().toString()));
            fichatitulacion.setDocumentoinstructor(instructor);
            fichatitulacion.setJornada(cmbJornada.getValue().toString());
            fichatitulacion.setNumeroficha(Integer.parseInt(txtFicha.getValue().toString()));
            fichatitulacion.setFechainicio(fechaInicio);
            fichatitulacion.setFechafin(fechaFin);
            
            Programa programa=programaLogica.consultarPorId(Integer.parseInt(cmbPrograma.getValue().toString()));
            fichatitulacion.setCodigoprograma(programa);            
            fichaLogica.registrar(fichatitulacion);
            setListaFichas(null);
            limpiarAction(); 
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "Ficha creada con éxito!"));
        } catch (NumberFormatException nfe) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "La ficha y el documento del instructor son obligatorios y deben estar registrados!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
            Logger.getLogger(FichasVista.class.getName()).log(Level.SEVERE, null, e);
        }      
             
    }
    
    public void modificarAction() {
        
        try {                        
            Fichatitulacion fichatitulacion = new Fichatitulacion();
            Instructor instructor = instructorLogica.consultarPorId(Long.parseLong(txtDocumento.getValue().toString()));
            fichatitulacion.setDocumentoinstructor(instructor);
            fichatitulacion.setJornada(cmbJornada.getValue().toString());
            fichatitulacion.setNumeroficha(Integer.parseInt(txtFicha.getValue().toString()));
            fichatitulacion.setFechainicio(fechaInicio);
            fichatitulacion.setFechafin(fechaFin);
            
            Programa programa=programaLogica.consultarPorId(Integer.parseInt(cmbPrograma.getValue().toString()));
            fichatitulacion.setCodigoprograma(programa);            
            fichaLogica.modificar(fichatitulacion);
            setListaFichas(null);
            limpiarAction(); 
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "Ficha modificada con éxito!"));
        } catch (NumberFormatException nfe) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "La ficha y el documento del instructor son obligatorios y deben estar registrados!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
            Logger.getLogger(FichasVista.class.getName()).log(Level.SEVERE, null, e);
        }      
             
    }

    public void borrarAction() {
        //System.out.println("Borrar Permiso");
        
        try {                           
            Integer ficha = Integer.parseInt(txtFicha.getValue().toString());                
            Fichatitulacion fichatitulacion = fichaLogica.consultarPorId(ficha);            
            fichaLogica.eliminar(fichatitulacion);
            setListaFichas(null);
            limpiarAction();  
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "Ficha eliminada exitósamente"));
         } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
            Logger.getLogger(FichasVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void limpiarAction() {
        System.out.println("Limpiar");
        
        txtFicha.setValue("");
        cmbJornada.setValue("-1");
        cmbPrograma.setValue("-1");
        txtDocumento.setValue("");
        txtNombreInstructor="";       
        fechaInicio=null;
        fechaFin=null;
        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
        setSelectedFicha(null);
    }

    public void onSelect(Fichatitulacion fichatitulacion) {
        
        try {           
            txtDocumento.setValue(fichatitulacion.getDocumentoinstructor().getDocumentoinstructor());
            txtNombreInstructor=fichatitulacion.getDocumentoinstructor().getPersonal().getNombre()+" "+
                    fichatitulacion.getDocumentoinstructor().getPersonal().getApellido();
            txtFicha.setValue(fichatitulacion.getNumeroficha());
            cmbJornada.setValue(fichatitulacion.getJornada());
            cmbPrograma.setValue(fichatitulacion.getCodigoprograma().getCodigoprograma());
            fechaInicio=fichatitulacion.getFechainicio();
            fechaFin=fichatitulacion.getFechafin();
            btnRegistrar.setDisabled(true);
            btnEliminar.setDisabled(false);
            btnModificar.setDisabled(false);
        } catch (Exception ex) {
            Logger.getLogger(FichasVista.class.getName()).log(Level.SEVERE, null, ex);
        }       
    } 
    
    
    public void onEliminacionConfirm(ActionEvent actionEvent) {
        borrarAction();
    }
    
    public void txtFichaListener() {       
        
        try {
            Fichatitulacion fichaTitulacion = null;
            Integer numeroFicha = Integer.parseInt(getTxtFicha().getValue().toString());
            fichaTitulacion = fichaLogica.consultarPorId(numeroFicha);
            if (fichaTitulacion == null) {
                cmbJornada.setValue("-1");
                cmbPrograma.setValue("-1");
                txtDocumento.setValue("");
                txtNombreInstructor="";
                fechaFin=null;
                fechaInicio=null;
                
                btnModificar.setDisabled(true);
                btnEliminar.setDisabled(true);
                btnRegistrar.setDisabled(false);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso: ", "La ficha No está registrada!"));
            } else {
                getTxtFicha().setValue(fichaTitulacion.getNumeroficha());
                cmbJornada.setValue(fichaTitulacion.getJornada());
                cmbPrograma.setValue(fichaTitulacion.getCodigoprograma().getCodigoprograma());
                fechaInicio=fichaTitulacion.getFechainicio();
                fechaFin=fichaTitulacion.getFechafin();
                txtDocumento.setValue(fichaTitulacion.getDocumentoinstructor().getDocumentoinstructor());
                txtNombreInstructor=fichaTitulacion.getDocumentoinstructor().getPersonal().getNombre()+" "+
                            fichaTitulacion.getDocumentoinstructor().getPersonal().getApellido();
                
                btnModificar.setDisabled(true);
                btnEliminar.setDisabled(true);
                btnRegistrar.setDisabled(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(AprendizVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void txtDocumentoListener() {
        
        try {
            Instructor instructor = null;
            Long documento = Long.parseLong(txtDocumento.getValue().toString());
            instructor = instructorLogica.consultarPorId(documento);
            if (instructor == null) {
                txtNombreInstructor="";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso: ", "El instructor No está registrado!"));
            } else {
                txtDocumento.setValue(instructor.getPersonal().getDocumentopersonal());
                txtNombreInstructor=instructor.getPersonal().getNombre()+" "+
                        instructor.getPersonal().getApellido();
            }
        } catch (Exception ex) {
            Logger.getLogger(AprendizVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
