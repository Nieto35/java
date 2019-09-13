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
@Table(name = "dependencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependencia.findAll", query = "SELECT d FROM Dependencia d")
    , @NamedQuery(name = "Dependencia.findByCodigodependencia", query = "SELECT d FROM Dependencia d WHERE d.codigodependencia = :codigodependencia")
    , @NamedQuery(name = "Dependencia.findByNombredependencia", query = "SELECT d FROM Dependencia d WHERE d.nombredependencia = :nombredependencia")})
public class Dependencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigodependencia")
    private Integer codigodependencia;
    @Size(max = 100)
    @Column(name = "nombredependencia")
    private String nombredependencia;
    @OneToMany(mappedBy = "codigodependencia")
    private Collection<Area> areaCollection;

    public Dependencia() {
    }

    public Dependencia(Integer codigodependencia) {
        this.codigodependencia = codigodependencia;
    }

    public Integer getCodigodependencia() {
        return codigodependencia;
    }

    public void setCodigodependencia(Integer codigodependencia) {
        this.codigodependencia = codigodependencia;
    }

    public String getNombredependencia() {
        return nombredependencia;
    }

    public void setNombredependencia(String nombredependencia) {
        this.nombredependencia = nombredependencia;
    }

    @XmlTransient
    public Collection<Area> getAreaCollection() {
        return areaCollection;
    }

    public void setAreaCollection(Collection<Area> areaCollection) {
        this.areaCollection = areaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigodependencia != null ? codigodependencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependencia)) {
            return false;
        }
        Dependencia other = (Dependencia) object;
        if ((this.codigodependencia == null && other.codigodependencia != null) || (this.codigodependencia != null && !this.codigodependencia.equals(other.codigodependencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Dependencia[ codigodependencia=" + codigodependencia + " ]";
    }
    
}
