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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "novedadlectiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedadlectiva.findAll", query = "SELECT n FROM Novedadlectiva n")
    , @NamedQuery(name = "Novedadlectiva.findByNumeronovedad", query = "SELECT n FROM Novedadlectiva n WHERE n.numeronovedad = :numeronovedad")
    , @NamedQuery(name = "Novedadlectiva.findByNombre", query = "SELECT n FROM Novedadlectiva n WHERE n.nombre = :nombre")})
public class Novedadlectiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeronovedad")
    private Integer numeronovedad;
    @Column(name = "nombre", length = 50)//@Size
    private String nombre;
    @OneToMany(mappedBy = "numeronovedad")
    private Collection<Seguimientoaprendiz> seguimientoaprendizCollection;

    public Novedadlectiva() {
    }

    public Novedadlectiva(Integer numeronovedad) {
        this.numeronovedad = numeronovedad;
    }

    public Integer getNumeronovedad() {
        return numeronovedad;
    }

    public void setNumeronovedad(Integer numeronovedad) {
        this.numeronovedad = numeronovedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Seguimientoaprendiz> getSeguimientoaprendizCollection() {
        return seguimientoaprendizCollection;
    }

    public void setSeguimientoaprendizCollection(Collection<Seguimientoaprendiz> seguimientoaprendizCollection) {
        this.seguimientoaprendizCollection = seguimientoaprendizCollection;
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
        if (!(object instanceof Novedadlectiva)) {
            return false;
        }
        Novedadlectiva other = (Novedadlectiva) object;
        if ((this.numeronovedad == null && other.numeronovedad != null) || (this.numeronovedad != null && !this.numeronovedad.equals(other.numeronovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Novedadlectiva[ numeronovedad=" + numeronovedad + " ]";
    }
    
}
