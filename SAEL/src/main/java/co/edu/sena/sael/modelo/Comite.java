/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "comite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comite.findAll", query = "SELECT c FROM Comite c")
    , @NamedQuery(name = "Comite.findByDocumentopersonal", query = "SELECT c FROM Comite c WHERE c.comitePK.documentopersonal = :documentopersonal")
    , @NamedQuery(name = "Comite.findByNumeroseguimiento", query = "SELECT c FROM Comite c WHERE c.comitePK.numeroseguimiento = :numeroseguimiento")
    , @NamedQuery(name = "Comite.findByCargocomite", query = "SELECT c FROM Comite c WHERE c.cargocomite = :cargocomite")})
public class Comite implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComitePK comitePK;
    @Size(max = 50)
    @Column(name = "cargocomite")
    private String cargocomite;
    @JoinColumn(name = "documentopersonal", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personal personal;
    @JoinColumn(name = "numeroseguimiento", referencedColumnName = "codigoseguimiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Seguimiento seguimiento;

    public Comite() {
    }

    public Comite(ComitePK comitePK) {
        this.comitePK = comitePK;
    }

    public Comite(long documentopersonal, int numeroseguimiento) {
        this.comitePK = new ComitePK(documentopersonal, numeroseguimiento);
    }

    public ComitePK getComitePK() {
        return comitePK;
    }

    public void setComitePK(ComitePK comitePK) {
        this.comitePK = comitePK;
    }

    public String getCargocomite() {
        return cargocomite;
    }

    public void setCargocomite(String cargocomite) {
        this.cargocomite = cargocomite;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comitePK != null ? comitePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comite)) {
            return false;
        }
        Comite other = (Comite) object;
        if ((this.comitePK == null && other.comitePK != null) || (this.comitePK != null && !this.comitePK.equals(other.comitePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Comite[ comitePK=" + comitePK + " ]";
    }
    
}
