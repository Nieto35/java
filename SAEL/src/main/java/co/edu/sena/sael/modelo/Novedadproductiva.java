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
@Table(name = "novedadproductiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedadproductiva.findAll", query = "SELECT n FROM Novedadproductiva n")
    , @NamedQuery(name = "Novedadproductiva.findByNumeronovedad", query = "SELECT n FROM Novedadproductiva n WHERE n.numeronovedad = :numeronovedad")
    , @NamedQuery(name = "Novedadproductiva.findByFechanovedad", query = "SELECT n FROM Novedadproductiva n WHERE n.fechanovedad = :fechanovedad")})
public class Novedadproductiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeronovedad")
    private Integer numeronovedad;
    @Column(name = "fechanovedad")
    @Temporal(TemporalType.DATE)
    private Date fechanovedad;
    @Lob
    @Column(name = "observacionesnovedad", length = 65535)//@Size
    private String observacionesnovedad;
    @JoinColumn(name = "codigoeproductiva", referencedColumnName = "codigoeproductiva")
    @ManyToOne
    private Eproductiva codigoeproductiva;

    public Novedadproductiva() {
    }

    public Novedadproductiva(Integer numeronovedad) {
        this.numeronovedad = numeronovedad;
    }

    public Integer getNumeronovedad() {
        return numeronovedad;
    }

    public void setNumeronovedad(Integer numeronovedad) {
        this.numeronovedad = numeronovedad;
    }

    public Date getFechanovedad() {
        return fechanovedad;
    }

    public void setFechanovedad(Date fechanovedad) {
        this.fechanovedad = fechanovedad;
    }

    public String getObservacionesnovedad() {
        return observacionesnovedad;
    }

    public void setObservacionesnovedad(String observacionesnovedad) {
        this.observacionesnovedad = observacionesnovedad;
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
        hash += (numeronovedad != null ? numeronovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedadproductiva)) {
            return false;
        }
        Novedadproductiva other = (Novedadproductiva) object;
        if ((this.numeronovedad == null && other.numeronovedad != null) || (this.numeronovedad != null && !this.numeronovedad.equals(other.numeronovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Novedadproductiva[ numeronovedad=" + numeronovedad + " ]";
    }
    
}
