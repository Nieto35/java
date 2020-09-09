<<<<<<< HEAD
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
@Table(name = "elemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elemento.findAll", query = "SELECT e FROM Elemento e")
    , @NamedQuery(name = "Elemento.findByCodigoelemento", query = "SELECT e FROM Elemento e WHERE e.codigoelemento = :codigoelemento")
    , @NamedQuery(name = "Elemento.findBySerialelemento", query = "SELECT e FROM Elemento e WHERE e.serialelemento = :serialelemento")})
public class Elemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoelemento")
    private Integer codigoelemento;
    @Lob
    @Column(name = "descripcionelemento",length =65535)
    private String descripcionelemento;
    @Column(name = "serialelemento",length =50)
    private String serialelemento;
    @OneToMany(mappedBy = "numeroelemento")
    private Collection<Ingreso> ingresoCollection;

    public Elemento() {
    }

    public Elemento(Integer codigoelemento) {
        this.codigoelemento = codigoelemento;
    }

    public Integer getCodigoelemento() {
        return codigoelemento;
    }

    public void setCodigoelemento(Integer codigoelemento) {
        this.codigoelemento = codigoelemento;
    }

    public String getDescripcionelemento() {
        return descripcionelemento;
    }

    public void setDescripcionelemento(String descripcionelemento) {
        this.descripcionelemento = descripcionelemento;
    }

    public String getSerialelemento() {
        return serialelemento;
    }

    public void setSerialelemento(String serialelemento) {
        this.serialelemento = serialelemento;
    }

    @XmlTransient
    public Collection<Ingreso> getIngresoCollection() {
        return ingresoCollection;
    }

    public void setIngresoCollection(Collection<Ingreso> ingresoCollection) {
        this.ingresoCollection = ingresoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoelemento != null ? codigoelemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elemento)) {
            return false;
        }
        Elemento other = (Elemento) object;
        if ((this.codigoelemento == null && other.codigoelemento != null) || (this.codigoelemento != null && !this.codigoelemento.equals(other.codigoelemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Elemento[ codigoelemento=" + codigoelemento + " ]";
    }
    
}
=======
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
 * @author dasak
 */
@Entity
@Table(name = "elemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elemento.findAll", query = "SELECT e FROM Elemento e")
    , @NamedQuery(name = "Elemento.findByCodigoelemento", query = "SELECT e FROM Elemento e WHERE e.codigoelemento = :codigoelemento")
    , @NamedQuery(name = "Elemento.findBySerialelemento", query = "SELECT e FROM Elemento e WHERE e.serialelemento = :serialelemento")})
public class Elemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoelemento")
    private Integer codigoelemento;
    
    @Lob
    @Column(name = "descripcionelemento", length = 65535)
    private String descripcionelemento;

    @Column(name = "serialelemento", length = 50)
    private String serialelemento;
    
    @OneToMany(mappedBy = "numeroelemento")
    private Collection<Ingreso> ingresoCollection;

    public Elemento() {
    }

    public Elemento(Integer codigoelemento) {
        this.codigoelemento = codigoelemento;
    }

    public Integer getCodigoelemento() {
        return codigoelemento;
    }

    public void setCodigoelemento(Integer codigoelemento) {
        this.codigoelemento = codigoelemento;
    }

    public String getDescripcionelemento() {
        return descripcionelemento;
    }

    public void setDescripcionelemento(String descripcionelemento) {
        this.descripcionelemento = descripcionelemento;
    }

    public String getSerialelemento() {
        return serialelemento;
    }

    public void setSerialelemento(String serialelemento) {
        this.serialelemento = serialelemento;
    }

    @XmlTransient
    public Collection<Ingreso> getIngresoCollection() {
        return ingresoCollection;
    }

    public void setIngresoCollection(Collection<Ingreso> ingresoCollection) {
        this.ingresoCollection = ingresoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoelemento != null ? codigoelemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elemento)) {
            return false;
        }
        Elemento other = (Elemento) object;
        if ((this.codigoelemento == null && other.codigoelemento != null) || (this.codigoelemento != null && !this.codigoelemento.equals(other.codigoelemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Elemento[ codigoelemento=" + codigoelemento + " ]";
    }
    
}
>>>>>>> v1
