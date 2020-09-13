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
@Table(name = "hablaidioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hablaidioma.findAll", query = "SELECT h FROM Hablaidioma h")
    , @NamedQuery(name = "Hablaidioma.findByDocumentoinstructor", query = "SELECT h FROM Hablaidioma h WHERE h.hablaidiomaPK.documentoinstructor = :documentoinstructor")
    , @NamedQuery(name = "Hablaidioma.findByCodigoidioma", query = "SELECT h FROM Hablaidioma h WHERE h.hablaidiomaPK.codigoidioma = :codigoidioma")
    , @NamedQuery(name = "Hablaidioma.findByNivelhabla", query = "SELECT h FROM Hablaidioma h WHERE h.nivelhabla = :nivelhabla")
    , @NamedQuery(name = "Hablaidioma.findByNivelescribe", query = "SELECT h FROM Hablaidioma h WHERE h.nivelescribe = :nivelescribe")
    , @NamedQuery(name = "Hablaidioma.findByNivellee", query = "SELECT h FROM Hablaidioma h WHERE h.nivellee = :nivellee")})
public class Hablaidioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HablaidiomaPK hablaidiomaPK;
    @Column(name = "nivelhabla",length = 50)
    private String nivelhabla;

    @Column(name = "nivelescribe", length = 50)
    private String nivelescribe;

    @Column(name = "nivellee", length = 50)
    private String nivellee;
    
    @JoinColumn(name = "codigoidioma", referencedColumnName = "codigoidioma", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Idioma idioma;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Instructor instructor;

    public Hablaidioma() {
    }

    public Hablaidioma(HablaidiomaPK hablaidiomaPK) {
        this.hablaidiomaPK = hablaidiomaPK;
    }

    public Hablaidioma(long documentoinstructor, int codigoidioma) {
        this.hablaidiomaPK = new HablaidiomaPK(documentoinstructor, codigoidioma);
    }

    public HablaidiomaPK getHablaidiomaPK() {
        return hablaidiomaPK;
    }

    public void setHablaidiomaPK(HablaidiomaPK hablaidiomaPK) {
        this.hablaidiomaPK = hablaidiomaPK;
    }

    public String getNivelhabla() {
        return nivelhabla;
    }

    public void setNivelhabla(String nivelhabla) {
        this.nivelhabla = nivelhabla;
    }

    public String getNivelescribe() {
        return nivelescribe;
    }

    public void setNivelescribe(String nivelescribe) {
        this.nivelescribe = nivelescribe;
    }

    public String getNivellee() {
        return nivellee;
    }

    public void setNivellee(String nivellee) {
        this.nivellee = nivellee;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hablaidiomaPK != null ? hablaidiomaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hablaidioma)) {
            return false;
        }
        Hablaidioma other = (Hablaidioma) object;
        if ((this.hablaidiomaPK == null && other.hablaidiomaPK != null) || (this.hablaidiomaPK != null && !this.hablaidiomaPK.equals(other.hablaidiomaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Hablaidioma[ hablaidiomaPK=" + hablaidiomaPK + " ]";
    }
    
}
