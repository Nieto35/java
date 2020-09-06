/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity 
@Table(name = "instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
    , @NamedQuery(name = "Instructor.findByDocumentoinstructor", query = "SELECT i FROM Instructor i WHERE i.documentoinstructor = :documentoinstructor")
    , @NamedQuery(name = "Instructor.findByTipoinstructor", query = "SELECT i FROM Instructor i WHERE i.tipoinstructor = :tipoinstructor")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "documentoinstructor", nullable = false)//@NotNull
    private Long documentoinstructor;
    @Column(name = "tipoinstructor", length = 50)//@Size
    private String tipoinstructor;
    @Lob
    @Column(name = "perfilocupacionalinstructor",length = 65535)//@Size
    private String perfilocupacionalinstructor;
    @Lob
    @Column(name = "logrosinstructor",length = 65535)//@Size
    private String logrosinstructor;
    @ManyToMany(mappedBy = "instructorCollection")
    private Collection<Fichatitulacion> fichatitulacionCollection;
    @OneToMany(mappedBy = "documentoinstructor")
    private Collection<Capacitacion> capacitacionCollection;
    @OneToMany(mappedBy = "documentoinstructor")
    private Collection<Inasistencia> inasistenciaCollection;
    @OneToMany(mappedBy = "documentoinstructor")
    private Collection<Formacion> formacionCollection;
    @OneToMany(mappedBy = "documentoinstructor")
    private Collection<Experiencia> experienciaCollection;
    @OneToMany(mappedBy = "documentoinstructor")
    private Collection<Permiso> permisoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Collection<Hablaidioma> hablaidiomaCollection;
    @OneToMany(mappedBy = "documentoinstructor")
    private Collection<Fichatitulacion> fichatitulacionCollection1;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;

    public Instructor() {
    }

    public Instructor(Long documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    public Long getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(Long documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    public String getTipoinstructor() {
        return tipoinstructor;
    }

    public void setTipoinstructor(String tipoinstructor) {
        this.tipoinstructor = tipoinstructor;
    }

    public String getPerfilocupacionalinstructor() {
        return perfilocupacionalinstructor;
    }

    public void setPerfilocupacionalinstructor(String perfilocupacionalinstructor) {
        this.perfilocupacionalinstructor = perfilocupacionalinstructor;
    }

    public String getLogrosinstructor() {
        return logrosinstructor;
    }

    public void setLogrosinstructor(String logrosinstructor) {
        this.logrosinstructor = logrosinstructor;
    }

    @XmlTransient
    public Collection<Fichatitulacion> getFichatitulacionCollection() {
        return fichatitulacionCollection;
    }

    public void setFichatitulacionCollection(Collection<Fichatitulacion> fichatitulacionCollection) {
        this.fichatitulacionCollection = fichatitulacionCollection;
    }

    @XmlTransient
    public Collection<Capacitacion> getCapacitacionCollection() {
        return capacitacionCollection;
    }

    public void setCapacitacionCollection(Collection<Capacitacion> capacitacionCollection) {
        this.capacitacionCollection = capacitacionCollection;
    }

    @XmlTransient
    public Collection<Inasistencia> getInasistenciaCollection() {
        return inasistenciaCollection;
    }

    public void setInasistenciaCollection(Collection<Inasistencia> inasistenciaCollection) {
        this.inasistenciaCollection = inasistenciaCollection;
    }

    @XmlTransient
    public Collection<Formacion> getFormacionCollection() {
        return formacionCollection;
    }

    public void setFormacionCollection(Collection<Formacion> formacionCollection) {
        this.formacionCollection = formacionCollection;
    }

    @XmlTransient
    public Collection<Experiencia> getExperienciaCollection() {
        return experienciaCollection;
    }

    public void setExperienciaCollection(Collection<Experiencia> experienciaCollection) {
        this.experienciaCollection = experienciaCollection;
    }

    @XmlTransient
    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    @XmlTransient
    public Collection<Hablaidioma> getHablaidiomaCollection() {
        return hablaidiomaCollection;
    }

    public void setHablaidiomaCollection(Collection<Hablaidioma> hablaidiomaCollection) {
        this.hablaidiomaCollection = hablaidiomaCollection;
    }

    @XmlTransient
    public Collection<Fichatitulacion> getFichatitulacionCollection1() {
        return fichatitulacionCollection1;
    }

    public void setFichatitulacionCollection1(Collection<Fichatitulacion> fichatitulacionCollection1) {
        this.fichatitulacionCollection1 = fichatitulacionCollection1;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoinstructor != null ? documentoinstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.documentoinstructor == null && other.documentoinstructor != null) || (this.documentoinstructor != null && !this.documentoinstructor.equals(other.documentoinstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Instructor[ documentoinstructor=" + documentoinstructor + " ]";
    }
    
}
