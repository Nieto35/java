/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "reservaambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservaambiente.findAll", query = "SELECT r FROM Reservaambiente r")
    , @NamedQuery(name = "Reservaambiente.findByCodigoreservaambiente", query = "SELECT r FROM Reservaambiente r WHERE r.codigoreservaambiente = :codigoreservaambiente")
    , @NamedQuery(name = "Reservaambiente.findByFechainicioreservaambiente", query = "SELECT r FROM Reservaambiente r WHERE r.fechainicioreservaambiente = :fechainicioreservaambiente")
    , @NamedQuery(name = "Reservaambiente.findByFechafinreservaambiente", query = "SELECT r FROM Reservaambiente r WHERE r.fechafinreservaambiente = :fechafinreservaambiente")
    , @NamedQuery(name = "Reservaambiente.findByHorainicioreservaambiente", query = "SELECT r FROM Reservaambiente r WHERE r.horainicioreservaambiente = :horainicioreservaambiente")
    , @NamedQuery(name = "Reservaambiente.findByHorafinreservaambiente", query = "SELECT r FROM Reservaambiente r WHERE r.horafinreservaambiente = :horafinreservaambiente")})
public class Reservaambiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoreservaambiente")
    private Integer codigoreservaambiente;
    @Column(name = "fechainicioreservaambiente")
    @Temporal(TemporalType.DATE)
    private Date fechainicioreservaambiente;
    @Column(name = "fechafinreservaambiente")
    @Temporal(TemporalType.DATE)
    private Date fechafinreservaambiente;
    @Column(name = "horainicioreservaambiente")
    @Temporal(TemporalType.TIME)
    private Date horainicioreservaambiente;
    @Column(name = "horafinreservaambiente")
    @Temporal(TemporalType.TIME)
    private Date horafinreservaambiente;
    @OneToMany(mappedBy = "codigoreserva")
    private Collection<Usodeambiente> usodeambienteCollection;
    @JoinColumn(name = "codigoambiente", referencedColumnName = "codigoambiente")
    @ManyToOne
    private Ambienteaprendizaje codigoambiente;
    @JoinColumn(name = "numeroficha", referencedColumnName = "numeroficha")
    @ManyToOne
    private Fichatitulacion numeroficha;
    @JoinColumn(name = "documentopersonal", referencedColumnName = "documentopersonal")
    @ManyToOne
    private Personal documentopersonal;

    public Reservaambiente() {
    }

    public Reservaambiente(Integer codigoreservaambiente) {
        this.codigoreservaambiente = codigoreservaambiente;
    }

    public Integer getCodigoreservaambiente() {
        return codigoreservaambiente;
    }

    public void setCodigoreservaambiente(Integer codigoreservaambiente) {
        this.codigoreservaambiente = codigoreservaambiente;
    }

    public Date getFechainicioreservaambiente() {
        return fechainicioreservaambiente;
    }

    public void setFechainicioreservaambiente(Date fechainicioreservaambiente) {
        this.fechainicioreservaambiente = fechainicioreservaambiente;
    }

    public Date getFechafinreservaambiente() {
        return fechafinreservaambiente;
    }

    public void setFechafinreservaambiente(Date fechafinreservaambiente) {
        this.fechafinreservaambiente = fechafinreservaambiente;
    }

    public Date getHorainicioreservaambiente() {
        return horainicioreservaambiente;
    }

    public void setHorainicioreservaambiente(Date horainicioreservaambiente) {
        this.horainicioreservaambiente = horainicioreservaambiente;
    }

    public Date getHorafinreservaambiente() {
        return horafinreservaambiente;
    }

    public void setHorafinreservaambiente(Date horafinreservaambiente) {
        this.horafinreservaambiente = horafinreservaambiente;
    }

    @XmlTransient
    public Collection<Usodeambiente> getUsodeambienteCollection() {
        return usodeambienteCollection;
    }

    public void setUsodeambienteCollection(Collection<Usodeambiente> usodeambienteCollection) {
        this.usodeambienteCollection = usodeambienteCollection;
    }

    public Ambienteaprendizaje getCodigoambiente() {
        return codigoambiente;
    }

    public void setCodigoambiente(Ambienteaprendizaje codigoambiente) {
        this.codigoambiente = codigoambiente;
    }

    public Fichatitulacion getNumeroficha() {
        return numeroficha;
    }

    public void setNumeroficha(Fichatitulacion numeroficha) {
        this.numeroficha = numeroficha;
    }

    public Personal getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(Personal documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoreservaambiente != null ? codigoreservaambiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservaambiente)) {
            return false;
        }
        Reservaambiente other = (Reservaambiente) object;
        if ((this.codigoreservaambiente == null && other.codigoreservaambiente != null) || (this.codigoreservaambiente != null && !this.codigoreservaambiente.equals(other.codigoreservaambiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Reservaambiente[ codigoreservaambiente=" + codigoreservaambiente + " ]";
    }
    
}
