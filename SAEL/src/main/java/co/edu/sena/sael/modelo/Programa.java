/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "programa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p")
    , @NamedQuery(name = "Programa.findByCodigoprograma", query = "SELECT p FROM Programa p WHERE p.codigoprograma = :codigoprograma")
    , @NamedQuery(name = "Programa.findByNombre", query = "SELECT p FROM Programa p WHERE p.nombre = :nombre")})
public class Programa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoprograma", nullable = false)//@NotNull
    private Integer codigoprograma;
    @Column(name = "nombreprograma",length = 100)//@Size(max = 100)
    private String nombreprograma;
    @OneToMany(mappedBy = "codigoprograma")
    private Collection<Fichatitulacion> fichatitulacionCollection;

    public Programa() {
    }

    public Programa(Integer codigoprograma) {
        this.codigoprograma = codigoprograma;
    }

    public Integer getCodigoprograma() {
        return codigoprograma;
    }

    public void setCodigoprograma(Integer codigoprograma) {
        this.codigoprograma = codigoprograma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Fichatitulacion> getFichatitulacionCollection() {
        return fichatitulacionCollection;
    }

    public void setFichatitulacionCollection(Collection<Fichatitulacion> fichatitulacionCollection) {
        this.fichatitulacionCollection = fichatitulacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoprograma != null ? codigoprograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.codigoprograma == null && other.codigoprograma != null) || (this.codigoprograma != null && !this.codigoprograma.equals(other.codigoprograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Programa[ codigoprograma=" + codigoprograma + " ]";
    }
    
}
