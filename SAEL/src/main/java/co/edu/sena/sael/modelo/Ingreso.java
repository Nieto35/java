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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "ingreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i")
    , @NamedQuery(name = "Ingreso.findByNumeroingreso", query = "SELECT i FROM Ingreso i WHERE i.numeroingreso = :numeroingreso")
    , @NamedQuery(name = "Ingreso.findByFechaingreso", query = "SELECT i FROM Ingreso i WHERE i.fechaingreso = :fechaingreso")
    , @NamedQuery(name = "Ingreso.findByHoraingreso", query = "SELECT i FROM Ingreso i WHERE i.horaingreso = :horaingreso")
    , @NamedQuery(name = "Ingreso.findByFechasalida", query = "SELECT i FROM Ingreso i WHERE i.fechasalida = :fechasalida")
    , @NamedQuery(name = "Ingreso.findByHorasalida", query = "SELECT i FROM Ingreso i WHERE i.horasalida = :horasalida")})
public class Ingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeroingreso")
    private Integer numeroingreso;
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Column(name = "horaingreso",length =50)
    private String horaingreso;
    @Column(name = "fechasalida")
    @Temporal(TemporalType.DATE)
    private Date fechasalida;
    @Column(name = "horasalida",length =50)
    private String horasalida;
    @Lob
    @Column(name = "motivoingreso",length =65535)
    private String motivoingreso;
    @JoinColumn(name = "numeroelemento", referencedColumnName = "codigoelemento")
    @ManyToOne
    private Elemento numeroelemento;
    @JoinColumn(name = "documentopersonal", referencedColumnName = "documentopersonal")
    @ManyToOne
    private Personal documentopersonal;

    public Ingreso() {
    }

    public Ingreso(Integer numeroingreso) {
        this.numeroingreso = numeroingreso;
    }

    public Integer getNumeroingreso() {
        return numeroingreso;
    }

    public void setNumeroingreso(Integer numeroingreso) {
        this.numeroingreso = numeroingreso;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getHoraingreso() {
        return horaingreso;
    }

    public void setHoraingreso(String horaingreso) {
        this.horaingreso = horaingreso;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public String getMotivoingreso() {
        return motivoingreso;
    }

    public void setMotivoingreso(String motivoingreso) {
        this.motivoingreso = motivoingreso;
    }

    public Elemento getNumeroelemento() {
        return numeroelemento;
    }

    public void setNumeroelemento(Elemento numeroelemento) {
        this.numeroelemento = numeroelemento;
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
        hash += (numeroingreso != null ? numeroingreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.numeroingreso == null && other.numeroingreso != null) || (this.numeroingreso != null && !this.numeroingreso.equals(other.numeroingreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Ingreso[ numeroingreso=" + numeroingreso + " ]";
    }
    
}
