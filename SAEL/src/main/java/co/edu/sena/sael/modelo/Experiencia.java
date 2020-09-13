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
@Table(name = "experiencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencia.findAll", query = "SELECT e FROM Experiencia e")
    , @NamedQuery(name = "Experiencia.findByCodigoexperiencia", query = "SELECT e FROM Experiencia e WHERE e.codigoexperiencia = :codigoexperiencia")
    , @NamedQuery(name = "Experiencia.findByEmpresaexperiencia", query = "SELECT e FROM Experiencia e WHERE e.empresaexperiencia = :empresaexperiencia")
    , @NamedQuery(name = "Experiencia.findByOcupacionexperiencia", query = "SELECT e FROM Experiencia e WHERE e.ocupacionexperiencia = :ocupacionexperiencia")
    , @NamedQuery(name = "Experiencia.findByFechaingresoexperiencia", query = "SELECT e FROM Experiencia e WHERE e.fechaingresoexperiencia = :fechaingresoexperiencia")
    , @NamedQuery(name = "Experiencia.findByFecharetiroexperiencia", query = "SELECT e FROM Experiencia e WHERE e.fecharetiroexperiencia = :fecharetiroexperiencia")})
public class Experiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoexperiencia")
    private Integer codigoexperiencia;
    @Column(name = "empresaexperiencia", length = 50)//@Size
    private String empresaexperiencia;
    @Column(name = "ocupacionexperiencia", length = 50)//@Size
    private String ocupacionexperiencia;
    
    @Column(name = "fechaingresoexperiencia")
    @Temporal(TemporalType.DATE)
    private Date fechaingresoexperiencia;
    
    @Column(name = "fecharetiroexperiencia")
    @Temporal(TemporalType.DATE)
    private Date fecharetiroexperiencia;
    
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne
    private Instructor documentoinstructor;

    public Experiencia() {
    }

    public Experiencia(Integer codigoexperiencia) {
        this.codigoexperiencia = codigoexperiencia;
    }

    public Integer getCodigoexperiencia() {
        return codigoexperiencia;
    }

    public void setCodigoexperiencia(Integer codigoexperiencia) {
        this.codigoexperiencia = codigoexperiencia;
    }

    public String getEmpresaexperiencia() {
        return empresaexperiencia;
    }

    public void setEmpresaexperiencia(String empresaexperiencia) {
        this.empresaexperiencia = empresaexperiencia;
    }

    public String getOcupacionexperiencia() {
        return ocupacionexperiencia;
    }

    public void setOcupacionexperiencia(String ocupacionexperiencia) {
        this.ocupacionexperiencia = ocupacionexperiencia;
    }

    public Date getFechaingresoexperiencia() {
        return fechaingresoexperiencia;
    }

    public void setFechaingresoexperiencia(Date fechaingresoexperiencia) {
        this.fechaingresoexperiencia = fechaingresoexperiencia;
    }

    public Date getFecharetiroexperiencia() {
        return fecharetiroexperiencia;
    }

    public void setFecharetiroexperiencia(Date fecharetiroexperiencia) {
        this.fecharetiroexperiencia = fecharetiroexperiencia;
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
        hash += (codigoexperiencia != null ? codigoexperiencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencia)) {
            return false;
        }
        Experiencia other = (Experiencia) object;
        if ((this.codigoexperiencia == null && other.codigoexperiencia != null) || (this.codigoexperiencia != null && !this.codigoexperiencia.equals(other.codigoexperiencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Experiencia[ codigoexperiencia=" + codigoexperiencia + " ]";
    }
    
}
