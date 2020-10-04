/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import co.edu.sena.sael.logica.FichaTitulacionLogicaLocal;
import co.edu.sena.sael.logica.ProgramarSeguimientoLogicaLocal;
import co.edu.sena.sael.modelo.Fichatitulacion;
import co.edu.sena.sael.modelo.Personal;
import co.edu.sena.sael.modelo.Programarseguimiento;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.faces.model.SelectItem;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author dasak
 */
public class ProgramarSeguimientoVista implements Serializable {

    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    private List<Programarseguimiento> listaProgramarSegumientos = null;
    private List<SelectItem> itemsFichas;
    private SelectOneMenu selectFichas;
    private InputText txtProgramadoPor;
    private org.primefaces.component.calendar.Calendar calendarFecha;
    private int contadorId; // se encarga de recolectar el id autoincremental;
    private Date horaInicioObtenida;
    private Date fechaObtenida;
    private org.primefaces.component.calendar.Calendar calendarHoraInicio;

    @EJB
    private ProgramarSeguimientoLogicaLocal programarSeguimientoLogica;
    @EJB
    private FichaTitulacionLogicaLocal fichaTitulacionLogica;

    public org.primefaces.component.calendar.Calendar getCalendarHoraInicio() {
        return calendarHoraInicio;
    }

    public void setCalendarHoraInicio(org.primefaces.component.calendar.Calendar calendarHoraInicio) {
        this.calendarHoraInicio = calendarHoraInicio;
    }

    public Date getHoraInicioObtenida() {
        return horaInicioObtenida;
    }

    public void setHoraInicioObtenida(Date horaInicioObtenida) {
        this.horaInicioObtenida = horaInicioObtenida;
    }

    public org.primefaces.component.calendar.Calendar getCalendarFecha() {
        return calendarFecha;
    }

    public void setCalendarFecha(org.primefaces.component.calendar.Calendar calendarFecha) {
        this.calendarFecha = calendarFecha;
    }

    public int getContadorId() {
        return contadorId;
    }

    public void setContadorId(int contadorId) {
        this.contadorId = contadorId;
    }

    public InputText getTxtProgramadoPor() {
        return txtProgramadoPor;
    }

    public void setTxtProgramadoPor(InputText txtProgramadoPor) {
        this.txtProgramadoPor = txtProgramadoPor;
    }

    public Date getFechaObtenida() {
        return fechaObtenida;
    }

    public void setFechaObtenida(Date fechaObtenida) {
        this.fechaObtenida = fechaObtenida;
    }

    public List<SelectItem> getItemsFichas() {
        try {

            List<Fichatitulacion> listaFichas = fichaTitulacionLogica.consultar();
            itemsFichas = new ArrayList<>();

            for (Fichatitulacion fichas : listaFichas) {
                itemsFichas.add(new SelectItem(fichas.getNumeroficha(), fichas.getNumeroficha() + " : " + fichas.getCodigoprograma().getNombre()));
            }

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
        }
        return itemsFichas;
    }

    public void setItemsFichas(List<SelectItem> itemsFichas) {
        this.itemsFichas = itemsFichas;
    }

    public SelectOneMenu getSelectFichas() {
        return selectFichas;
    }

    public void setSelectFichas(SelectOneMenu selectFichas) {
        this.selectFichas = selectFichas;
    }

    public List<Programarseguimiento> getListaProgramarSegumientos() {
        if (listaProgramarSegumientos == null) {
            try {
                listaProgramarSegumientos = programarSeguimientoLogica.consultar();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
            }
        }
        return listaProgramarSegumientos;
    }

    public void setListaProgramarSegumientos(List<Programarseguimiento> listaProgramarSegumientos) {
        this.listaProgramarSegumientos = listaProgramarSegumientos;
    }

    // datos iniciales;
    @PostConstruct
    public void init() {

        eventModel = new DefaultScheduleModel();

        try {
            listaProgramarSegumientos = programarSeguimientoLogica.consultar();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
        }
        for (int i = 0; i < listaProgramarSegumientos.size(); i++) {

            Date fecha = listaProgramarSegumientos.get(i).getFecha();
            Date horaInicio = listaProgramarSegumientos.get(i).getHoraInicio();
            Date horaFin = listaProgramarSegumientos.get(i).getHoraFinal();
            String ficha = String.valueOf(listaProgramarSegumientos.get(i).getNumeroFicha().getNumeroficha() + " : "
                    + listaProgramarSegumientos.get(i).getNumeroFicha().getCodigoprograma().getNombre());

            String id = listaProgramarSegumientos.get(i).getId().toString();

            contadorId = Integer.parseInt(id);

            eventModel.addEvent(new DefaultScheduleEvent(ficha, obtenerFecha(fecha, horaInicio), obtenerFecha(fecha, horaFin), id));

        }

    }

    /**
     * obtiene la fecha + la hora tanto de inicio como final para los eventos
     * startDate y endDate
     *
     * @param fecha
     * @param horaEnviada
     * @return date
     */
    public Date obtenerFecha(Date fecha, Date horaEnviada) {

        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(fecha));
        int mes = Integer.parseInt(new SimpleDateFormat("MM").format(fecha));
        int dia = Integer.parseInt(new SimpleDateFormat("dd").format(fecha));
        int hora = Integer.parseInt(new SimpleDateFormat("HH").format(horaEnviada));
        int minutos = Integer.parseInt(new SimpleDateFormat("mm").format(horaEnviada));

        Calendar calendar = Calendar.getInstance();

        calendar.set(year, mes - 1, dia, hora, minutos);

        calendar.setTimeZone(TimeZone.getTimeZone("America/Bogota"));

        return calendar.getTime();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    // encargado de guardar la info de la ventana modal
    public void addEvent(ActionEvent actionEvent) {
        
        if (event.getId() == null) { // llama el metodo de crear
            
            contadorId++;
            String id = String.valueOf(contadorId);
            event = new DefaultScheduleEvent(selectFichas.getValue().toString(), obtenerFecha(fechaObtenida, horaInicioObtenida),
                    fechaObtenida, id);
            // encargado de crear el evento
            eventModel.addEvent(event); // encargado de crear el evento

        } else { // llama el metodo de modificar
                    
            String id = event.getStyleClass();
            
            eventModel.deleteEvent(event); // se elimina

            event = new DefaultScheduleEvent(selectFichas.getValue().toString(), obtenerFecha(fechaObtenida, horaInicioObtenida),
                    fechaObtenida, id);
            
            eventModel.addEvent(event);  // se vuelve a crear
            
            int idRecolectado = Integer.parseInt(id);
            
           // modificar(idRecolectado); convertir el id en entero
            
        }

        event = new DefaultScheduleEvent();
    }

    // cuando se selecciona una fecha que tiene datos, se entra a este metodo
    public void onEventSelect(SelectEvent selectEvent) {
        try {
            event = (ScheduleEvent) selectEvent.getObject();
            int id = Integer.parseInt(event.getStyleClass());
            Programarseguimiento programarseguimiento = programarSeguimientoLogica.consultarPorId(id);
            selectFichas.setValue(programarseguimiento.getNumeroFicha().getNumeroficha());
            calendarFecha.setValue(programarseguimiento.getFecha());
            txtProgramadoPor.setValue(programarseguimiento.getDocumentoPersonal().getDocumentopersonal() + " : "
                    + programarseguimiento.getDocumentoPersonal().getNombre() + " "
                    + programarseguimiento.getDocumentoPersonal().getApellido());

            calendarHoraInicio.setValue(programarseguimiento.getHoraInicio());

        } catch (Exception ex) {
            System.out.println("El ID NO EXISTE");
        }

    }

    // cuando se selecciona una fecha que no tiene datos, se entra a este metodo
    public void onDateSelect(SelectEvent selectEvent) {

        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        Personal user = (Personal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogeado");
        txtProgramadoPor.setValue(user.getDocumentopersonal() + " : " + user.getNombre() + " " + user.getApellido());
        calendarFecha.setValue(event.getStartDate());
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
