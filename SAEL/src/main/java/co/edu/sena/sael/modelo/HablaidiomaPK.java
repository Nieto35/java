/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dasak
 */
@Embeddable
public class HablaidiomaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "documentoinstructor", nullable = false)//@NotNull
    private long documentoinstructor;
    
    @Basic(optional = false)
    @Column(name = "codigoidioma", nullable = false)//@NotNull
    private int codigoidioma;

    public HablaidiomaPK() {
    }

    public HablaidiomaPK(long documentoinstructor, int codigoidioma) {
        this.documentoinstructor = documentoinstructor;
        this.codigoidioma = codigoidioma;
    }

    public long getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(long documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    public int getCodigoidioma() {
        return codigoidioma;
    }

    public void setCodigoidioma(int codigoidioma) {
        this.codigoidioma = codigoidioma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) documentoinstructor;
        hash += (int) codigoidioma;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HablaidiomaPK)) {
            return false;
        }
        HablaidiomaPK other = (HablaidiomaPK) object;
        if (this.documentoinstructor != other.documentoinstructor) {
            return false;
        }
        if (this.codigoidioma != other.codigoidioma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.HablaidiomaPK[ documentoinstructor=" + documentoinstructor + ", codigoidioma=" + codigoidioma + " ]";
    }
    
}
