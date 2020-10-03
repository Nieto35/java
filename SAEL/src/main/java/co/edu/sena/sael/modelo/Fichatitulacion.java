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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "fichatitulacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichatitulacion.findAll", query = "SELECT f FROM Fichatitulacion f")
    , @NamedQuery(name = "Fichatitulacion.findByNumeroficha", query = "SELECT f FROM Fichatitulacion f WHERE f.numeroficha = :numeroficha")
    , @NamedQuery(name = "Fichatitulacion.findByJornada", query = "SELECT f FROM Fichatitulacion f WHERE f.jornada = :jornada")
    , @NamedQuery(name = "Fichatitulacion.findByFechainicio", query = "SELECT f FROM Fichatitulacion f WHERE f.fechainicio = :fechainicio")
    , @NamedQuery(name = "Fichatitulacion.findByFechafin", query = "SELECT f FROM Fichatitulacion f WHERE f.fechafin = :fechafin")})
public class Fichatitulacion implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroFicha")
    private Collection<Programarseguimiento> programarseguimientoCollection;

    @Column(name = "jornadaficha",length = 50)
    private String jornadaficha;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numeroficha", nullable = false)
    private Integer numeroficha;
    
    @Column(name = "jornada", length = 50)
    private String jornada;
    
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    
    @JoinTable(name = "asignafichas", joinColumns = {
        @JoinColumn(name = "fichatitulacion", referencedColumnName = "numeroficha")}, inverseJoinColumns = {
        @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")})
    @ManyToMany
    private Collection<Instructor> instructorCollection;
    @OneToMany(mappedBy = "fichatitulacion")
    private Collection<Usodeambiente> usodeambienteCollection;
    @OneToMany(mappedBy = "numeroficha")
    private Collection<Reservaambiente> reservaambienteCollection;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne
    private Instructor documentoinstructor;
    @JoinColumn(name = "codigoprograma", referencedColumnName = "codigoprograma")
    @ManyToOne
    private Programa codigoprograma;
    @JoinColumn(name = "numerosede", referencedColumnName = "numerosede")
    @ManyToOne
    private Sede numerosede;
    @OneToMany(mappedBy = "numeroficha")
    private Collection<Seguimiento> seguimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichatitulacion")
    private Collection<Perteneceficha> pertenecefichaCollection;

    public Fichatitulacion() {
    }

    public Fichatitulacion(Integer numeroficha) {
        this.numeroficha = numeroficha;
    }

    public Integer getNumeroficha() {
        return numeroficha;
    }

    public void setNumeroficha(Integer numeroficha) {
        this.numeroficha = numeroficha;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    @XmlTransient
    public Collection<Instructor> getInstructorCollection() {
        return instructorCollection;
    }

    public void setInstructorCollection(Collection<Instructor> instructorCollection) {
        this.instructorCollection = instructorCollection;
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

    public Instructor getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(Instructor documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    public Programa getCodigoprograma() {
        return codigoprograma;
    }

    public void setCodigoprograma(Programa codigoprograma) {
        this.codigoprograma = codigoprograma;
    }

    public Sede getNumerosede() {
        return numerosede;
    }

    public void setNumerosede(Sede numerosede) {
        this.numerosede = numerosede;
    }

    @XmlTransient
    public Collection<Seguimiento> getSeguimientoCollection() {
        return seguimientoCollection;
    }

    public void setSeguimientoCollection(Collection<Seguimiento> seguimientoCollection) {
        this.seguimientoCollection = seguimientoCollection;
    }

    @XmlTransient
    public Collection<Perteneceficha> getPertenecefichaCollection() {
        return pertenecefichaCollection;
    }

    public void setPertenecefichaCollection(Collection<Perteneceficha> pertenecefichaCollection) {
        this.pertenecefichaCollection = pertenecefichaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroficha != null ? numeroficha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichatitulacion)) {
            return false;
        }
        Fichatitulacion other = (Fichatitulacion) object;
        if ((this.numeroficha == null && other.numeroficha != null) || (this.numeroficha != null && !this.numeroficha.equals(other.numeroficha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Fichatitulacion[ numeroficha=" + numeroficha + " ]";
    }

    public String getJornadaficha() {
        return jornadaficha;
    }

    public void setJornadaficha(String jornadaficha) {
        this.jornadaficha = jornadaficha;
    }

    @XmlTransient
    public Collection<Programarseguimiento> getProgramarseguimientoCollection() {
        return programarseguimientoCollection;
    }

    public void setProgramarseguimientoCollection(Collection<Programarseguimiento> programarseguimientoCollection) {
        this.programarseguimientoCollection = programarseguimientoCollection;
    }
    
}
