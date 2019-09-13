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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "ambienteaprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ambienteaprendizaje.findAll", query = "SELECT a FROM Ambienteaprendizaje a")
    , @NamedQuery(name = "Ambienteaprendizaje.findByCodigoambiente", query = "SELECT a FROM Ambienteaprendizaje a WHERE a.codigoambiente = :codigoambiente")
    , @NamedQuery(name = "Ambienteaprendizaje.findByNombreambiente", query = "SELECT a FROM Ambienteaprendizaje a WHERE a.nombreambiente = :nombreambiente")
    , @NamedQuery(name = "Ambienteaprendizaje.findByCapacidadambiente", query = "SELECT a FROM Ambienteaprendizaje a WHERE a.capacidadambiente = :capacidadambiente")
    , @NamedQuery(name = "Ambienteaprendizaje.findByAreaambiente", query = "SELECT a FROM Ambienteaprendizaje a WHERE a.areaambiente = :areaambiente")
    , @NamedQuery(name = "Ambienteaprendizaje.findByEstadoambiente", query = "SELECT a FROM Ambienteaprendizaje a WHERE a.estadoambiente = :estadoambiente")})
public class Ambienteaprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoambiente")
    private Integer codigoambiente;
    @Size(max = 50)
    @Column(name = "nombreambiente")
    private String nombreambiente;
    @Column(name = "capacidadambiente")
    private Integer capacidadambiente;
    @Column(name = "areaambiente")
    private Integer areaambiente;
    @Size(max = 50)
    @Column(name = "estadoambiente")
    private String estadoambiente;
    @JoinColumn(name = "numerosede", referencedColumnName = "numerosede")
    @ManyToOne
    private Sede numerosede;
    @JoinColumn(name = "codigotipoambiente", referencedColumnName = "codigotipoambiente")
    @ManyToOne
    private Tipoambiente codigotipoambiente;
    @OneToMany(mappedBy = "codigoambiente")
    private Collection<Usodeambiente> usodeambienteCollection;
    @OneToMany(mappedBy = "codigoambiente")
    private Collection<Reservaambiente> reservaambienteCollection;

    public Ambienteaprendizaje() {
    }

    public Ambienteaprendizaje(Integer codigoambiente) {
        this.codigoambiente = codigoambiente;
    }

    public Integer getCodigoambiente() {
        return codigoambiente;
    }

    public void setCodigoambiente(Integer codigoambiente) {
        this.codigoambiente = codigoambiente;
    }

    public String getNombreambiente() {
        return nombreambiente;
    }

    public void setNombreambiente(String nombreambiente) {
        this.nombreambiente = nombreambiente;
    }

    public Integer getCapacidadambiente() {
        return capacidadambiente;
    }

    public void setCapacidadambiente(Integer capacidadambiente) {
        this.capacidadambiente = capacidadambiente;
    }

    public Integer getAreaambiente() {
        return areaambiente;
    }

    public void setAreaambiente(Integer areaambiente) {
        this.areaambiente = areaambiente;
    }

    public String getEstadoambiente() {
        return estadoambiente;
    }

    public void setEstadoambiente(String estadoambiente) {
        this.estadoambiente = estadoambiente;
    }

    public Sede getNumerosede() {
        return numerosede;
    }

    public void setNumerosede(Sede numerosede) {
        this.numerosede = numerosede;
    }

    public Tipoambiente getCodigotipoambiente() {
        return codigotipoambiente;
    }

    public void setCodigotipoambiente(Tipoambiente codigotipoambiente) {
        this.codigotipoambiente = codigotipoambiente;
    }

    @XmlTransient
    public Collection<Usodeambiente> getUsodeambienteCollection() {
        return usodeambienteCollection;
    }

    public void setUsodeambienteCollection(Collection<Usodeambiente> usodeambienteCollection) {
        this.usodeambienteCollection = usodeambienteCollection;
    }

    @XmlTransient
    public Collection<Reservaambiente> getReservaambienteCollection() {
        return reservaambienteCollection;
    }

    public void setReservaambienteCollection(Collection<Reservaambiente> reservaambienteCollection) {
        this.reservaambienteCollection = reservaambienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoambiente != null ? codigoambiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambienteaprendizaje)) {
            return false;
        }
        Ambienteaprendizaje other = (Ambienteaprendizaje) object;
        if ((this.codigoambiente == null && other.codigoambiente != null) || (this.codigoambiente != null && !this.codigoambiente.equals(other.codigoambiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Ambienteaprendizaje[ codigoambiente=" + codigoambiente + " ]";
    }
    
}
