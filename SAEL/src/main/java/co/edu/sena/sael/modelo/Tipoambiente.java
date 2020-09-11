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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tipoambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoambiente.findAll", query = "SELECT t FROM Tipoambiente t")
    , @NamedQuery(name = "Tipoambiente.findByCodigotipoambiente", query = "SELECT t FROM Tipoambiente t WHERE t.codigotipoambiente = :codigotipoambiente")
    , @NamedQuery(name = "Tipoambiente.findByDescripciontipoambiente", query = "SELECT t FROM Tipoambiente t WHERE t.descripciontipoambiente = :descripciontipoambiente")})
public class Tipoambiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigotipoambiente")
    private Integer codigotipoambiente;
    @Column(name = "descripciontipoambiente", length = 50)
    private String descripciontipoambiente;
    @OneToMany(mappedBy = "codigotipoambiente")
    private Collection<Ambienteaprendizaje> ambienteaprendizajeCollection;

    public Tipoambiente() {
    }

    public Tipoambiente(Integer codigotipoambiente) {
        this.codigotipoambiente = codigotipoambiente;
    }

    public Integer getCodigotipoambiente() {
        return codigotipoambiente;
    }

    public void setCodigotipoambiente(Integer codigotipoambiente) {
        this.codigotipoambiente = codigotipoambiente;
    }

    public String getDescripciontipoambiente() {
        return descripciontipoambiente;
    }

    public void setDescripciontipoambiente(String descripciontipoambiente) {
        this.descripciontipoambiente = descripciontipoambiente;
    }

    @XmlTransient
    public Collection<Ambienteaprendizaje> getAmbienteaprendizajeCollection() {
        return ambienteaprendizajeCollection;
    }

    public void setAmbienteaprendizajeCollection(Collection<Ambienteaprendizaje> ambienteaprendizajeCollection) {
        this.ambienteaprendizajeCollection = ambienteaprendizajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigotipoambiente != null ? codigotipoambiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoambiente)) {
            return false;
        }
        Tipoambiente other = (Tipoambiente) object;
        if ((this.codigotipoambiente == null && other.codigotipoambiente != null) || (this.codigotipoambiente != null && !this.codigotipoambiente.equals(other.codigotipoambiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Tipoambiente[ codigotipoambiente=" + codigotipoambiente + " ]";
    }
    
}
