/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import co.edu.sena.sael.logica.AprendizLogicaLocal;
import co.edu.sena.sael.logica.FichaTitulacionLogicaLocal;
import co.edu.sena.sael.logica.ProgramaLogicaLocal;
import co.edu.sena.sael.modelo.Aprendiz;
import co.edu.sena.sael.modelo.Fichatitulacion;
import co.edu.sena.sael.utils.Constantes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.bootsfaces.component.commandButton.CommandButton;
import net.bootsfaces.component.inputText.InputText;
import net.bootsfaces.component.selectOneMenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Felipe
 */
public class FichaAprendizVista {

    @EJB
    private FichaTitulacionLogicaLocal fichaLogica;  
    @EJB
    private ProgramaLogicaLocal programaLogica;  
    @EJB
    private AprendizLogicaLocal aprendizLogica; 
    
    private InputText txtDocumento;
    private String txtNombreAprendiz;
    private InputText txtFicha;
    private String txtPrograma;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;
    private SelectOneMenu cmbEstado;
    private Fichatitulacion selectedFicha;
    private List<Fichatitulacion> listaFichas = null; 
    private String[] listaEstados = Constantes.LIST_ESTADOS_FORMACION; 
    
    /**
     * Creates a new instance of FichaAprendizVista
     */
    public FichaAprendizVista() {
    }

    public InputText getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(InputText txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

    public String getTxtNombreAprendiz() {
        return txtNombreAprendiz;
    }

    public void setTxtNombreAprendiz(String txtNombreAprendiz) {
        this.txtNombreAprendiz = txtNombreAprendiz;
    }

    public InputText getTxtFicha() {
        return txtFicha;
    }

    public void setTxtFicha(InputText txtFicha) {
        this.txtFicha = txtFicha;
    }

    public String getTxtPrograma() {
        return txtPrograma;
    }

    public void setTxtPrograma(String txtPrograma) {
        this.txtPrograma = txtPrograma;
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

    public SelectOneMenu getCmbEstado() {
        return cmbEstado;
    }

    public void setCmbEstado(SelectOneMenu cmbEstado) {
        this.cmbEstado = cmbEstado;
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

    public String[] getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(String[] listaEstados) {
        this.listaEstados = listaEstados;
    }
    
    public void modificarAction()
    {
        
    }
    
    public void limpiarAction() {
        System.out.println("Limpiar");
        
        txtFicha.setValue("");
        cmbEstado.setValue("-1");
        txtPrograma="";
        txtDocumento.setValue("");
        txtNombreAprendiz="";
        btnModificar.setDisabled(true);        
        setSelectedFicha(null);
    }
    
    public void onRowSelect(SelectEvent event) {
        
        try {
            Fichatitulacion fichatitulacion = (Fichatitulacion) event.getObject();  
            
            txtFicha.setValue(fichatitulacion.getNumeroficha());            
            txtPrograma=fichatitulacion.getCodigoprograma().getNombre();            
            btnModificar.setDisabled(false);
        } catch (Exception ex) {
            Logger.getLogger(FichasVista.class.getName()).log(Level.SEVERE, null, ex);
        }       
    } 
    
    public void txtFichaListener() {       
        
        try {
            Fichatitulacion fichaTitulacion = null;
            Integer numeroFicha = Integer.parseInt(getTxtFicha().getValue().toString());
            fichaTitulacion = fichaLogica.consultarPorId(numeroFicha);
            if (fichaTitulacion == null) {               
                txtPrograma="";
                cmbEstado.setValue(""); 
                btnModificar.setDisabled(true);               

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso: ", "La ficha No está registrada!"));
            } else {
                getTxtFicha().setValue(fichaTitulacion.getNumeroficha());                
                txtPrograma=fichaTitulacion.getCodigoprograma().getNombre(); 
                btnModificar.setDisabled(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(AprendizVista.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error:", ex.getMessage()));
        }
    }
    
    public void txtDocumentoListener() {
        
        try {            
            Long documento = Long.parseLong(txtDocumento.getValue().toString());
            Aprendiz aprendiz = aprendizLogica.consultarPorId(documento);
            if (aprendiz == null) {
                txtNombreAprendiz="";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso: ", "El aprendiz No está registrado!"));
            } else {                
                txtNombreAprendiz=aprendiz.getPersonal().getNombre()+" "+
                        aprendiz.getPersonal().getApellido();
            }
        } catch (Exception ex) {
            Logger.getLogger(AprendizVista.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error:", ex.getMessage()));
        }
    }
}
