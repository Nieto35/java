/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")
    , @NamedQuery(name = "Contrato.findByNumerocontrato", query = "SELECT c FROM Contrato c WHERE c.numerocontrato = :numerocontrato")
    , @NamedQuery(name = "Contrato.findByFechainiciocontrato", query = "SELECT c FROM Contrato c WHERE c.fechainiciocontrato = :fechainiciocontrato")
    , @NamedQuery(name = "Contrato.findByFechafincontrato", query = "SELECT c FROM Contrato c WHERE c.fechafincontrato = :fechafincontrato")
    , @NamedQuery(name = "Contrato.findByEstadocontrato", query = "SELECT c FROM Contrato c WHERE c.estadocontrato = :estadocontrato")
    , @NamedQuery(name = "Contrato.findByValortotalcontrato", query = "SELECT c FROM Contrato c WHERE c.valortotalcontrato = :valortotalcontrato")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numerocontrato", nullable = false)//@NotNull
    private Integer numerocontrato;
    @Column(name = "fechainiciocontrato")
    @Temporal(TemporalType.DATE)
    private Date fechainiciocontrato;
    @Column(name = "fechafincontrato")
    @Temporal(TemporalType.DATE)
    private Date fechafincontrato;
    @Lob
    @Column(name = "objetocontrato", length = 65535)//@Size(
    private String objetocontrato;
    @Column(name = "estadocontrato", length = 50)//@Size(
    private String estadocontrato;
    @Column(name = "valortotalcontrato")
    private Integer valortotalcontrato;
    @JoinColumn(name = "documentocoordinador", referencedColumnName = "documentocoordinador")
    @ManyToOne
    private Coordinador documentocoordinador;
    @JoinColumn(name = "documentopersonal", referencedColumnName = "documentopersonal")
    @ManyToOne
    private Personal documentopersonal;

    public Contrato() {
    }

    public Contrato(Integer numerocontrato) {
        this.numerocontrato = numerocontrato;
    }

    public Integer getNumerocontrato() {
        return numerocontrato;
    }

    public void setNumerocontrato(Integer numerocontrato) {
        this.numerocontrato = numerocontrato;
    }

    public Date getFechainiciocontrato() {
        return fechainiciocontrato;
    }

    public void setFechainiciocontrato(Date fechainiciocontrato) {
        this.fechainiciocontrato = fechainiciocontrato;
    }

    public Date getFechafincontrato() {
        return fechafincontrato;
    }

    public void setFechafincontrato(Date fechafincontrato) {
        this.fechafincontrato = fechafincontrato;
    }

    public String getObjetocontrato() {
        return objetocontrato;
    }

    public void setObjetocontrato(String objetocontrato) {
        this.objetocontrato = objetocontrato;
    }

    public String getEstadocontrato() {
        return estadocontrato;
    }

    public void setEstadocontrato(String estadocontrato) {
        this.estadocontrato = estadocontrato;
    }

    public Integer getValortotalcontrato() {
        return valortotalcontrato;
    }

    public void setValortotalcontrato(Integer valortotalcontrato) {
        this.valortotalcontrato = valortotalcontrato;
    }

    public Coordinador getDocumentocoordinador() {
        return documentocoordinador;
    }

    public void setDocumentocoordinador(Coordinador documentocoordinador) {
        this.documentocoordinador = documentocoordinador;
    }

    public Personal getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(Personal documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerocontrato != null ? numerocontrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.numerocontrato == null && other.numerocontrato != null) || (this.numerocontrato != null && !this.numerocontrato.equals(other.numerocontrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Contrato[ numerocontrato=" + numerocontrato + " ]";
    }
    
}
