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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByDocumentofuncionario", query = "SELECT f FROM Funcionario f WHERE f.documentofuncionario = :documentofuncionario")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "documentofuncionario",nullable = false)
    private Long documentofuncionario;
    @JoinColumn(name = "codigoarea", referencedColumnName = "codigoarea")
    @ManyToOne(optional = false)
    private Area codigoarea;
    @JoinColumn(name = "documentofuncionario", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;
    @OneToMany(mappedBy = "documentofuncionario")
    private Collection<Eproductiva> eproductivaCollection;
    @OneToMany(mappedBy = "documentofuncionario")
    private Collection<Sede> sedeCollection;

    public Funcionario() {
    }

    public Funcionario(Long documentofuncionario) {
        this.documentofuncionario = documentofuncionario;
    }

    public Long getDocumentofuncionario() {
        return documentofuncionario;
    }

    public void setDocumentofuncionario(Long documentofuncionario) {
        this.documentofuncionario = documentofuncionario;
    }

    public Area getCodigoarea() {
        return codigoarea;
    }

    public void setCodigoarea(Area codigoarea) {
        this.codigoarea = codigoarea;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @XmlTransient
    public Collection<Eproductiva> getEproductivaCollection() {
        return eproductivaCollection;
    }

    public void setEproductivaCollection(Collection<Eproductiva> eproductivaCollection) {
        this.eproductivaCollection = eproductivaCollection;
    }

    @XmlTransient
    public Collection<Sede> getSedeCollection() {
        return sedeCollection;
    }

    public void setSedeCollection(Collection<Sede> sedeCollection) {
        this.sedeCollection = sedeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentofuncionario != null ? documentofuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.documentofuncionario == null && other.documentofuncionario != null) || (this.documentofuncionario != null && !this.documentofuncionario.equals(other.documentofuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Funcionario[ documentofuncionario=" + documentofuncionario + " ]";
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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByDocumentofuncionario", query = "SELECT f FROM Funcionario f WHERE f.documentofuncionario = :documentofuncionario")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "documentofuncionario", nullable = false)
    private Long documentofuncionario;
    
    @JoinColumn(name = "codigoarea", referencedColumnName = "codigoarea")
    @ManyToOne(optional = false)
    private Area codigoarea;
    
    @JoinColumn(name = "documentofuncionario", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;
    @OneToMany(mappedBy = "documentofuncionario")
    private Collection<Eproductiva> eproductivaCollection;
    @OneToMany(mappedBy = "documentofuncionario")
    private Collection<Sede> sedeCollection;

    public Funcionario() {
    }

    public Funcionario(Long documentofuncionario) {
        this.documentofuncionario = documentofuncionario;
    }

    public Long getDocumentofuncionario() {
        return documentofuncionario;
    }

    public void setDocumentofuncionario(Long documentofuncionario) {
        this.documentofuncionario = documentofuncionario;
    }

    public Area getCodigoarea() {
        return codigoarea;
    }

    public void setCodigoarea(Area codigoarea) {
        this.codigoarea = codigoarea;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @XmlTransient
    public Collection<Eproductiva> getEproductivaCollection() {
        return eproductivaCollection;
    }

    public void setEproductivaCollection(Collection<Eproductiva> eproductivaCollection) {
        this.eproductivaCollection = eproductivaCollection;
    }

    @XmlTransient
    public Collection<Sede> getSedeCollection() {
        return sedeCollection;
    }

    public void setSedeCollection(Collection<Sede> sedeCollection) {
        this.sedeCollection = sedeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentofuncionario != null ? documentofuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.documentofuncionario == null && other.documentofuncionario != null) || (this.documentofuncionario != null && !this.documentofuncionario.equals(other.documentofuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Funcionario[ documentofuncionario=" + documentofuncionario + " ]";
    }
    
}
>>>>>>> v1
