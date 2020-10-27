/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADSI
 */
@Entity
@Table(name = "config_correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfigCorreo.findAll", query = "SELECT c FROM ConfigCorreo c")
    , @NamedQuery(name = "ConfigCorreo.findById", query = "SELECT c FROM ConfigCorreo c WHERE c.id = :id")
    , @NamedQuery(name = "ConfigCorreo.findBySmtp", query = "SELECT c FROM ConfigCorreo c WHERE c.smtp = :smtp")
    , @NamedQuery(name = "ConfigCorreo.findByStarttls", query = "SELECT c FROM ConfigCorreo c WHERE c.starttls = :starttls")
    , @NamedQuery(name = "ConfigCorreo.findByPuerto", query = "SELECT c FROM ConfigCorreo c WHERE c.puerto = :puerto")
    , @NamedQuery(name = "ConfigCorreo.findByUsuario", query = "SELECT c FROM ConfigCorreo c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "ConfigCorreo.findByClave", query = "SELECT c FROM ConfigCorreo c WHERE c.clave = :clave")
    , @NamedQuery(name = "ConfigCorreo.findByAuth", query = "SELECT c FROM ConfigCorreo c WHERE c.auth = :auth")})
public class ConfigCorreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "smtp", nullable = false, length = 80)
    private String smtp;
    @Basic(optional = false)
    @Column(name = "starttls", nullable = false, length = 5)
    private String starttls;
    @Basic(optional = false)
    @Column(name = "puerto",nullable = false)
    private int puerto;
    @Basic(optional = false)
    @Column(name = "usuario", nullable = false, length = 100)
    private String usuario;
    @Basic(optional = false)
    @Column(name = "clave", nullable = false, length = 100)
    private String clave;
    @Basic(optional = false)
    @Column(name = "auth",nullable = false, length = 5)
    private String auth;

    public ConfigCorreo() {
    }

    public ConfigCorreo(Integer id) {
        this.id = id;
    }

    public ConfigCorreo(Integer id, String smtp, String starttls, int puerto, String usuario, String clave, String auth) {
        this.id = id;
        this.smtp = smtp;
        this.starttls = starttls;
        this.puerto = puerto;
        this.usuario = usuario;
        this.clave = clave;
        this.auth = auth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getStarttls() {
        return starttls;
    }

    public void setStarttls(String starttls) {
        this.starttls = starttls;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfigCorreo)) {
            return false;
        }
        ConfigCorreo other = (ConfigCorreo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.ConfigCorreo[ id=" + id + " ]";
    }

    public void setSmpt(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getSmtp(String smtp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
