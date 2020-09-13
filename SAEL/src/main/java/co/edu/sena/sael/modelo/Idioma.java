/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "idioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idioma.findAll", query = "SELECT i FROM Idioma i")
    , @NamedQuery(name = "Idioma.findByCodigoidioma", query = "SELECT i FROM Idioma i WHERE i.codigoidioma = :codigoidioma")
    , @NamedQuery(name = "Idioma.findByNombreidioma", query = "SELECT i FROM Idioma i WHERE i.nombreidioma = :nombreidioma")})
public class Idioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoidioma")
    private Integer codigoidioma;
    
    @Column(name = "nombreidioma", length = 50)
    private String nombreidioma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idioma")
    private Collection<Hablaidioma> hablaidiomaCollection;

    public Idioma() {
    }

    public Idioma(Integer codigoidioma) {
        this.codigoidioma = codigoidioma;
    }

    public Integer getCodigoidioma() {
        return codigoidioma;
    }

    public void setCodigoidioma(Integer codigoidioma) {
        this.codigoidioma = codigoidioma;
    }

    public String getNombreidioma() {
        return nombreidioma;
    }

    public void setNombreidioma(String nombreidioma) {
        this.nombreidioma = nombreidioma;
    }

    @XmlTransient
    public Collection<Hablaidioma> getHablaidiomaCollection() {
        return hablaidiomaCollection;
    }

    public void setHablaidiomaCollection(Collection<Hablaidioma> hablaidiomaCollection) {
        this.hablaidiomaCollection = hablaidiomaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoidioma != null ? codigoidioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) object;
        if ((this.codigoidioma == null && other.codigoidioma != null) || (this.codigoidioma != null && !this.codigoidioma.equals(other.codigoidioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Idioma[ codigoidioma=" + codigoidioma + " ]";
    }
    
}
