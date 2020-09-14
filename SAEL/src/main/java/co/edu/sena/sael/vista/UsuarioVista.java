/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.vista;

import co.edu.sena.sael.logica.PersonalLogicaLocal;
import co.edu.sena.sael.logica.UsuarioLogicaLocal;
import co.edu.sena.sael.modelo.Personal;
import co.edu.sena.sael.utils.Constantes;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.primefaces.component.selectonemenu.SelectOneMenu;

/**
 *
 * @author Felipe
 */
@SessionScoped
public class UsuarioVista implements Serializable{
    @EJB
    private UsuarioLogicaLocal usuariosLogica;
    @EJB
    private PersonalLogicaLocal personalLogica;
    @EJB
    private UsuarioLogicaLocal usuarioLogica;
    @Inject
    private HttpServletRequest request;
    
    private InputText txtUsuario;
    private Password passUsuario;
    private SelectOneMenu cmbTipo;
    private String opcion;
    
    private Password passClaveOld;
    private Password passClaveNew;
    private Password passClaveNew2;
    private Personal usuarioLogeado;
    private String[] listaTiposUsuario = Constantes.LIST_TIPOS_USUARIO; 

    public UsuarioLogicaLocal getUsuariosLogica() {
        return usuariosLogica;
    }

    public void setUsuariosLogica(UsuarioLogicaLocal usuariosLogica) {
        this.usuariosLogica = usuariosLogica;
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public Password getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(Password passUsuario) {
        this.passUsuario = passUsuario;
    }

    public SelectOneMenu getCmbTipo() {
        return cmbTipo;
    }

    public void setCmbTipo(SelectOneMenu cmbTipo) {
        this.cmbTipo = cmbTipo;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Password getPassClaveOld() {
        return passClaveOld;
    }

    public void setPassClaveOld(Password passClaveOld) {
        this.passClaveOld = passClaveOld;
    }

    public Password getPassClaveNew() {
        return passClaveNew;
    }

    public void setPassClaveNew(Password passClaveNew) {
        this.passClaveNew = passClaveNew;
    }

    public Password getPassClaveNew2() {
        return passClaveNew2;
    }

    public void setPassClaveNew2(Password passClaveNew2) {
        this.passClaveNew2 = passClaveNew2;
    }

    public Personal getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Personal usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }

    public String[] getListaTiposUsuario() {
        return listaTiposUsuario;
    }

    public void setListaTiposUsuario(String[] listaTiposUsuario) {
        this.listaTiposUsuario = listaTiposUsuario;
    }
    
    
    
    public void ingresarAction()
    {
        //System.out.println("Ingresar");
        String pagina = "";        

        try {

            opcion = cmbTipo.getValue().toString();
            this.usuarioLogeado = new Personal();
            Long documento = Long.parseLong(txtUsuario.getValue().toString());
            this.usuarioLogeado.setDocumentopersonal(documento);
            this.usuarioLogeado.setClave(passUsuario.getValue().toString());
            usuariosLogica.autenticar(this.usuarioLogeado);
            //sesion            
            this.usuarioLogeado=personalLogica.consultarPorId(documento);
            
            if ("COORDINADOR".equals(opcion)) {
                pagina = "faces/indexCoordinador.xhtml";
            } else if ("INSTRUCTOR".equals(opcion)) {
                pagina = "faces/indexInstructor.xhtml";
            }

            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogeado", usuarioLogeado);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tipoUsuario", opcion);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogeado", this.usuarioLogeado);
            FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);

        } catch (NumberFormatException nfe) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Los datos de Ingreso son Obligatorios!"));
        } catch (IOException ex) {
            Logger.getLogger(UsuarioVista.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", e.getMessage()));
        }
    }
    
    public void validarSesion()
{
try {
	String url = request.getRequestURL().toString();
	System.out.println("url: "+url);
	ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
	usuarioLogeado = (Personal) context.getSessionMap().get("usuarioLogeado"); 
	String ctxPath = ((ServletContext) context.getContext()).getContextPath();


	//si la pagina actual es el login o la configurada como inicial
	if(url.endsWith ("/SAEL/") || url.endsWith("/index.xhtml"))
	{
		//si hay una sesión iniciada redirije al index siempre y  no permite ir al login
		if(usuarioLogeado != null)
		{
			context.redirect(ctxPath+ "/indexInstructor.xhtml");
		}
	}
	else if(usuarioLogeado==null)//si es otra pagina y  no hay sesion ·niciada abre sesion invalida
	{

		context.redirect(ctxPath+ "/SesionInvalida.xhtml");
	}
      }catch (IOException e) {
	Logger.getLogger(UsuarioVista.class.getName()).log(Level.SEVERE, null, e);
	}
}

    
    public void cambiarPassAction()
    {
        try {
            Personal user = (Personal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogeado");

            usuariosLogica.cambiarContraseña(user.getDocumentopersonal(), passClaveOld.getValue().toString(),
                            passClaveNew.getValue().toString(), passClaveNew2.getValue().toString());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "La Contraseña Ha Sido Actualizada con Exito"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
        }        
    }
    
    public void limpiarAction() {
        //System.out.println("Limpiar");

        txtUsuario.setValue("");
        passUsuario.setValue("");
        cmbTipo.setValue("-1");
    }
    
    public void limpiarPassAction() {
        //System.out.println("Limpiar Pass");

        passClaveNew.setValue("");
        passClaveNew2.setValue("");
        passClaveOld.setValue("");

    }
    
    public void cerrarSesionAction() {
        //System.out.println("Cerrar Sesión");

        try {
            Logger.getLogger(UsuarioVista.class.getName()).log(Level.INFO, null, "cerrarSesion");
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
            ctx.redirect(ctxPath + "/faces/index.xhtml");
        } catch (IOException ex) {            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
        }
    }
}
