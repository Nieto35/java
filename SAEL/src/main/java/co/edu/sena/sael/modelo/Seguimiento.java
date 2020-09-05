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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author Felipe
 */
@Entity
@Table(name = "seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s")
    , @NamedQuery(name = "Seguimiento.findByCodigoseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.codigoseguimiento = :codigoseguimiento")
    , @NamedQuery(name = "Seguimiento.findByNumeroseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.numeroseguimiento = :numeroseguimiento")
    , @NamedQuery(name = "Seguimiento.findByFechaseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.fechaseguimiento = :fechaseguimiento")
    , @NamedQuery(name = "Seguimiento.findByFaseseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.faseseguimiento = :faseseguimiento")
    , @NamedQuery(name = "Seguimiento.findByLugarseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.lugarseguimiento = :lugarseguimiento")
    , @NamedQuery(name = "Seguimiento.findByHorainicioseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.horainicioseguimiento = :horainicioseguimiento")
    , @NamedQuery(name = "Seguimiento.findByHorafinseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.horafinseguimiento = :horafinseguimiento")
    , @NamedQuery(name = "Seguimiento.findByEstadoseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.estadoseguimiento = :estadoseguimiento")})
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoseguimiento")
    private Integer codigoseguimiento;
    @Column(name = "numeroseguimiento")
    private Integer numeroseguimiento;
    @Column(name = "fechaseguimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaseguimiento;
    @Column(name = "faseseguimiento", length = 50)//@Size(max = 50)
    private String faseseguimiento;
    @Lob
    @Column(name = "observacionesseguimiento", length = 65535)//@Size(max = 65535)
    private String observacionesseguimiento;
    @Lob 
    @Column(name = "conclusionesseguimiento", length = 65535 )//@Size(max = 65535)
    private String conclusionesseguimiento;
    @Lob
    @Column(name = "compromisosseguimiento", length = 65535 )//@Size(max = 65535)
    private String compromisosseguimiento;
    @Column(name = "lugarseguimiento", length = 50 )//@Size(max = 50)
    private String lugarseguimiento;
    @Column(name = "horainicioseguimiento")
    @Temporal(TemporalType.TIME)
    private Date horainicioseguimiento;
    @Column(name = "horafinseguimiento")
    @Temporal(TemporalType.TIME)
    private Date horafinseguimiento;
    @Column(name = "estadoseguimiento",length = 50 )//@Size(max = 50)
    private String estadoseguimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seguimiento")
    private Collection<Comite> comiteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seguimiento")
    private Collection<Seguimientoaprendiz> seguimientoaprendizCollection;
    @JoinColumn(name = "numeroficha", referencedColumnName = "numeroficha")
    @ManyToOne
    private Fichatitulacion numeroficha;

    public Seguimiento() {
    }

    public Seguimiento(Integer codigoseguimiento) {
        this.codigoseguimiento = codigoseguimiento;
    }

    public Integer getCodigoseguimiento() {
        return codigoseguimiento;
    }

    public void setCodigoseguimiento(Integer codigoseguimiento) {
        this.codigoseguimiento = codigoseguimiento;
    }

    public Integer getNumeroseguimiento() {
        return numeroseguimiento;
    }

    public void setNumeroseguimiento(Integer numeroseguimiento) {
        this.numeroseguimiento = numeroseguimiento;
    }

    public Date getFechaseguimiento() {
        return fechaseguimiento;
    }

    public void setFechaseguimiento(Date fechaseguimiento) {
        this.fechaseguimiento = fechaseguimiento;
    }

    public String getFaseseguimiento() {
        return faseseguimiento;
    }

    public void setFaseseguimiento(String faseseguimiento) {
        this.faseseguimiento = faseseguimiento;
    }

    public String getObservacionesseguimiento() {
        return observacionesseguimiento;
    }

    public void setObservacionesseguimiento(String observacionesseguimiento) {
        this.observacionesseguimiento = observacionesseguimiento;
    }

    public String getConclusionesseguimiento() {
        return conclusionesseguimiento;
    }

    public void setConclusionesseguimiento(String conclusionesseguimiento) {
        this.conclusionesseguimiento = conclusionesseguimiento;
    }

    public String getCompromisosseguimiento() {
        return compromisosseguimiento;
    }

    public void setCompromisosseguimiento(String compromisosseguimiento) {
        this.compromisosseguimiento = compromisosseguimiento;
    }

    public String getLugarseguimiento() {
        return lugarseguimiento;
    }

    public void setLugarseguimiento(String lugarseguimiento) {
        this.lugarseguimiento = lugarseguimiento;
    }

    public Date getHorainicioseguimiento() {
        return horainicioseguimiento;
    }

    public void setHorainicioseguimiento(Date horainicioseguimiento) {
        this.horainicioseguimiento = horainicioseguimiento;
    }

    public Date getHorafinseguimiento() {
        return horafinseguimiento;
    }

    public void setHorafinseguimiento(Date horafinseguimiento) {
        this.horafinseguimiento = horafinseguimiento;
    }

    public String getEstadoseguimiento() {
        return estadoseguimiento;
    }

    public void setEstadoseguimiento(String estadoseguimiento) {
        this.estadoseguimiento = estadoseguimiento;
    }

    @XmlTransient
    public Collection<Comite> getComiteCollection() {
        return comiteCollection;
    }

    public void setComiteCollection(Collection<Comite> comiteCollection) {
        this.comiteCollection = comiteCollection;
    }

    @XmlTransient
    public Collection<Seguimientoaprendiz> getSeguimientoaprendizCollection() {
        return seguimientoaprendizCollection;
    }

    public void setSeguimientoaprendizCollection(Collection<Seguimientoaprendiz> seguimientoaprendizCollection) {
        this.seguimientoaprendizCollection = seguimientoaprendizCollection;
    }

    public Fichatitulacion getNumeroficha() {
        return numeroficha;
    }

    public void setNumeroficha(Fichatitulacion numeroficha) {
        this.numeroficha = numeroficha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoseguimiento != null ? codigoseguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.codigoseguimiento == null && other.codigoseguimiento != null) || (this.codigoseguimiento != null && !this.codigoseguimiento.equals(other.codigoseguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Seguimiento[ codigoseguimiento=" + codigoseguimiento + " ]";
    }
    
}
