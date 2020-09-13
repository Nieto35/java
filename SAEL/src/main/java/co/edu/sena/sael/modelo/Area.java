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
 * @author dasak
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.findByCodigoarea", query = "SELECT a FROM Area a WHERE a.codigoarea = :codigoarea")
    , @NamedQuery(name = "Area.findByNombrearea", query = "SELECT a FROM Area a WHERE a.nombrearea = :nombrearea")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoarea")
    private Integer codigoarea;
    
    @Column(name = "nombrearea", length =50)
    private String nombrearea;
    
    @OneToMany(mappedBy = "codigoarea")
    private Collection<Turno> turnoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoarea")
    
    private Collection<Funcionario> funcionarioCollection;
    @JoinColumn(name = "codigodependencia", referencedColumnName = "codigodependencia")
    @ManyToOne
    
    private Dependencia codigodependencia;

    public Area() {
    }

    public Area(Integer codigoarea) {
        this.codigoarea = codigoarea;
    }

    public Integer getCodigoarea() {
        return codigoarea;
    }

    public void setCodigoarea(Integer codigoarea) {
        this.codigoarea = codigoarea;
    }

    public String getNombrearea() {
        return nombrearea;
    }

    public void setNombrearea(String nombrearea) {
        this.nombrearea = nombrearea;
    }

    @XmlTransient
    public Collection<Turno> getTurnoCollection() {
        return turnoCollection;
    }

    public void setTurnoCollection(Collection<Turno> turnoCollection) {
        this.turnoCollection = turnoCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    public Dependencia getCodigodependencia() {
        return codigodependencia;
    }

    public void setCodigodependencia(Dependencia codigodependencia) {
        this.codigodependencia = codigodependencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoarea != null ? codigoarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.codigoarea == null && other.codigoarea != null) || (this.codigoarea != null && !this.codigoarea.equals(other.codigoarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Area[ codigoarea=" + codigoarea + " ]";
    }
    
}
