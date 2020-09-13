/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formacion.findAll", query = "SELECT f FROM Formacion f")
    , @NamedQuery(name = "Formacion.findByCodigoformacion", query = "SELECT f FROM Formacion f WHERE f.codigoformacion = :codigoformacion")
    , @NamedQuery(name = "Formacion.findByNombreformacion", query = "SELECT f FROM Formacion f WHERE f.nombreformacion = :nombreformacion")
    , @NamedQuery(name = "Formacion.findByInstitucionformacion", query = "SELECT f FROM Formacion f WHERE f.institucionformacion = :institucionformacion")
    , @NamedQuery(name = "Formacion.findByAnioformacion", query = "SELECT f FROM Formacion f WHERE f.anioformacion = :anioformacion")})
public class Formacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoformacion")
    private Integer codigoformacion;

    @Column(name = "nombreformacion", length = 100)
    private String nombreformacion;

    @Column(name = "institucionformacion", length = 100)
    private String institucionformacion;
    @Column(name = "anioformacion")
    private Integer anioformacion;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne
    private Instructor documentoinstructor;

    public Formacion() {
    }

    public Formacion(Integer codigoformacion) {
        this.codigoformacion = codigoformacion;
    }

    public Integer getCodigoformacion() {
        return codigoformacion;
    }

    public void setCodigoformacion(Integer codigoformacion) {
        this.codigoformacion = codigoformacion;
    }

    public String getNombreformacion() {
        return nombreformacion;
    }

    public void setNombreformacion(String nombreformacion) {
        this.nombreformacion = nombreformacion;
    }

    public String getInstitucionformacion() {
        return institucionformacion;
    }

    public void setInstitucionformacion(String institucionformacion) {
        this.institucionformacion = institucionformacion;
    }

    public Integer getAnioformacion() {
        return anioformacion;
    }

    public void setAnioformacion(Integer anioformacion) {
        this.anioformacion = anioformacion;
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
        hash += (codigoformacion != null ? codigoformacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formacion)) {
            return false;
        }
        Formacion other = (Formacion) object;
        if ((this.codigoformacion == null && other.codigoformacion != null) || (this.codigoformacion != null && !this.codigoformacion.equals(other.codigoformacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Formacion[ codigoformacion=" + codigoformacion + " ]";
    }
    
}
