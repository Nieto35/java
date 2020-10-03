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
 * @author Asus s14
 */
@Entity
@Table(name = "programarseguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programarseguimiento.findAll", query = "SELECT p FROM Programarseguimiento p")
    , @NamedQuery(name = "Programarseguimiento.findById", query = "SELECT p FROM Programarseguimiento p WHERE p.id = :id")
    , @NamedQuery(name = "Programarseguimiento.findByFecha", query = "SELECT p FROM Programarseguimiento p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Programarseguimiento.findByHoraInicio", query = "SELECT p FROM Programarseguimiento p WHERE p.horaInicio = :horaInicio")
    , @NamedQuery(name = "Programarseguimiento.findByHoraFinal", query = "SELECT p FROM Programarseguimiento p WHERE p.horaFinal = :horaFinal")
    , @NamedQuery(name = "Programarseguimiento.findByEstado", query = "SELECT p FROM Programarseguimiento p WHERE p.estado = :estado")})
public class Programarseguimiento implements Serializable {

    @JoinColumn(name = "numeroFicha", referencedColumnName = "numeroficha")
    @ManyToOne(optional = false)
    private Fichatitulacion numeroFicha;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "horaInicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "horaFinal")
    @Temporal(TemporalType.TIME)
    private Date horaFinal;
    @Column(name = "estado", length = 50)
    private String estado;
    @JoinColumn(name = "idCoordinador", referencedColumnName = "documentocoordinador")
    @ManyToOne(optional = false)
    private Coordinador idCoordinador;
    @JoinColumn(name = "documentoPersonal", referencedColumnName = "documentopersonal")
    @ManyToOne(optional = false)
    private Personal documentoPersonal;

    public Programarseguimiento() {
    }

    public Programarseguimiento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Coordinador getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(Coordinador idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public Personal getDocumentoPersonal() {
        return documentoPersonal;
    }

    public void setDocumentoPersonal(Personal documentoPersonal) {
        this.documentoPersonal = documentoPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programarseguimiento)) {
            return false;
        }
        Programarseguimiento other = (Programarseguimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Programarseguimiento[ id=" + id + " ]";
    }

    public Fichatitulacion getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(Fichatitulacion numeroFicha) {
        this.numeroFicha = numeroFicha;
    }
    
}
