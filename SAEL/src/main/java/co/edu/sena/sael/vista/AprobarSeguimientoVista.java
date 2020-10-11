/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import co.edu.sena.sael.logica.CoordinadorLogicaLocal;
import co.edu.sena.sael.logica.FichaTitulacionLogicaLocal;
import co.edu.sena.sael.logica.PersonalLogicaLocal;
import co.edu.sena.sael.logica.ProgramarSeguimientoLogicaLocal;
import co.edu.sena.sael.modelo.Coordinador;
import co.edu.sena.sael.modelo.Fichatitulacion;
import co.edu.sena.sael.modelo.Personal;
import co.edu.sena.sael.modelo.Programarseguimiento;
import static co.edu.sena.sael.utils.Constantes.LIST_ESTADO_PROG_SEGUIMIENTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.bootsfaces.component.inputText.InputText;
import org.primefaces.component.calendar.Calendar;

/**
 *
 * @author dasak
 */
public class AprobarSeguimientoVista implements Serializable {
    
    private List<Programarseguimiento> listaAprobarSegumiento = null;
    private InputText txtId;
    private InputText txtFicha;    
    private InputText txtProgramadoPor;
    private Calendar calendarFecha;
    private InputText txtCoordinador;
    private Calendar calendarHoraInicio;
    private Calendar calendarHoraFinal;
    private Date fechaObtenida;
    private Date horaFinalObtenida;
    private Date horaInicioObtenida;
    private String[] estados = LIST_ESTADO_PROG_SEGUIMIENTO;
     
    @EJB
    private ProgramarSeguimientoLogicaLocal programarSeguimientoLogica;
    @EJB
    private FichaTitulacionLogicaLocal fichaTitulacionLogica;
    @EJB
    private CoordinadorLogicaLocal coordinadorLogica;
    @EJB
    private PersonalLogicaLocal PersonalLogica;

    public String[] getEstados() {
        return estados;
    }

    public void setEstados(String[] estados) {
        this.estados = estados;
    }
     
    public List<Programarseguimiento> getListaAprobarSegumiento() {
        if (listaAprobarSegumiento == null) {
            try {
                listaAprobarSegumiento = programarSeguimientoLogica.consultarPorEstado(estados[0]);
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
            }
        }
        return listaAprobarSegumiento;
    }
    
    public void setListaAprobarSegumiento(List<Programarseguimiento> listaAprobarSegumiento) {
        this.listaAprobarSegumiento = listaAprobarSegumiento;
    }

    public Date getFechaObtenida() {
        return fechaObtenida;
    }

    public void setFechaObtenida(Date fechaObtenida) {
        this.fechaObtenida = fechaObtenida;
    }

    public Date getHoraFinalObtenida() {
        return horaFinalObtenida;
    }

    public void setHoraFinalObtenida(Date horaFinalObtenida) {
        this.horaFinalObtenida = horaFinalObtenida;
    }

    public Date getHoraInicioObtenida() {
        return horaInicioObtenida;
    }

    public void setHoraInicioObtenida(Date horaInicioObtenida) {
        this.horaInicioObtenida = horaInicioObtenida;
    }
    
    
    
    public InputText getTxtId() {
        return txtId;
    }
    
    public void setTxtId(InputText txtId) {
        this.txtId = txtId;
    }
    
    public InputText getTxtFicha() {
        return txtFicha;
    }
    
    public void setTxtFicha(InputText txtFicha) {
        this.txtFicha = txtFicha;
    }
    
    public InputText getTxtProgramadoPor() {
        return txtProgramadoPor;
    }
    
    public void setTxtProgramadoPor(InputText txtProgramadoPor) {
        this.txtProgramadoPor = txtProgramadoPor;
    }
    
    public Calendar getCalendarFecha() {
        return calendarFecha;
    }
    
    public void setCalendarFecha(Calendar calendarFecha) {
        this.calendarFecha = calendarFecha;
    }
    
    public InputText getTxtCoordinador() {
        return txtCoordinador;
    }
    
    public void setTxtCoordinador(InputText txtCoordinador) {
        this.txtCoordinador = txtCoordinador;
    }
    
    public Calendar getCalendarHoraInicio() {
        return calendarHoraInicio;
    }
    
    public void setCalendarHoraInicio(Calendar calendarHoraInicio) {
        this.calendarHoraInicio = calendarHoraInicio;
    }
    
    public Calendar getCalendarHoraFinal() {
        return calendarHoraFinal;
    }
    
    public void setCalendarHoraFinal(Calendar calendarHoraFinal) {
        this.calendarHoraFinal = calendarHoraFinal;
    }
    
    public void onSelect(Programarseguimiento programarSeguimiento) {
        
        txtId.setValue(programarSeguimiento.getId());
        txtCoordinador.setValue(programarSeguimiento.getIdCoordinador().getDocumentocoordinador());
        txtFicha.setValue(programarSeguimiento.getNumeroFicha().getNumeroficha() + " : " + 
                          programarSeguimiento.getNumeroFicha().getCodigoprograma().getNombre());
        txtProgramadoPor.setValue(programarSeguimiento.getDocumentoPersonal().getDocumentopersonal() + " : " +
                                  programarSeguimiento.getDocumentoPersonal().getNombre() + " " + 
                                  programarSeguimiento.getDocumentoPersonal().getApellido());
        calendarFecha.setValue(programarSeguimiento.getFecha());
        calendarHoraInicio.setValue(programarSeguimiento.getHoraInicio());
        calendarHoraFinal.setValue(programarSeguimiento.getHoraFinal());
        System.out.println("entre");
        
    }
    
    public void aprobarSeguimiento(){
        try {
            Programarseguimiento programarSeguimiento = obtenerInformacion();
            programarSeguimiento.setId(Integer.parseInt(txtId.getValue().toString()));
            programarSeguimiento.setEstado(estados[1]);
            programarSeguimientoLogica.modificar(programarSeguimiento);
        } catch (Exception ex) {
            Logger.getLogger(AprobarSeguimientoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desaprobarSeguimiento(){
        try {
            Programarseguimiento programarSeguimiento = obtenerInformacion();
            programarSeguimiento.setId(Integer.parseInt(txtId.getValue().toString()));
            programarSeguimiento.setEstado(estados[2]);
            programarSeguimientoLogica.modificar(programarSeguimiento);
        } catch (Exception ex) {
            Logger.getLogger(AprobarSeguimientoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public Programarseguimiento obtenerInformacion(){
        Programarseguimiento programarSeguimiento= new Programarseguimiento();
        String[] recolectarDocumentoPersonal = txtProgramadoPor.getValue().toString().split(" : ");
        String[] recolectarDocumentoCoordiandor = txtCoordinador.getValue().toString().split(" : ");
        String[] recolectarFichas = txtFicha.getValue().toString().split(" : ");
           
        programarSeguimiento.setFecha(fechaObtenida);
        programarSeguimiento.setHoraInicio(horaInicioObtenida);
        programarSeguimiento.setHoraFinal(horaFinalObtenida);
        
        try {
            //FK
            Personal personal = PersonalLogica.consultarPorId(Long.parseLong(recolectarDocumentoPersonal[0]));

            programarSeguimiento.setDocumentoPersonal(personal);

            //FK
            Fichatitulacion fichaTitulacion = fichaTitulacionLogica.consultarPorId(Integer.parseInt(recolectarFichas[0]));
            programarSeguimiento.setNumeroFicha(fichaTitulacion);

            //FK
            Coordinador coordinador  = coordinadorLogica.consultarPorId(Long.parseLong(recolectarDocumentoCoordiandor[0]));
            programarSeguimiento.setIdCoordinador(coordinador);

        } catch (Exception ex) {
            Logger.getLogger(ProgramarSeguimientoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return programarSeguimiento;
    }
}
