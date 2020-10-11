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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import net.bootsfaces.component.inputText.InputText;
import net.bootsfaces.component.selectOneMenu.SelectOneMenu;
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
    private List<SelectItem> itemsCoordinador;
    private SelectOneMenu selectCoordinador;
    private org.primefaces.component.calendar.Calendar calendarHoraFinal;
    private Date horaFinalObtenida;
    private org.primefaces.component.calendar.Calendar calendarHoraInicio;
    private InputText txtEstado;
    private final String ESTADO_DEFECTO = LIST_ESTADO_PROG_SEGUIMIENTO[0];

    @EJB
    private ProgramarSeguimientoLogicaLocal programarSeguimientoLogica;
    @EJB
    private FichaTitulacionLogicaLocal fichaTitulacionLogica;
    @EJB
    private CoordinadorLogicaLocal coordinadorLogica;
    @EJB
    private PersonalLogicaLocal PersonalLogica;
    
    
    
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

    public InputText getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(InputText txtEstado) {
        this.txtEstado = txtEstado;
    }

    public org.primefaces.component.calendar.Calendar getCalendarHoraFinal() {
        return calendarHoraFinal;
    }

    public void setCalendarHoraFinal(org.primefaces.component.calendar.Calendar calendarHoraFinal) {
        this.calendarHoraFinal = calendarHoraFinal;
    }

    public Date getHoraFinalObtenida() {
        return horaFinalObtenida;
    }

    public void setHoraFinalObtenida(Date horaFinalObtenida) {
        this.horaFinalObtenida = horaFinalObtenida;
    }

    public List<SelectItem> getItemsCoordinador() {
        try {

            List<Coordinador> listaCoordinardor = coordinadorLogica.consultar();
            itemsCoordinador = new ArrayList<>();

            for (Coordinador coordinadores : listaCoordinardor) {
                itemsCoordinador.add(new SelectItem(coordinadores.getDocumentocoordinador(), coordinadores.getDocumentocoordinador().toString() + 
                                                    " : " + coordinadores.getPersonal().getNombre() + " " + coordinadores.getPersonal().getApellido()));
                                                    
            }

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
        }
        return itemsCoordinador;
    }

    public void setItemsCoordinador(List<SelectItem> itemsCoordinador) {
        this.itemsCoordinador = itemsCoordinador;
    }

    public SelectOneMenu getSelectCoordinador() {
        return selectCoordinador;
    }

    public void setSelectCoordinador(SelectOneMenu selectCoordinador) {
        this.selectCoordinador = selectCoordinador;
    }

    public List<SelectItem> getItemsFichas() {
        try {
 
            Date fechaActual = new Date();

            List<Fichatitulacion> listaFichas = fichaTitulacionLogica.consultarFichasDisponibles(fechaActual);
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

    public Programarseguimiento obtenerInformacion(Programarseguimiento programarSeguimiento) {
        String documento = txtProgramadoPor.getValue().toString();
        String[] recolectarDocumento = documento.split(" :");

        programarSeguimiento.setFecha(fechaObtenida);
        programarSeguimiento.setHoraInicio(horaInicioObtenida);
        programarSeguimiento.setHoraFinal(horaFinalObtenida);
        programarSeguimiento.setEstado(txtEstado.getValue().toString());

        try {
            //FK
            Personal personal = PersonalLogica.consultarPorId(Long.parseLong(recolectarDocumento[0]));

            programarSeguimiento.setDocumentoPersonal(personal);

            //FK
            Fichatitulacion fichaTitulacion = fichaTitulacionLogica.consultarPorId(Integer.parseInt(selectFichas.getValue().toString()));
            programarSeguimiento.setNumeroFicha(fichaTitulacion);

            //FK
            Coordinador coordinador = coordinadorLogica.consultarPorId(Long.parseLong(selectCoordinador.getValue().toString()));
            programarSeguimiento.setIdCoordinador(coordinador);

        } catch (Exception ex) {
            Logger.getLogger(ProgramarSeguimientoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return programarSeguimiento;
    }

    public void crear() {
        try {
            Programarseguimiento programarSeguimiento = new Programarseguimiento();
            programarSeguimiento = obtenerInformacion(programarSeguimiento);
            programarSeguimientoLogica.insertar(programarSeguimiento);
        } catch (Exception ex) {
            Logger.getLogger(ProgramarSeguimientoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar(int id) {
        try {
            Programarseguimiento programarSeguimiento = new Programarseguimiento();
            programarSeguimiento = obtenerInformacion(programarSeguimiento);
            programarSeguimiento.setId(id);
            programarSeguimientoLogica.modificar(programarSeguimiento);
        } catch (Exception ex) {
            Logger.getLogger(ProgramarSeguimientoVista.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            crear();
            

        } else { // llama el metodo de modificar

            String id = event.getStyleClass();

            eventModel.deleteEvent(event); // se elimina

            event = new DefaultScheduleEvent(selectFichas.getValue().toString(), obtenerFecha(fechaObtenida, horaInicioObtenida),
                    fechaObtenida, id);

            eventModel.addEvent(event);  // se vuelve a crear

            int idRecolectado = Integer.parseInt(id);

            modificar(idRecolectado);

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
            selectCoordinador.setValue(programarseguimiento.getIdCoordinador().getDocumentocoordinador());
            calendarHoraFinal.setValue(programarseguimiento.getHoraFinal());
            txtEstado.setValue(programarseguimiento.getEstado());
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
        txtEstado.setValue(ESTADO_DEFECTO);
        calendarHoraFinal.setValue("");
        calendarHoraInicio.setValue("");
        selectCoordinador.setValue("");
        selectFichas.setValue("");
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
