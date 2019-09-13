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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "inasistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inasistencia.findAll", query = "SELECT i FROM Inasistencia i")
    , @NamedQuery(name = "Inasistencia.findByCodigoinasistencia", query = "SELECT i FROM Inasistencia i WHERE i.codigoinasistencia = :codigoinasistencia")
    , @NamedQuery(name = "Inasistencia.findByFechainasistencia", query = "SELECT i FROM Inasistencia i WHERE i.fechainasistencia = :fechainasistencia")
    , @NamedQuery(name = "Inasistencia.findByHorasinasistencia", query = "SELECT i FROM Inasistencia i WHERE i.horasinasistencia = :horasinasistencia")
    , @NamedQuery(name = "Inasistencia.findByExcusainasistencia", query = "SELECT i FROM Inasistencia i WHERE i.excusainasistencia = :excusainasistencia")})
public class Inasistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoinasistencia")
    private Integer codigoinasistencia;
    @Column(name = "fechainasistencia")
    @Temporal(TemporalType.DATE)
    private Date fechainasistencia;
    @Column(name = "horasinasistencia")
    private Integer horasinasistencia;
    @Size(max = 50)
    @Column(name = "excusainasistencia")
    private String excusainasistencia;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentoaprendiz")
    @ManyToOne
    private Aprendiz documentoaprendiz;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne
    private Instructor documentoinstructor;

    public Inasistencia() {
    }

    public Inasistencia(Integer codigoinasistencia) {
        this.codigoinasistencia = codigoinasistencia;
    }

    public Integer getCodigoinasistencia() {
        return codigoinasistencia;
    }

    public void setCodigoinasistencia(Integer codigoinasistencia) {
        this.codigoinasistencia = codigoinasistencia;
    }

    public Date getFechainasistencia() {
        return fechainasistencia;
    }

    public void setFechainasistencia(Date fechainasistencia) {
        this.fechainasistencia = fechainasistencia;
    }

    public Integer getHorasinasistencia() {
        return horasinasistencia;
    }

    public void setHorasinasistencia(Integer horasinasistencia) {
        this.horasinasistencia = horasinasistencia;
    }

    public String getExcusainasistencia() {
        return excusainasistencia;
    }

    public void setExcusainasistencia(String excusainasistencia) {
        this.excusainasistencia = excusainasistencia;
    }

    public Aprendiz getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(Aprendiz documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
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
        hash += (codigoinasistencia != null ? codigoinasistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inasistencia)) {
            return false;
        }
        Inasistencia other = (Inasistencia) object;
        if ((this.codigoinasistencia == null && other.codigoinasistencia != null) || (this.codigoinasistencia != null && !this.codigoinasistencia.equals(other.codigoinasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Inasistencia[ codigoinasistencia=" + codigoinasistencia + " ]";
    }
    
}
