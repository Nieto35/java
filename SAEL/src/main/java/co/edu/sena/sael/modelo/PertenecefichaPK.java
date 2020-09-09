<<<<<<< HEAD
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Felipe
 */
@Embeddable
public class PertenecefichaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "documentoaprendiz",nullable = false)
    private long documentoaprendiz;
    @Basic(optional = false)
    @Column(name = "numeroficha",nullable = false)
    private int numeroficha;

    public PertenecefichaPK() {
    }

    public PertenecefichaPK(long documentoaprendiz, int numeroficha) {
        this.documentoaprendiz = documentoaprendiz;
        this.numeroficha = numeroficha;
    }

    public long getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(long documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    public int getNumeroficha() {
        return numeroficha;
    }

    public void setNumeroficha(int numeroficha) {
        this.numeroficha = numeroficha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) documentoaprendiz;
        hash += (int) numeroficha;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PertenecefichaPK)) {
            return false;
        }
        PertenecefichaPK other = (PertenecefichaPK) object;
        if (this.documentoaprendiz != other.documentoaprendiz) {
            return false;
        }
        if (this.numeroficha != other.numeroficha) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.PertenecefichaPK[ documentoaprendiz=" + documentoaprendiz + ", numeroficha=" + numeroficha + " ]";
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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dasak
 */
@Embeddable
public class PertenecefichaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "documentoaprendiz", nullable = false)
    private long documentoaprendiz;
    @Basic(optional = false)
    @Column(name = "numeroficha", nullable = false)
    private int numeroficha;

    public PertenecefichaPK() {
    }

    public PertenecefichaPK(long documentoaprendiz, int numeroficha) {
        this.documentoaprendiz = documentoaprendiz;
        this.numeroficha = numeroficha;
    }

    public long getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(long documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    public int getNumeroficha() {
        return numeroficha;
    }

    public void setNumeroficha(int numeroficha) {
        this.numeroficha = numeroficha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) documentoaprendiz;
        hash += (int) numeroficha;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PertenecefichaPK)) {
            return false;
        }
        PertenecefichaPK other = (PertenecefichaPK) object;
        if (this.documentoaprendiz != other.documentoaprendiz) {
            return false;
        }
        if (this.numeroficha != other.numeroficha) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.PertenecefichaPK[ documentoaprendiz=" + documentoaprendiz + ", numeroficha=" + numeroficha + " ]";
    }
    
}
>>>>>>> v1
