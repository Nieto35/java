/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import co.edu.sena.sael.logica.AprendizLogicaLocal;
import co.edu.sena.sael.logica.FichaTitulacionLogicaLocal;
import co.edu.sena.sael.logica.PersonalLogicaLocal;
import co.edu.sena.sael.logica.PertenecefichaLogicaLocal;
import co.edu.sena.sael.modelo.Aprendiz;
import co.edu.sena.sael.modelo.Fichatitulacion;
import co.edu.sena.sael.modelo.Personal;
import co.edu.sena.sael.modelo.Perteneceficha;
import co.edu.sena.sael.modelo.PertenecefichaPK;
import co.edu.sena.sael.utils.Constantes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import net.bootsfaces.component.commandButton.CommandButton;
import net.bootsfaces.component.inputText.InputText;
<<<<<<< HEAD
import net.bootsfaces.component.selectOneMenu.SelectOneMenu;
=======
import net.bootsfaces.component.inputTextarea.InputTextarea;
import net.bootsfaces.component.selectOneMenu.SelectOneMenu;
import oracle.jrockit.jfr.events.Bits;
import org.primefaces.event.SelectEvent;
>>>>>>> v1

/**
 *
 * @author Felipe
 */
public class AprendizVista {

    @EJB
    private AprendizLogicaLocal aprendizLogica;
    @EJB
    private PersonalLogicaLocal personalLogica;    
    @EJB
    private FichaTitulacionLogicaLocal fichaLogica;
    @EJB
    private PertenecefichaLogicaLocal pertenecefichaLogica;
    
    private InputText txtIdentificacion;
    private InputText txtNombre;
    private InputText txtApellido;
    private SelectOneMenu selectSexo;
    private InputText txtCorreo;
    private InputText txtCorreoInstitucional;
    private InputText txtTelefono;
    private InputText txtFicha;
    private InputText txtJornada;
    private InputText txtPrograma;
    private CommandButton btnCrear;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    private Aprendiz selectedAprendiz;
    private List<Aprendiz> listaAprendices = null;
    
    /**
     * Creates a new instance of AprendizVista
     */
    public AprendizVista() {
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

    public SelectOneMenu getSelectSexo() {
        return selectSexo;
    }

    public void setSelectSexo(SelectOneMenu selectSexo) {
        this.selectSexo = selectSexo;
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

    public InputText getTxtFicha() {
        return txtFicha;
    }

    public void setTxtFicha(InputText txtFicha) {
        this.txtFicha = txtFicha;
    }

    public InputText getTxtJornada() {
        return txtJornada;
    }

    public void setTxtJornada(InputText txtJornada) {
        this.txtJornada = txtJornada;
    }

    public InputText getTxtPrograma() {
        return txtPrograma;
    }

    public void setTxtPrograma(InputText txtPrograma) {
        this.txtPrograma = txtPrograma;
    }    

    public CommandButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(CommandButton btnCrear) {
        this.btnCrear = btnCrear;
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

    public Aprendiz getSelectedAprendiz() {
        return selectedAprendiz;
    }

    public void setSelectedAprendiz(Aprendiz selectedAprendiz) {
        this.selectedAprendiz = selectedAprendiz;
    }

    public InputText getTxtCorreoInstitucional() {
        return txtCorreoInstitucional;
    }

    public void setTxtCorreoInstitucional(InputText txtCorreoInstitucional) {
        this.txtCorreoInstitucional = txtCorreoInstitucional;
    }

    public List<Aprendiz> getListaAprendices() {
        if (listaAprendices == null) {
            try {
                setListaAprendices(aprendizLogica.consultar());
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
            }
        }
        
        return listaAprendices;
    }

    public void setListaAprendices(List<Aprendiz> listaAprendices) {
        this.listaAprendices = listaAprendices;
    }
    // se realizo los cambios
    public void crearAction()
    {
        
        try {
            Aprendiz nuevoAprendiz = new Aprendiz();
            Long docAprendiz = Long.parseLong(txtIdentificacion.getValue().toString());
            Personal nuevoPersonal = new Personal();
            nuevoPersonal.setDocumentopersonal(docAprendiz);
            nuevoPersonal.setNombre(txtNombre.getValue().toString().toUpperCase());
            nuevoPersonal.setApellido(txtApellido.getValue().toString().toUpperCase());
            nuevoPersonal.setSexo((char)(selectSexo.getValue()));
            nuevoPersonal.setCorreo(txtCorreo.getValue().toString().toUpperCase());
            nuevoPersonal.setCorreoinstitucional(txtCorreoInstitucional.getValue().toString().toUpperCase());
            nuevoPersonal.setTelefono(txtTelefono.getValue().toString());
            //se asigna por defecto como contraseña el numero de documento
            nuevoPersonal.setClave(String.valueOf(docAprendiz));                

            //revisa la variable de sesion
            String existePersonal = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("existePersonal");
            if ("no".equals(existePersonal)) {
                personalLogica.insertar(nuevoPersonal);
            } else {
                personalLogica.modificar(nuevoPersonal);    //por si el usuario cambia algún dato del personal
            }
            
            nuevoAprendiz.setDocumentoaprendiz(nuevoPersonal.getDocumentopersonal());
            nuevoAprendiz.setPersonal(nuevoPersonal); 
            aprendizLogica.registrar(nuevoAprendiz);

            Integer ficha = Integer.parseInt(getTxtFicha().getValue().toString());
            Fichatitulacion fichaA = fichaLogica.consultarPorId(ficha);

            PertenecefichaPK pertenecefichaPK=new PertenecefichaPK();
            pertenecefichaPK.setDocumentoaprendiz(nuevoAprendiz.getDocumentoaprendiz());
            pertenecefichaPK.setNumeroficha(fichaA.getNumeroficha());

            Perteneceficha perteneceficha=new Perteneceficha();
            perteneceficha.setAprendiz(nuevoAprendiz);
            perteneceficha.setFichatitulacion(fichaA);
            perteneceficha.setPertenecefichaPK(pertenecefichaPK);
            //asigna estado en formacion por defecto
            perteneceficha.setEstado(Constantes.FICHA_ESTADO_1);

            pertenecefichaLogica.insertar(perteneceficha);

            limpiarAction();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "El aprendiz se creó con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }
        
        setListaAprendices(null);
        
    }
    
    public void modificarAction() {
        //System.out.println("Modificar Aprendiz");        
        try {
            Long docAprendiz = Long.parseLong(txtIdentificacion.getValue().toString());

            //Modificar       
            Aprendiz aprendiz = new Aprendiz();
            Personal miPersonal = new Personal();
            miPersonal.setDocumentopersonal(docAprendiz);
            miPersonal.setNombre(txtNombre.getValue().toString().toUpperCase());
            miPersonal.setApellido(txtApellido.getValue().toString().toUpperCase());
            miPersonal.setSexo((char)(selectSexo.getValue()));
            miPersonal.setCorreo(txtCorreo.getValue().toString().toUpperCase());
            miPersonal.setCorreoinstitucional(txtCorreoInstitucional.getValue().toString().toUpperCase());
            miPersonal.setTelefono(txtTelefono.getValue().toString());
            personalLogica.modificar(miPersonal);

            aprendiz.setDocumentoaprendiz(miPersonal.getDocumentopersonal());
            aprendiz.setPersonal(miPersonal);
            aprendizLogica.modificar(aprendiz);

            Integer ficha = Integer.parseInt(getTxtFicha().getValue().toString());
            Fichatitulacion fichaA = fichaLogica.consultarPorId(ficha);

            PertenecefichaPK pertenecefichaPK=new PertenecefichaPK();
            pertenecefichaPK.setDocumentoaprendiz(aprendiz.getDocumentoaprendiz());
            pertenecefichaPK.setNumeroficha(fichaA.getNumeroficha());

            Perteneceficha perteneceficha=new Perteneceficha();
            perteneceficha.setAprendiz(aprendiz);
            perteneceficha.setFichatitulacion(fichaA);
            perteneceficha.setPertenecefichaPK(pertenecefichaPK);
            //TODO: verificar este estado de donde viene
            perteneceficha.setEstado("EN FORMACION");

            pertenecefichaLogica.modificar(perteneceficha);                

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "El aprendiz se modificó con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }
        
        setListaAprendices(null);
    }
    
    public void borrarAction() {
        //System.out.println("Borrar Aprendiz");        
        try {
            Long docAprendiz = Long.parseLong(txtIdentificacion.getValue().toString());
            //Borrar                
            Aprendiz aprendiz = new Aprendiz();
            aprendiz.setDocumentoaprendiz(docAprendiz);
            aprendizLogica.eliminar(aprendiz);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "El aprendiz se eliminó con éxito"));
            limpiarAction();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }       
        
        setListaAprendices(null);
    }
    
    public void limpiarAction() {
        //System.out.println("Limpiar registro");        
        txtIdentificacion.setValue("");
        txtNombre.setValue("");
        txtApellido.setValue("");
        selectSexo.setValue("");
        txtTelefono.setValue("");
        txtCorreo.setValue("");
        txtCorreoInstitucional.setValue("");
        txtFicha.setValue("");
        txtJornada.setValue("");
        txtPrograma.setValue("");
        btnEliminar.setDisabled(true);
        btnModificar.setDisabled(true);
        btnCrear.setDisabled(false);        
    }
    
    
    public void txtIdentificacionListener() {
        //System.out.println("Entro al listener del Aprendiz");        
        Aprendiz apre = null;
        Personal entityPersonal = null;
        try {
            Long documentoAprendiz = Long.parseLong(txtIdentificacion.getValue().toString());
            entityPersonal = personalLogica.consultarPorId(documentoAprendiz);
            apre = aprendizLogica.consultarPorId(documentoAprendiz);
        } catch (Exception ex) {
            Logger.getLogger(AprendizVista.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "El documento debe ser númerico!"));
        }

        if (entityPersonal == null) //si la persona no existe
        {
            txtNombre.setValue("");
            txtApellido.setValue("");
            selectSexo.setValue("");
            txtCorreo.setValue("");
            txtCorreoInstitucional.setValue("");
            txtTelefono.setValue("");
            txtFicha.setValue("");
            txtJornada.setValue("");
            txtPrograma.setValue("");

            btnCrear.setDisabled(false);
            btnEliminar.setDisabled(true);
            btnModificar.setDisabled(true);
           
            //guarda variable de sesion, indicando que no existe el personal
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("existePersonal", "no");
        } else if (apre == null) //si la persona existe pero no como aprendiz
        {
            txtNombre.setValue(entityPersonal.getNombre());
            txtApellido.setValue(entityPersonal.getApellido());
            selectSexo.setValue(entityPersonal.getSexo());
            txtCorreo.setValue(entityPersonal.getCorreo());
            txtCorreoInstitucional.setValue(entityPersonal.getCorreoinstitucional());
            txtTelefono.setValue(entityPersonal.getTelefono());

            btnModificar.setDisabled(true);
            btnEliminar.setDisabled(true);
            btnCrear.setDisabled(false);
            //el personal ya existe por tanto guarda el estado en una variable de sesion            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("existePersonal", "si");
        } else //si ya existe como aprendiz
        {
            txtIdentificacion.setValue(apre.getDocumentoaprendiz());
            txtNombre.setValue(apre.getPersonal().getNombre());
            txtApellido.setValue(apre.getPersonal().getApellido());
            selectSexo.setValue(apre.getPersonal().getSexo());
            txtCorreo.setValue(apre.getPersonal().getCorreo());
            txtCorreoInstitucional.setValue(entityPersonal.getCorreoinstitucional());
            txtTelefono.setValue(apre.getPersonal().getTelefono());
            /*txtFicha.setValue(apre.getFichatitulacion().getFicha());
            txtJornada.setValue(apre.getFichaTitulacion().getJornada());
            txtPrograma.setValue(apre.getFichaTitulacion().getCodigoPrograma().getNombre());
            */btnCrear.setDisabled(true);

            btnEliminar.setDisabled(false);
            btnModificar.setDisabled(false);
            btnCrear.setDisabled(true);
            //el personal ya existe y como aprendiz por tanto guarda el estado en una variable de sesion     
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("existePersonal", "si");
        }       

    }
    
    public void txtFichaListener() {
        //System.out.println("Entro al listener de la Ficha");        
        try {
            Integer numeroFicha = Integer.parseInt(getTxtFicha().getValue().toString());
            Fichatitulacion ft = fichaLogica.consultarPorId(numeroFicha);
            if (ft == null) {
                txtJornada.setValue("");
                txtPrograma.setValue("");

                if (btnModificar.isDisabled()) {
                    btnCrear.setDisabled(true);
                }

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso: ", "La ficha No está registrada!"));
            } else {
                txtFicha.setValue(ft.getNumeroficha());
                txtJornada.setValue(ft.getJornada());
                txtPrograma.setValue(ft.getCodigoprograma().getNombre());

                if (btnModificar.isDisabled()) {
                    btnCrear.setDisabled(false);
                    btnEliminar.setDisabled(true);
                } else {
                    btnCrear.setDisabled(true);
                    btnEliminar.setDisabled(false);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AprendizVista.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
        }
        
    }
    
    public void onEliminacionConfirm(ActionEvent actionEvent) {
        borrarAction();
    }
    
    public void onRowSelect(Aprendiz apre) {
        //System.out.println("Selecciono el Aprendiz");        
<<<<<<< HEAD
        try {      
=======
        try {   
>>>>>>> v1
            txtIdentificacion.setValue(apre.getDocumentoaprendiz());
            txtNombre.setValue(apre.getPersonal().getNombre());
            txtApellido.setValue(apre.getPersonal().getApellido());
            selectSexo.setValue(apre.getPersonal().getSexo());
            txtCorreo.setValue(apre.getPersonal().getCorreo());
            txtCorreoInstitucional.setValue(apre.getPersonal().getCorreoinstitucional());
            txtTelefono.setValue(apre.getPersonal().getTelefono());
            //TODO: revisar

            Perteneceficha fichaActiva=pertenecefichaLogica.consultarFichaActiva(apre);
            if(fichaActiva==null)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso: ", "El aprendiz no tiene una ficha EN FORMACION"));
            }
            else
            {
                txtFicha.setValue(fichaActiva.getFichatitulacion().getNumeroficha());
                txtJornada.setValue(fichaActiva.getFichatitulacion().getJornada());
                txtPrograma.setValue(fichaActiva.getFichatitulacion().getCodigoprograma().getNombre());
            }          
            

            btnCrear.setDisabled(true);
            btnEliminar.setDisabled(false);
            btnModificar.setDisabled(false);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }
                
    }
    
}
