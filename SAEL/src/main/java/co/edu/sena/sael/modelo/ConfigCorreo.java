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
 * @author g2
 */
@Entity
@Table(name = "config_correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfigCorreo.findAll", query = "SELECT c FROM ConfigCorreo c")
    , @NamedQuery(name = "ConfigCorreo.findById", query = "SELECT c FROM ConfigCorreo c WHERE c.id = :id")
    , @NamedQuery(name = "ConfigCorreo.findByTipoCorreo", query = "SELECT c FROM ConfigCorreo c WHERE c.tipoCorreo = :tipoCorreo")
    , @NamedQuery(name = "ConfigCorreo.findByStarttls", query = "SELECT c FROM ConfigCorreo c WHERE c.starttls = :starttls")
    , @NamedQuery(name = "ConfigCorreo.findByPuerto", query = "SELECT c FROM ConfigCorreo c WHERE c.puerto = :puerto")
    , @NamedQuery(name = "ConfigCorreo.findByUsuario", query = "SELECT c FROM ConfigCorreo c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "ConfigCorreo.findByClave", query = "SELECT c FROM ConfigCorreo c WHERE c.clave = :clave")
    , @NamedQuery(name = "ConfigCorreo.findByCredenciales", query = "SELECT c FROM ConfigCorreo c WHERE c.credenciales = :credenciales")})
public class ConfigCorreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipocorreo" ,nullable = false, length = 80)
    private String tipoCorreo;
    @Basic(optional = false)
    @Column(name = "starttls" ,nullable = false, length = 50)
    private String starttls;
    @Basic(optional = false)
    @Column(name = "puerto",nullable = false)
    private int puerto;
    @Basic(optional = false)
    @Column(name = "usuario" ,nullable = false, length = 100)
    private String usuario;
    @Basic(optional = false)
    @Column(name = "clave" ,nullable = false, length = 100)
    private String clave;
    @Basic(optional = false)
    @Column(name = "credenciales" ,nullable = false, length = 10)
    private String credenciales;

    public ConfigCorreo() {
    }

    public ConfigCorreo(Integer id) {
        this.id = id;
    }

    public ConfigCorreo(Integer id, String tipoCorreo, String starttls, int puerto, String usuario, String clave, String credenciales) {
        this.id = id;
        this.tipoCorreo = tipoCorreo;
        this.starttls = starttls;
        this.puerto = puerto;
        this.usuario = usuario;
        this.clave = clave;
        this.credenciales = credenciales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoCorreo() {
        return tipoCorreo;
    }

    public void setTipoCorreo(String tipoCorreo) {
        this.tipoCorreo = tipoCorreo;
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

    public String getCredenciales() {
        return credenciales;
    }

    public void setCredenciales(String credenciales) {
        this.credenciales = credenciales;
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
    
}
