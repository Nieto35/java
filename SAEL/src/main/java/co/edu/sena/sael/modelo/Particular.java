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
 * @author Felipe
 */
@Entity
@Table(name = "particular")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Particular.findAll", query = "SELECT p FROM Particular p")
    , @NamedQuery(name = "Particular.findByDocumentocliente", query = "SELECT p FROM Particular p WHERE p.documentocliente = :documentocliente")})
public class Particular implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "documentocliente",nullable = false) //@NotNull
    private Long documentocliente;
    @OneToMany(mappedBy = "documentocliente")
    private Collection<Turno> turnoCollection;
    @JoinColumn(name = "documentocliente", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;

    public Particular() {
    }

    public Particular(Long documentocliente) {
        this.documentocliente = documentocliente;
    }

    public Long getDocumentocliente() {
        return documentocliente;
    }

    public void setDocumentocliente(Long documentocliente) {
        this.documentocliente = documentocliente;
    }

    @XmlTransient
    public Collection<Turno> getTurnoCollection() {
        return turnoCollection;
    }

    public void setTurnoCollection(Collection<Turno> turnoCollection) {
        this.turnoCollection = turnoCollection;
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
        hash += (documentocliente != null ? documentocliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Particular)) {
            return false;
        }
        Particular other = (Particular) object;
        if ((this.documentocliente == null && other.documentocliente != null) || (this.documentocliente != null && !this.documentocliente.equals(other.documentocliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Particular[ documentocliente=" + documentocliente + " ]";
    }
    
}
