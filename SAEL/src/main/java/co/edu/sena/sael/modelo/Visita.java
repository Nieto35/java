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
@Table(name = "visita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visita.findAll", query = "SELECT v FROM Visita v")
    , @NamedQuery(name = "Visita.findByNumerovisita", query = "SELECT v FROM Visita v WHERE v.numerovisita = :numerovisita")
    , @NamedQuery(name = "Visita.findByFechavisita", query = "SELECT v FROM Visita v WHERE v.fechavisita = :fechavisita")
    , @NamedQuery(name = "Visita.findByEstadovisita", query = "SELECT v FROM Visita v WHERE v.estadovisita = :estadovisita")})
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numerovisita")
    private Integer numerovisita;
    @Column(name = "fechavisita")
    @Temporal(TemporalType.DATE)
    private Date fechavisita;
    @Lob
    @Column(name = "observacionesvisita",length = 65535)// @Size(max = 65535)
    private String observacionesvisita; 
    @Column(name = "estadovisita", length = 50)// @Size(max = 50)
    private String estadovisita;
    @JoinColumn(name = "codigoeproductiva", referencedColumnName = "codigoeproductiva")
    @ManyToOne
    private Eproductiva codigoeproductiva;

    public Visita() {
    }

    public Visita(Integer numerovisita) {
        this.numerovisita = numerovisita;
    }

    public Integer getNumerovisita() {
        return numerovisita;
    }

    public void setNumerovisita(Integer numerovisita) {
        this.numerovisita = numerovisita;
    }

    public Date getFechavisita() {
        return fechavisita;
    }

    public void setFechavisita(Date fechavisita) {
        this.fechavisita = fechavisita;
    }

    public String getObservacionesvisita() {
        return observacionesvisita;
    }

    public void setObservacionesvisita(String observacionesvisita) {
        this.observacionesvisita = observacionesvisita;
    }

    public String getEstadovisita() {
        return estadovisita;
    }

    public void setEstadovisita(String estadovisita) {
        this.estadovisita = estadovisita;
    }

    public Eproductiva getCodigoeproductiva() {
        return codigoeproductiva;
    }

    public void setCodigoeproductiva(Eproductiva codigoeproductiva) {
        this.codigoeproductiva = codigoeproductiva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerovisita != null ? numerovisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.numerovisita == null && other.numerovisita != null) || (this.numerovisita != null && !this.numerovisita.equals(other.numerovisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Visita[ numerovisita=" + numerovisita + " ]";
    }
    
}
