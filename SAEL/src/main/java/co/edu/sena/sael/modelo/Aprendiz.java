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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "aprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aprendiz.findAll", query = "SELECT a FROM Aprendiz a")
    , @NamedQuery(name = "Aprendiz.findByDocumentoaprendiz", query = "SELECT a FROM Aprendiz a WHERE a.documentoaprendiz = :documentoaprendiz")
    , @NamedQuery(name = "Aprendiz.findByEstadoaprendiz", query = "SELECT a FROM Aprendiz a WHERE a.estadoaprendiz = :estadoaprendiz")})
public class Aprendiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoaprendiz")
    private Long documentoaprendiz;
    @Size(max = 50)
    @Column(name = "estadoaprendiz")
    private String estadoaprendiz;
    @OneToMany(mappedBy = "documentoaprendiz")
    private Collection<Inasistencia> inasistenciaCollection;
    @OneToMany(mappedBy = "documentoaprendiz")
    private Collection<Permiso> permisoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aprendiz")
    private Collection<Seguimientoaprendiz> seguimientoaprendizCollection;
    @OneToMany(mappedBy = "documentoaprendiz")
    private Collection<Eproductiva> eproductivaCollection;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aprendiz")
    private Collection<Perteneceficha> pertenecefichaCollection;

    public Aprendiz() {
    }

    public Aprendiz(Long documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    public Long getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(Long documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    public String getEstadoaprendiz() {
        return estadoaprendiz;
    }

    public void setEstadoaprendiz(String estadoaprendiz) {
        this.estadoaprendiz = estadoaprendiz;
    }

    @XmlTransient
    public Collection<Inasistencia> getInasistenciaCollection() {
        return inasistenciaCollection;
    }

    public void setInasistenciaCollection(Collection<Inasistencia> inasistenciaCollection) {
        this.inasistenciaCollection = inasistenciaCollection;
    }

    @XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    @XmlTransient
    public Collection<Seguimientoaprendiz> getSeguimientoaprendizCollection() {
        return seguimientoaprendizCollection;
    }

    public void setSeguimientoaprendizCollection(Collection<Seguimientoaprendiz> seguimientoaprendizCollection) {
        this.seguimientoaprendizCollection = seguimientoaprendizCollection;
    }

    @XmlTransient
    public Collection<Eproductiva> getEproductivaCollection() {
        return eproductivaCollection;
    }

    public void setEproductivaCollection(Collection<Eproductiva> eproductivaCollection) {
        this.eproductivaCollection = eproductivaCollection;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @XmlTransient
    public Collection<Perteneceficha> getPertenecefichaCollection() {
        return pertenecefichaCollection;
    }

    public void setPertenecefichaCollection(Collection<Perteneceficha> pertenecefichaCollection) {
        this.pertenecefichaCollection = pertenecefichaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoaprendiz != null ? documentoaprendiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aprendiz)) {
            return false;
        }
        Aprendiz other = (Aprendiz) object;
        if ((this.documentoaprendiz == null && other.documentoaprendiz != null) || (this.documentoaprendiz != null && !this.documentoaprendiz.equals(other.documentoaprendiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Aprendiz[ documentoaprendiz=" + documentoaprendiz + " ]";
    }
    
}
