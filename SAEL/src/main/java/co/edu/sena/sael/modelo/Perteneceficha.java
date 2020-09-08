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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "perteneceficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perteneceficha.findAll", query = "SELECT p FROM Perteneceficha p")
    , @NamedQuery(name = "Perteneceficha.findByDocumentoaprendiz", query = "SELECT p FROM Perteneceficha p WHERE p.pertenecefichaPK.documentoaprendiz = :documentoaprendiz")
    , @NamedQuery(name = "Perteneceficha.findByNumeroficha", query = "SELECT p FROM Perteneceficha p WHERE p.pertenecefichaPK.numeroficha = :numeroficha")
    , @NamedQuery(name = "Perteneceficha.findByEstado", query = "SELECT p FROM Perteneceficha p WHERE p.estado = :estado")})
public class Perteneceficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PertenecefichaPK pertenecefichaPK;
    @Column(name = "estado", length = 50)
    private String estado;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentoaprendiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aprendiz aprendiz;
    @JoinColumn(name = "numeroficha", referencedColumnName = "numeroficha", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fichatitulacion fichatitulacion;

    public Perteneceficha() {
    }

    public Perteneceficha(PertenecefichaPK pertenecefichaPK) {
        this.pertenecefichaPK = pertenecefichaPK;
    }

    public Perteneceficha(long documentoaprendiz, int numeroficha) {
        this.pertenecefichaPK = new PertenecefichaPK(documentoaprendiz, numeroficha);
    }

    public PertenecefichaPK getPertenecefichaPK() {
        return pertenecefichaPK;
    }

    public void setPertenecefichaPK(PertenecefichaPK pertenecefichaPK) {
        this.pertenecefichaPK = pertenecefichaPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    public Fichatitulacion getFichatitulacion() {
        return fichatitulacion;
    }

    public void setFichatitulacion(Fichatitulacion fichatitulacion) {
        this.fichatitulacion = fichatitulacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pertenecefichaPK != null ? pertenecefichaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perteneceficha)) {
            return false;
        }
        Perteneceficha other = (Perteneceficha) object;
        if ((this.pertenecefichaPK == null && other.pertenecefichaPK != null) || (this.pertenecefichaPK != null && !this.pertenecefichaPK.equals(other.pertenecefichaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Perteneceficha[ pertenecefichaPK=" + pertenecefichaPK + " ]";
    }
    
}
