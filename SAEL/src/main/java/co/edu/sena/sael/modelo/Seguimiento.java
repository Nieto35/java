/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dasak
 */
@Entity
@Table(name = "seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s")
    , @NamedQuery(name = "Seguimiento.findByCodigoseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.codigoseguimiento = :codigoseguimiento")
    , @NamedQuery(name = "Seguimiento.findByFecha", query = "SELECT s FROM Seguimiento s WHERE s.fecha = :fecha")
    , @NamedQuery(name = "Seguimiento.findByObjetivos", query = "SELECT s FROM Seguimiento s WHERE s.objetivos = :objetivos")
    , @NamedQuery(name = "Seguimiento.findByLugar", query = "SELECT s FROM Seguimiento s WHERE s.lugar = :lugar")
    , @NamedQuery(name = "Seguimiento.findByHorainicio", query = "SELECT s FROM Seguimiento s WHERE s.horainicio = :horainicio")
    , @NamedQuery(name = "Seguimiento.findByHorafin", query = "SELECT s FROM Seguimiento s WHERE s.horafin = :horafin")
    , @NamedQuery(name = "Seguimiento.findByEstado", query = "SELECT s FROM Seguimiento s WHERE s.estado = :estado")})
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoseguimiento")
    private Integer codigoseguimiento;
    @Lob
    @Column(name = "reconocimiento", length = 65535)
    private String reconocimiento;
    @Lob
    @Column(name = "observaciones", length = 65535)
    private String observaciones;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "objetivos", length = 50)
    private String objetivos;
    @Lob
    @Column(name = "conclusiones", length = 65535)
    private String conclusiones;
    @Lob
    @Column(name = "compromisos", length = 65535)
    private String compromisos;
    @Column(name = "lugar", length = 50)
    private String lugar;
    @Column(name = "horainicio")
    @Temporal(TemporalType.TIME)
    private Date horainicio;
    @Column(name = "horafin")
    @Temporal(TemporalType.TIME)
    private Date horafin;
    @Column(name = "estado", length = 50)
    private String estado;
    @Lob
    @Column(name = "motivocancelacion", length = 65535)
    private String motivocancelacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seguimiento")
    private Collection<Comite> comiteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seguimiento")
    private Collection<Seguimientoaprendiz> seguimientoaprendizCollection;
    @JoinColumn(name = "numeroficha", referencedColumnName = "numeroficha")
    @ManyToOne
    private Fichatitulacion numeroficha;

    public Seguimiento() {
    }

    public Seguimiento(Integer codigoseguimiento) {
        this.codigoseguimiento = codigoseguimiento;
    }

    public Integer getCodigoseguimiento() {
        return codigoseguimiento;
    }

    public void setCodigoseguimiento(Integer codigoseguimiento) {
        this.codigoseguimiento = codigoseguimiento;
    }

    public String getReconocimiento() {
        return reconocimiento;
    }

    public void setReconocimiento(String reconocimiento) {
        this.reconocimiento = reconocimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getConclusiones() {
        return conclusiones;
    }

    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }

    public String getCompromisos() {
        return compromisos;
    }

    public void setCompromisos(String compromisos) {
        this.compromisos = compromisos;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivocancelacion() {
        return motivocancelacion;
    }

    public void setMotivocancelacion(String motivocancelacion) {
        this.motivocancelacion = motivocancelacion;
    }

    @XmlTransient
    public Collection<Comite> getComiteCollection() {
        return comiteCollection;
    }

    public void setComiteCollection(Collection<Comite> comiteCollection) {
        this.comiteCollection = comiteCollection;
    }

    @XmlTransient
    public Collection<Seguimientoaprendiz> getSeguimientoaprendizCollection() {
        return seguimientoaprendizCollection;
    }

    public void setSeguimientoaprendizCollection(Collection<Seguimientoaprendiz> seguimientoaprendizCollection) {
        this.seguimientoaprendizCollection = seguimientoaprendizCollection;
    }

    public Fichatitulacion getNumeroficha() {
        return numeroficha;
    }

    public void setNumeroficha(Fichatitulacion numeroficha) {
        this.numeroficha = numeroficha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoseguimiento != null ? codigoseguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.codigoseguimiento == null && other.codigoseguimiento != null) || (this.codigoseguimiento != null && !this.codigoseguimiento.equals(other.codigoseguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Seguimiento[ codigoseguimiento=" + codigoseguimiento + " ]";
    }
    
}
