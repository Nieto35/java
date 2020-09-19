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
import javax.persistence.Lob;
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
@Table(name = "seguimientoaprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimientoaprendiz.findAll", query = "SELECT s FROM Seguimientoaprendiz s")
    , @NamedQuery(name = "Seguimientoaprendiz.findByDocumentoaprendiz", query = "SELECT s FROM Seguimientoaprendiz s WHERE s.seguimientoaprendizPK.documentoaprendiz = :documentoaprendiz")
    , @NamedQuery(name = "Seguimientoaprendiz.findByNumeroseguimiento", query = "SELECT s FROM Seguimientoaprendiz s WHERE s.seguimientoaprendizPK.numeroseguimiento = :numeroseguimiento")})
public class Seguimientoaprendiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeguimientoaprendizPK seguimientoaprendizPK;
    @Lob
    @Column(name = "conceptoespecifico", length = 65535)
    private String conceptoespecifico;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentoaprendiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aprendiz aprendiz;
    @JoinColumn(name = "numeronovedad", referencedColumnName = "numeronovedad")
    @ManyToOne
    private Novedadlectiva numeronovedad;
    @JoinColumn(name = "numeroseguimiento", referencedColumnName = "codigoseguimiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Seguimiento seguimiento;

    public Seguimientoaprendiz() {
    }

    public Seguimientoaprendiz(SeguimientoaprendizPK seguimientoaprendizPK) {
        this.seguimientoaprendizPK = seguimientoaprendizPK;
    }

    public Seguimientoaprendiz(long documentoaprendiz, int numeroseguimiento) {
        this.seguimientoaprendizPK = new SeguimientoaprendizPK(documentoaprendiz, numeroseguimiento);
    }

    public SeguimientoaprendizPK getSeguimientoaprendizPK() {
        return seguimientoaprendizPK;
    }

    public void setSeguimientoaprendizPK(SeguimientoaprendizPK seguimientoaprendizPK) {
        this.seguimientoaprendizPK = seguimientoaprendizPK;
    }

    public String getConceptoespecifico() {
        return conceptoespecifico;
    }

    public void setConceptoespecifico(String conceptoespecifico) {
        this.conceptoespecifico = conceptoespecifico;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    public Novedadlectiva getNumeronovedad() {
        return numeronovedad;
    }

    public void setNumeronovedad(Novedadlectiva numeronovedad) {
        this.numeronovedad = numeronovedad;
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
        hash += (seguimientoaprendizPK != null ? seguimientoaprendizPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimientoaprendiz)) {
            return false;
        }
        Seguimientoaprendiz other = (Seguimientoaprendiz) object;
        if ((this.seguimientoaprendizPK == null && other.seguimientoaprendizPK != null) || (this.seguimientoaprendizPK != null && !this.seguimientoaprendizPK.equals(other.seguimientoaprendizPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Seguimientoaprendiz[ seguimientoaprendizPK=" + seguimientoaprendizPK + " ]";
    }
    
}
