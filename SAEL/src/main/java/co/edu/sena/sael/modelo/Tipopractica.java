/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "tipopractica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopractica.findAll", query = "SELECT t FROM Tipopractica t")
    , @NamedQuery(name = "Tipopractica.findByCodigotipopractica", query = "SELECT t FROM Tipopractica t WHERE t.codigotipopractica = :codigotipopractica")
    , @NamedQuery(name = "Tipopractica.findByNombretipopractica", query = "SELECT t FROM Tipopractica t WHERE t.nombretipopractica = :nombretipopractica")})
public class Tipopractica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigotipopractica")
    private Integer codigotipopractica;
    @Column(name = "nombretipopractica",length =50)
    private String nombretipopractica;
    @Lob
    @Column(name = "descripciontipopractica",length =65535)
    private String descripciontipopractica;
    @OneToMany(mappedBy = "codigotipopractica")
    private Collection<Eproductiva> eproductivaCollection;

    public Tipopractica() {
    }

    public Tipopractica(Integer codigotipopractica) {
        this.codigotipopractica = codigotipopractica;
    }

    public Integer getCodigotipopractica() {
        return codigotipopractica;
    }

    public void setCodigotipopractica(Integer codigotipopractica) {
        this.codigotipopractica = codigotipopractica;
    }

    public String getNombretipopractica() {
        return nombretipopractica;
    }

    public void setNombretipopractica(String nombretipopractica) {
        this.nombretipopractica = nombretipopractica;
    }

    public String getDescripciontipopractica() {
        return descripciontipopractica;
    }

    public void setDescripciontipopractica(String descripciontipopractica) {
        this.descripciontipopractica = descripciontipopractica;
    }

    @XmlTransient
    public Collection<Eproductiva> getEproductivaCollection() {
        return eproductivaCollection;
    }

    public void setEproductivaCollection(Collection<Eproductiva> eproductivaCollection) {
        this.eproductivaCollection = eproductivaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigotipopractica != null ? codigotipopractica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopractica)) {
            return false;
        }
        Tipopractica other = (Tipopractica) object;
        if ((this.codigotipopractica == null && other.codigotipopractica != null) || (this.codigotipopractica != null && !this.codigotipopractica.equals(other.codigotipopractica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Tipopractica[ codigotipopractica=" + codigotipopractica + " ]";
    }
    
}
