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
@Table(name = "comiteproductiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comiteproductiva.findAll", query = "SELECT c FROM Comiteproductiva c")
    , @NamedQuery(name = "Comiteproductiva.findByNumerocomite", query = "SELECT c FROM Comiteproductiva c WHERE c.numerocomite = :numerocomite")
    , @NamedQuery(name = "Comiteproductiva.findByFechacomite", query = "SELECT c FROM Comiteproductiva c WHERE c.fechacomite = :fechacomite")
    , @NamedQuery(name = "Comiteproductiva.findByActacomite", query = "SELECT c FROM Comiteproductiva c WHERE c.actacomite = :actacomite")})
public class Comiteproductiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numerocomite")
    private Integer numerocomite;
    @Column(name = "fechacomite")
    @Temporal(TemporalType.DATE)
    private Date fechacomite;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacionescomite")
    private String observacionescomite;
    @Size(max = 50)
    @Column(name = "actacomite")
    private String actacomite;
    @JoinColumn(name = "codigoeproductiva", referencedColumnName = "codigoeproductiva")
    @ManyToOne
    private Eproductiva codigoeproductiva;

    public Comiteproductiva() {
    }

    public Comiteproductiva(Integer numerocomite) {
        this.numerocomite = numerocomite;
    }

    public Integer getNumerocomite() {
        return numerocomite;
    }

    public void setNumerocomite(Integer numerocomite) {
        this.numerocomite = numerocomite;
    }

    public Date getFechacomite() {
        return fechacomite;
    }

    public void setFechacomite(Date fechacomite) {
        this.fechacomite = fechacomite;
    }

    public String getObservacionescomite() {
        return observacionescomite;
    }

    public void setObservacionescomite(String observacionescomite) {
        this.observacionescomite = observacionescomite;
    }

    public String getActacomite() {
        return actacomite;
    }

    public void setActacomite(String actacomite) {
        this.actacomite = actacomite;
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
        hash += (numerocomite != null ? numerocomite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comiteproductiva)) {
            return false;
        }
        Comiteproductiva other = (Comiteproductiva) object;
        if ((this.numerocomite == null && other.numerocomite != null) || (this.numerocomite != null && !this.numerocomite.equals(other.numerocomite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Comiteproductiva[ numerocomite=" + numerocomite + " ]";
    }
    
}
