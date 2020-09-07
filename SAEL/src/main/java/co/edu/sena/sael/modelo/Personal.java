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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByDocumentopersonal", query = "SELECT p FROM Personal p WHERE p.documentopersonal = :documentopersonal")
    , @NamedQuery(name = "Personal.findByNombrepersonal", query = "SELECT p FROM Personal p WHERE p.nombrepersonal = :nombrepersonal")
    , @NamedQuery(name = "Personal.findByApellidopersonal", query = "SELECT p FROM Personal p WHERE p.apellidopersonal = :apellidopersonal")
    , @NamedQuery(name = "Personal.findByDireccionpersonal", query = "SELECT p FROM Personal p WHERE p.direccionpersonal = :direccionpersonal")
    , @NamedQuery(name = "Personal.findByCorreopersonal", query = "SELECT p FROM Personal p WHERE p.correopersonal = :correopersonal")
    , @NamedQuery(name = "Personal.findByTelefonopersonal", query = "SELECT p FROM Personal p WHERE p.telefonopersonal = :telefonopersonal")
    , @NamedQuery(name = "Personal.findByClavepersonal", query = "SELECT p FROM Personal p WHERE p.clavepersonal = :clavepersonal")
    , @NamedQuery(name = "Personal.findByFechanacimientopersonal", query = "SELECT p FROM Personal p WHERE p.fechanacimientopersonal = :fechanacimientopersonal")
    , @NamedQuery(name = "Personal.findByLugarnacimientopersonal", query = "SELECT p FROM Personal p WHERE p.lugarnacimientopersonal = :lugarnacimientopersonal")
    , @NamedQuery(name = "Personal.findByFotopersonal", query = "SELECT p FROM Personal p WHERE p.fotopersonal = :fotopersonal")
    , @NamedQuery(name = "Personal.findByCorreoinstitucionalpersonal", query = "SELECT p FROM Personal p WHERE p.correoinstitucionalpersonal = :correoinstitucionalpersonal")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "documentopersonal", nullable = false)// @NotNull
    private Long documentopersonal;
    @Basic(optional = false)
    @Column(name = "nombrepersonal",nullable = false, length = 100)//@NotNull,@Size
    private String nombrepersonal;
    @Basic(optional = false)
    @Column(name = "apellidopersonal",nullable = false, length = 100)//@NotNull,@Size)
    private String apellidopersonal;
    @Column(name = "direccionpersonal",length = 100)//@size
    private String direccionpersonal;
    @Column(name = "correopersonal",length = 100)//@size)
    private String correopersonal;
    @Column(name = "telefonopersonal",length = 100)//@size)
    private String telefonopersonal;   
    @Column(name = "clavepersonal",length = 255)//@size)
    private String clavepersonal;
    @Column(name = "fechanacimientopersonal")
    @Temporal(TemporalType.DATE)
    private Date fechanacimientopersonal; 
    @Column(name = "lugarnacimientopersonal",length = 50)//@size)
    private String lugarnacimientopersonal;  
    @Column(name = "fotopersonal",length = 100)//@size)
    private String fotopersonal;
    @Column(name = "correoinstitucionalpersonal",length = 100)//@size)
    private String correoinstitucionalpersonal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal")
    private Collection<Comite> comiteCollection;
    @OneToMany(mappedBy = "documentopersonal")
    private Collection<Usodeambiente> usodeambienteCollection;
    @OneToMany(mappedBy = "documentopersonal")
    private Collection<Reservaambiente> reservaambienteCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Funcionario funcionario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Aprendiz aprendiz;
    @OneToMany(mappedBy = "documentopersonal")
    private Collection<Contrato> contratoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Particular particular;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Coordinador coordinador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Instructor instructor;
    @OneToMany(mappedBy = "documentopersonal")
    private Collection<Ingreso> ingresoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Guarda guarda;

    public Personal() {
    }

    public Personal(Long documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    public Personal(Long documentopersonal, String nombrepersonal, String apellidopersonal) {
        this.documentopersonal = documentopersonal;
        this.nombrepersonal = nombrepersonal;
        this.apellidopersonal = apellidopersonal;
    }

    public Long getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(Long documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    public String getNombrepersonal() {
        return nombrepersonal;
    }

    public void setNombrepersonal(String nombrepersonal) {
        this.nombrepersonal = nombrepersonal;
    }

    public String getApellidopersonal() {
        return apellidopersonal;
    }

    public void setApellidopersonal(String apellidopersonal) {
        this.apellidopersonal = apellidopersonal;
    }

    public String getDireccionpersonal() {
        return direccionpersonal;
    }

    public void setDireccionpersonal(String direccionpersonal) {
        this.direccionpersonal = direccionpersonal;
    }

    public String getCorreopersonal() {
        return correopersonal;
    }

    public void setCorreopersonal(String correopersonal) {
        this.correopersonal = correopersonal;
    }

    public String getTelefonopersonal() {
        return telefonopersonal;
    }

    public void setTelefonopersonal(String telefonopersonal) {
        this.telefonopersonal = telefonopersonal;
    }

    public String getClavepersonal() {
        return clavepersonal;
    }

    public void setClavepersonal(String clavepersonal) {
        this.clavepersonal = clavepersonal;
    }

    public Date getFechanacimientopersonal() {
        return fechanacimientopersonal;
    }

    public void setFechanacimientopersonal(Date fechanacimientopersonal) {
        this.fechanacimientopersonal = fechanacimientopersonal;
    }

    public String getLugarnacimientopersonal() {
        return lugarnacimientopersonal;
    }

    public void setLugarnacimientopersonal(String lugarnacimientopersonal) {
        this.lugarnacimientopersonal = lugarnacimientopersonal;
    }

    public String getFotopersonal() {
        return fotopersonal;
    }

    public void setFotopersonal(String fotopersonal) {
        this.fotopersonal = fotopersonal;
    }

    public String getCorreoinstitucionalpersonal() {
        return correoinstitucionalpersonal;
    }

    public void setCorreoinstitucionalpersonal(String correoinstitucionalpersonal) {
        this.correoinstitucionalpersonal = correoinstitucionalpersonal;
    }

    @XmlTransient
    public Collection<Comite> getComiteCollection() {
        return comiteCollection;
    }

    public void setComiteCollection(Collection<Comite> comiteCollection) {
        this.comiteCollection = comiteCollection;
    }

    @XmlTransient
    public Collection<Usodeambiente> getUsodeambienteCollection() {
        return usodeambienteCollection;
    }

    public void setUsodeambienteCollection(Collection<Usodeambiente> usodeambienteCollection) {
        this.usodeambienteCollection = usodeambienteCollection;
    }

    @XmlTransient
    public Collection<Reservaambiente> getReservaambienteCollection() {
        return reservaambienteCollection;
    }

    public void setReservaambienteCollection(Collection<Reservaambiente> reservaambienteCollection) {
        this.reservaambienteCollection = reservaambienteCollection;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    @XmlTransient
    public Collection<Contrato> getContratoCollection() {
        return contratoCollection;
    }

    public void setContratoCollection(Collection<Contrato> contratoCollection) {
        this.contratoCollection = contratoCollection;
    }

    public Particular getParticular() {
        return particular;
    }

    public void setParticular(Particular particular) {
        this.particular = particular;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @XmlTransient
    public Collection<Ingreso> getIngresoCollection() {
        return ingresoCollection;
    }

    public void setIngresoCollection(Collection<Ingreso> ingresoCollection) {
        this.ingresoCollection = ingresoCollection;
    }

    public Guarda getGuarda() {
        return guarda;
    }

    public void setGuarda(Guarda guarda) {
        this.guarda = guarda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentopersonal != null ? documentopersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.documentopersonal == null && other.documentopersonal != null) || (this.documentopersonal != null && !this.documentopersonal.equals(other.documentopersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Personal[ documentopersonal=" + documentopersonal + " ]";
    }
    
}
