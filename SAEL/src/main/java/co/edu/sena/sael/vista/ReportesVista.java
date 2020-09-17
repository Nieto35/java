/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import co.edu.sena.sael.logica.AprendizLogicaLocal;
import co.edu.sena.sael.modelo.Aprendiz;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;
import org.primefaces.component.selectonemenu.SelectOneMenu;

/**
 *
 * @author Fabian Andres
 */
@Named(value = "reportesVista")
@RequestScoped
public class ReportesVista {
    
    private SelectOneMenu selectAprendiz;
    private List<SelectItem> itemAprendiz;
    
    /**
     * Creates a new instance of ReportesVista
     */
    @EJB
    private AprendizLogicaLocal aprendizLogica;

    public SelectOneMenu getSelectAprendiz() {
        return selectAprendiz;
    }

    public List<SelectItem> getItemAprendiz() {
        try {
            List<Aprendiz> listaAprendices = aprendizLogica.consultar();
            itemAprendiz = new ArrayList<>();
            for (Aprendiz aprendiz : listaAprendices) {
                itemAprendiz.add(new SelectItem(aprendiz.getDocumentoaprendiz()));

            }

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));

        }

        return itemAprendiz;
    }

    public void setSelectAprendiz(SelectOneMenu selectAprendiz) {
        this.selectAprendiz = selectAprendiz;
    }

    public void setItemAprendiz(List<SelectItem> itemAprendiz) {
        this.itemAprendiz = itemAprendiz;
    }
    
    
    
    public ReportesVista() {
        
    }
    
    public void generarReporteFelicitacion() {
        try {
            
              Aprendiz aprendiz = new Aprendiz();
              aprendiz.setDocumentoaprendiz(Long.parseLong(selectAprendiz.getValue().toString()));
            
            
            HttpServletRequest sr = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest());
            String scheme = sr.getScheme();
            String serverName = sr.getServerName();
            int port = sr.getServerPort();
            String contextPath = sr.getContextPath();
            String url = scheme + "://" + serverName + ":" + port + contextPath;

            System.out.println("url: " + url);

            String params
                    = "'"
                    + url + "/ReporteFelicitaciones.do?DocumentoAprendiz="+aprendiz.getDocumentoaprendiz()
                    + "','reportWindow'";

            System.out.println("params: " + params);
            PrimeFaces.current().executeScript("location.href=" + params + ";");

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }
    
}
