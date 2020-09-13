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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "coordinador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordinador.findAll", query = "SELECT c FROM Coordinador c")
    , @NamedQuery(name = "Coordinador.findByDocumentocoordinador", query = "SELECT c FROM Coordinador c WHERE c.documentocoordinador = :documentocoordinador")
    , @NamedQuery(name = "Coordinador.findByTipo", query = "SELECT c FROM Coordinador c WHERE c.tipo = :tipo")})
public class Coordinador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "documentocoordinador", nullable = false)
    private Long documentocoordinador;

    @Column(name = "tipo", length = 50)
    private String tipo;
    
    @OneToMany(mappedBy = "documentocoordinador")
    private Collection<Permiso> permisoCollection;
    @OneToMany(mappedBy = "documentocoordinador")
    private Collection<Contrato> contratoCollection;
    @JoinColumn(name = "documentocoordinador", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;

    public Coordinador() {
    }

    public Coordinador(Long documentocoordinador) {
        this.documentocoordinador = documentocoordinador;
    }

    public Long getDocumentocoordinador() {
        return documentocoordinador;
    }

    public void setDocumentocoordinador(Long documentocoordinador) {
        this.documentocoordinador = documentocoordinador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    @XmlTransient
    public Collection<Contrato> getContratoCollection() {
        return contratoCollection;
    }

    public void setContratoCollection(Collection<Contrato> contratoCollection) {
        this.contratoCollection = contratoCollection;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentocoordinador != null ? documentocoordinador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordinador)) {
            return false;
        }
        Coordinador other = (Coordinador) object;
        if ((this.documentocoordinador == null && other.documentocoordinador != null) || (this.documentocoordinador != null && !this.documentocoordinador.equals(other.documentocoordinador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Coordinador[ documentocoordinador=" + documentocoordinador + " ]";
    }
    
}
