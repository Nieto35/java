/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "capacitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitacion.findAll", query = "SELECT c FROM Capacitacion c")
    , @NamedQuery(name = "Capacitacion.findByCodigocapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.codigocapacitacion = :codigocapacitacion")
    , @NamedQuery(name = "Capacitacion.findByNombrecapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.nombrecapacitacion = :nombrecapacitacion")
    , @NamedQuery(name = "Capacitacion.findByInstitucioncapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.institucioncapacitacion = :institucioncapacitacion")
    , @NamedQuery(name = "Capacitacion.findByFechacapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.fechacapacitacion = :fechacapacitacion")
    , @NamedQuery(name = "Capacitacion.findByTiempocapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.tiempocapacitacion = :tiempocapacitacion")
    , @NamedQuery(name = "Capacitacion.findByTipotiempocapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.tipotiempocapacitacion = :tipotiempocapacitacion")})
public class Capacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigocapacitacion")
    private Integer codigocapacitacion;
    @Column(name = "nombrecapacitacion", length = 100)//@Size
    private String nombrecapacitacion;
    @Column(name = "institucioncapacitacion", length = 100)//@Size
    private String institucioncapacitacion;
    
    @Column(name = "fechacapacitacion")
    @Temporal(TemporalType.DATE)
    private Date fechacapacitacion;
    
    @Column(name = "tiempocapacitacion")
    private Integer tiempocapacitacion;
    @Column(name = "tipotiempocapacitacion", length = 100)//@Size
    private String tipotiempocapacitacion;
    
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne
    private Instructor documentoinstructor;

    public Capacitacion() {
    }

    public Capacitacion(Integer codigocapacitacion) {
        this.codigocapacitacion = codigocapacitacion;
    }

    public Integer getCodigocapacitacion() {
        return codigocapacitacion;
    }

    public void setCodigocapacitacion(Integer codigocapacitacion) {
        this.codigocapacitacion = codigocapacitacion;
    }

    public String getNombrecapacitacion() {
        return nombrecapacitacion;
    }

    public void setNombrecapacitacion(String nombrecapacitacion) {
        this.nombrecapacitacion = nombrecapacitacion;
    }

    public String getInstitucioncapacitacion() {
        return institucioncapacitacion;
    }

    public void setInstitucioncapacitacion(String institucioncapacitacion) {
        this.institucioncapacitacion = institucioncapacitacion;
    }

    public Date getFechacapacitacion() {
        return fechacapacitacion;
    }

    public void setFechacapacitacion(Date fechacapacitacion) {
        this.fechacapacitacion = fechacapacitacion;
    }

    public Integer getTiempocapacitacion() {
        return tiempocapacitacion;
    }

    public void setTiempocapacitacion(Integer tiempocapacitacion) {
        this.tiempocapacitacion = tiempocapacitacion;
    }

    public String getTipotiempocapacitacion() {
        return tipotiempocapacitacion;
    }

    public void setTipotiempocapacitacion(String tipotiempocapacitacion) {
        this.tipotiempocapacitacion = tipotiempocapacitacion;
    }

    public Instructor getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(Instructor documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocapacitacion != null ? codigocapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitacion)) {
            return false;
        }
        Capacitacion other = (Capacitacion) object;
        if ((this.codigocapacitacion == null && other.codigocapacitacion != null) || (this.codigocapacitacion != null && !this.codigocapacitacion.equals(other.codigocapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Capacitacion[ codigocapacitacion=" + codigocapacitacion + " ]";
    }
    
}
