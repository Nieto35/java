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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t")
    , @NamedQuery(name = "Turno.findByCodigoturno", query = "SELECT t FROM Turno t WHERE t.codigoturno = :codigoturno")
    , @NamedQuery(name = "Turno.findByNumeroturno", query = "SELECT t FROM Turno t WHERE t.numeroturno = :numeroturno")
    , @NamedQuery(name = "Turno.findByFechaturno", query = "SELECT t FROM Turno t WHERE t.fechaturno = :fechaturno")
    , @NamedQuery(name = "Turno.findByHoraingresoturno", query = "SELECT t FROM Turno t WHERE t.horaingresoturno = :horaingresoturno")
    , @NamedQuery(name = "Turno.findByHorasalidaturno", query = "SELECT t FROM Turno t WHERE t.horasalidaturno = :horasalidaturno")
    , @NamedQuery(name = "Turno.findByEstadoturno", query = "SELECT t FROM Turno t WHERE t.estadoturno = :estadoturno")})
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoturno")
    private Integer codigoturno;
    @Column(name = "numeroturno")
    private Integer numeroturno;
    @Column(name = "fechaturno")
    @Temporal(TemporalType.DATE)
    private Date fechaturno;
    @Column(name = "horaingresoturno")
    @Temporal(TemporalType.TIME)
    private Date horaingresoturno;
    @Column(name = "horasalidaturno")
    @Temporal(TemporalType.TIME)
    private Date horasalidaturno;
    @Lob
    @Column(name = "motivoturno", length = 65535)
    private String motivoturno;
    @Column(name = "estadoturno", length = 50)
    private String estadoturno;
    @Lob
    @Column(name = "observacionesturno", length = 65535)
    private String observacionesturno;
    @JoinColumn(name = "codigoarea", referencedColumnName = "codigoarea")
    @ManyToOne
    private Area codigoarea;
    @JoinColumn(name = "documentocliente", referencedColumnName = "documentocliente")
    @ManyToOne
    private Particular documentocliente;

    public Turno() {
    }

    public Turno(Integer codigoturno) {
        this.codigoturno = codigoturno;
    }

    public Integer getCodigoturno() {
        return codigoturno;
    }

    public void setCodigoturno(Integer codigoturno) {
        this.codigoturno = codigoturno;
    }

    public Integer getNumeroturno() {
        return numeroturno;
    }

    public void setNumeroturno(Integer numeroturno) {
        this.numeroturno = numeroturno;
    }

    public Date getFechaturno() {
        return fechaturno;
    }

    public void setFechaturno(Date fechaturno) {
        this.fechaturno = fechaturno;
    }

    public Date getHoraingresoturno() {
        return horaingresoturno;
    }

    public void setHoraingresoturno(Date horaingresoturno) {
        this.horaingresoturno = horaingresoturno;
    }

    public Date getHorasalidaturno() {
        return horasalidaturno;
    }

    public void setHorasalidaturno(Date horasalidaturno) {
        this.horasalidaturno = horasalidaturno;
    }

    public String getMotivoturno() {
        return motivoturno;
    }

    public void setMotivoturno(String motivoturno) {
        this.motivoturno = motivoturno;
    }

    public String getEstadoturno() {
        return estadoturno;
    }

    public void setEstadoturno(String estadoturno) {
        this.estadoturno = estadoturno;
    }

    public String getObservacionesturno() {
        return observacionesturno;
    }

    public void setObservacionesturno(String observacionesturno) {
        this.observacionesturno = observacionesturno;
    }

    public Area getCodigoarea() {
        return codigoarea;
    }

    public void setCodigoarea(Area codigoarea) {
        this.codigoarea = codigoarea;
    }

    public Particular getDocumentocliente() {
        return documentocliente;
    }

    public void setDocumentocliente(Particular documentocliente) {
        this.documentocliente = documentocliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoturno != null ? codigoturno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.codigoturno == null && other.codigoturno != null) || (this.codigoturno != null && !this.codigoturno.equals(other.codigoturno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Turno[ codigoturno=" + codigoturno + " ]";
    }
    
}
