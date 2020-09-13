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
@Table(name = "guarda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guarda.findAll", query = "SELECT g FROM Guarda g")
    , @NamedQuery(name = "Guarda.findByDocumentoguarda", query = "SELECT g FROM Guarda g WHERE g.documentoguarda = :documentoguarda")})
public class Guarda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "documentoguarda", nullable = false)
    private Long documentoguarda;
    
    @OneToMany(mappedBy = "idguarda")
    private Collection<Usodeambiente> usodeambienteCollection;
    @JoinColumn(name = "documentoguarda", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;

    public Guarda() {
    }

    public Guarda(Long documentoguarda) {
        this.documentoguarda = documentoguarda;
    }

    public Long getDocumentoguarda() {
        return documentoguarda;
    }

    public void setDocumentoguarda(Long documentoguarda) {
        this.documentoguarda = documentoguarda;
    }

    @XmlTransient
    public Collection<Usodeambiente> getUsodeambienteCollection() {
        return usodeambienteCollection;
    }

    public void setUsodeambienteCollection(Collection<Usodeambiente> usodeambienteCollection) {
        this.usodeambienteCollection = usodeambienteCollection;
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
        hash += (documentoguarda != null ? documentoguarda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guarda)) {
            return false;
        }
        Guarda other = (Guarda) object;
        if ((this.documentoguarda == null && other.documentoguarda != null) || (this.documentoguarda != null && !this.documentoguarda.equals(other.documentoguarda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Guarda[ documentoguarda=" + documentoguarda + " ]";
    }
    
}
