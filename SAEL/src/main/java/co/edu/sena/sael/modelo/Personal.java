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
 * @author dasak
 */
@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")
    , @NamedQuery(name = "Personal.findByDocumentopersonal", query = "SELECT p FROM Personal p WHERE p.documentopersonal = :documentopersonal")
    , @NamedQuery(name = "Personal.findByNombre", query = "SELECT p FROM Personal p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Personal.findByApellido", query = "SELECT p FROM Personal p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Personal.findByDireccion", query = "SELECT p FROM Personal p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Personal.findByCorreo", query = "SELECT p FROM Personal p WHERE p.correo = :correo")
    , @NamedQuery(name = "Personal.findByTelefono", query = "SELECT p FROM Personal p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Personal.findByClave", query = "SELECT p FROM Personal p WHERE p.clave = :clave")
    , @NamedQuery(name = "Personal.findByFechanacimiento", query = "SELECT p FROM Personal p WHERE p.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Personal.findByLugarnacimiento", query = "SELECT p FROM Personal p WHERE p.lugarnacimiento = :lugarnacimiento")
    , @NamedQuery(name = "Personal.findByFoto", query = "SELECT p FROM Personal p WHERE p.foto = :foto")
    , @NamedQuery(name = "Personal.findByCorreoinstitucional", query = "SELECT p FROM Personal p WHERE p.correoinstitucional = :correoinstitucional")
    , @NamedQuery(name = "Personal.findBySexo", query = "SELECT p FROM Personal p WHERE p.sexo = :sexo")})
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

    public Personal(Long documentopersonal, String nombre, String apellido) {
        this.documentopersonal = documentopersonal;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(Long documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCorreoinstitucional() {
        return correoinstitucional;
    }

    public void setCorreoinstitucional(String correoinstitucional) {
        this.correoinstitucional = correoinstitucional;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
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
