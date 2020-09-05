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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "sede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s")
    , @NamedQuery(name = "Sede.findByNumerosede", query = "SELECT s FROM Sede s WHERE s.numerosede = :numerosede")
    , @NamedQuery(name = "Sede.findByNombresede", query = "SELECT s FROM Sede s WHERE s.nombresede = :nombresede")
    , @NamedQuery(name = "Sede.findByDireccionsede", query = "SELECT s FROM Sede s WHERE s.direccionsede = :direccionsede")
    , @NamedQuery(name = "Sede.findByEstadosede", query = "SELECT s FROM Sede s WHERE s.estadosede = :estadosede")})
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numerosede")
    private Integer numerosede;
    @Column(name = "nombresede", length = 50)//@Size(max = 50)
    private String nombresede;
    @Column(name = "direccionsede", length = 50)//@Size(max = 50)
    private String direccionsede;
    @Column(name = "estadosede", length = 50)//@Size(max = 50)
    private String estadosede;
    @OneToMany(mappedBy = "numerosede")
    private Collection<Ambienteaprendizaje> ambienteaprendizajeCollection;
    @OneToMany(mappedBy = "numerosede")
    private Collection<Fichatitulacion> fichatitulacionCollection;
    @JoinColumn(name = "documentofuncionario", referencedColumnName = "documentofuncionario")
    @ManyToOne
    private Funcionario documentofuncionario;

    public Sede() {
    }

    public Sede(Integer numerosede) {
        this.numerosede = numerosede;
    }

    public Integer getNumerosede() {
        return numerosede;
    }

    public void setNumerosede(Integer numerosede) {
        this.numerosede = numerosede;
    }

    public String getNombresede() {
        return nombresede;
    }

    public void setNombresede(String nombresede) {
        this.nombresede = nombresede;
    }

    public String getDireccionsede() {
        return direccionsede;
    }

    public void setDireccionsede(String direccionsede) {
        this.direccionsede = direccionsede;
    }

    public String getEstadosede() {
        return estadosede;
    }

    public void setEstadosede(String estadosede) {
        this.estadosede = estadosede;
    }

    @XmlTransient
    public Collection<Ambienteaprendizaje> getAmbienteaprendizajeCollection() {
        return ambienteaprendizajeCollection;
    }

    public void setAmbienteaprendizajeCollection(Collection<Ambienteaprendizaje> ambienteaprendizajeCollection) {
        this.ambienteaprendizajeCollection = ambienteaprendizajeCollection;
    }

    @XmlTransient
    public Collection<Fichatitulacion> getFichatitulacionCollection() {
        return fichatitulacionCollection;
    }

    public void setFichatitulacionCollection(Collection<Fichatitulacion> fichatitulacionCollection) {
        this.fichatitulacionCollection = fichatitulacionCollection;
    }

    public Funcionario getDocumentofuncionario() {
        return documentofuncionario;
    }

    public void setDocumentofuncionario(Funcionario documentofuncionario) {
        this.documentofuncionario = documentofuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerosede != null ? numerosede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.numerosede == null && other.numerosede != null) || (this.numerosede != null && !this.numerosede.equals(other.numerosede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Sede[ numerosede=" + numerosede + " ]";
    }
    
}
