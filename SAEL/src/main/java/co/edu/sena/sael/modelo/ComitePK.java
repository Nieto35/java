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
 * @author Felipe
 */
@Embeddable
public class ComitePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "documentopersonal", nullable = false)//@NotNull
    private long documentopersonal;
    @Basic(optional = false)
    @Column(name = "numeroseguimiento", nullable = false)//@NotNull
    private int numeroseguimiento;

    public ComitePK() {
    }

    public ComitePK(long documentopersonal, int numeroseguimiento) {
        this.documentopersonal = documentopersonal;
        this.numeroseguimiento = numeroseguimiento;
    }

    public long getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(long documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    public int getNumeroseguimiento() {
        return numeroseguimiento;
    }

    public void setNumeroseguimiento(int numeroseguimiento) {
        this.numeroseguimiento = numeroseguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) documentopersonal;
        hash += (int) numeroseguimiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComitePK)) {
            return false;
        }
        ComitePK other = (ComitePK) object;
        if (this.documentopersonal != other.documentopersonal) {
            return false;
        }
        if (this.numeroseguimiento != other.numeroseguimiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.ComitePK[ documentopersonal=" + documentopersonal + ", numeroseguimiento=" + numeroseguimiento + " ]";
    }
    
}
