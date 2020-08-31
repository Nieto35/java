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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "usodeambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usodeambiente.findAll", query = "SELECT u FROM Usodeambiente u")
    , @NamedQuery(name = "Usodeambiente.findByCodigousoambiente", query = "SELECT u FROM Usodeambiente u WHERE u.codigousoambiente = :codigousoambiente")
    , @NamedQuery(name = "Usodeambiente.findByFechausoambiente", query = "SELECT u FROM Usodeambiente u WHERE u.fechausoambiente = :fechausoambiente")
    , @NamedQuery(name = "Usodeambiente.findByHoraentradausoambiente", query = "SELECT u FROM Usodeambiente u WHERE u.horaentradausoambiente = :horaentradausoambiente")
    , @NamedQuery(name = "Usodeambiente.findByHorasalidausoambiente", query = "SELECT u FROM Usodeambiente u WHERE u.horasalidausoambiente = :horasalidausoambiente")
    , @NamedQuery(name = "Usodeambiente.findByEntregausoambiente", query = "SELECT u FROM Usodeambiente u WHERE u.entregausoambiente = :entregausoambiente")})
public class Usodeambiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigousoambiente")
    private Integer codigousoambiente;
    @Column(name = "fechausoambiente")
    @Temporal(TemporalType.DATE)
    private Date fechausoambiente;
    @Column(name = "horaentradausoambiente")
    @Temporal(TemporalType.TIME)
    private Date horaentradausoambiente;
    @Column(name = "horasalidausoambiente")
    @Temporal(TemporalType.TIME)
    private Date horasalidausoambiente;
    @Column(name = "entregausoambiente",length =50)
    private String entregausoambiente;
    @Lob
    @Column(name = "observacionesusoambiente",length =65535)
    private String observacionesusoambiente;
    @JoinColumn(name = "codigoambiente", referencedColumnName = "codigoambiente")
    @ManyToOne
    private Ambienteaprendizaje codigoambiente;
    @JoinColumn(name = "fichatitulacion", referencedColumnName = "numeroficha")
    @ManyToOne
    private Fichatitulacion fichatitulacion;
    @JoinColumn(name = "idguarda", referencedColumnName = "documentoguarda")
    @ManyToOne
    private Guarda idguarda;
    @JoinColumn(name = "documentopersonal", referencedColumnName = "documentopersonal")
    @ManyToOne
    private Personal documentopersonal;
    @JoinColumn(name = "codigoreserva", referencedColumnName = "codigoreservaambiente")
    @ManyToOne
    private Reservaambiente codigoreserva;

    public Usodeambiente() {
    }

    public Usodeambiente(Integer codigousoambiente) {
        this.codigousoambiente = codigousoambiente;
    }

    public Integer getCodigousoambiente() {
        return codigousoambiente;
    }

    public void setCodigousoambiente(Integer codigousoambiente) {
        this.codigousoambiente = codigousoambiente;
    }

    public Date getFechausoambiente() {
        return fechausoambiente;
    }

    public void setFechausoambiente(Date fechausoambiente) {
        this.fechausoambiente = fechausoambiente;
    }

    public Date getHoraentradausoambiente() {
        return horaentradausoambiente;
    }

    public void setHoraentradausoambiente(Date horaentradausoambiente) {
        this.horaentradausoambiente = horaentradausoambiente;
    }

    public Date getHorasalidausoambiente() {
        return horasalidausoambiente;
    }

    public void setHorasalidausoambiente(Date horasalidausoambiente) {
        this.horasalidausoambiente = horasalidausoambiente;
    }

    public String getEntregausoambiente() {
        return entregausoambiente;
    }

    public void setEntregausoambiente(String entregausoambiente) {
        this.entregausoambiente = entregausoambiente;
    }

    public String getObservacionesusoambiente() {
        return observacionesusoambiente;
    }

    public void setObservacionesusoambiente(String observacionesusoambiente) {
        this.observacionesusoambiente = observacionesusoambiente;
    }

    public Ambienteaprendizaje getCodigoambiente() {
        return codigoambiente;
    }

    public void setCodigoambiente(Ambienteaprendizaje codigoambiente) {
        this.codigoambiente = codigoambiente;
    }

    public Fichatitulacion getFichatitulacion() {
        return fichatitulacion;
    }

    public void setFichatitulacion(Fichatitulacion fichatitulacion) {
        this.fichatitulacion = fichatitulacion;
    }

    public Guarda getIdguarda() {
        return idguarda;
    }

    public void setIdguarda(Guarda idguarda) {
        this.idguarda = idguarda;
    }

    public Personal getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(Personal documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    public Reservaambiente getCodigoreserva() {
        return codigoreserva;
    }

    public void setCodigoreserva(Reservaambiente codigoreserva) {
        this.codigoreserva = codigoreserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigousoambiente != null ? codigousoambiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usodeambiente)) {
            return false;
        }
        Usodeambiente other = (Usodeambiente) object;
        if ((this.codigousoambiente == null && other.codigousoambiente != null) || (this.codigousoambiente != null && !this.codigousoambiente.equals(other.codigousoambiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Usodeambiente[ codigousoambiente=" + codigousoambiente + " ]";
    }
    
}
