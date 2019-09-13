/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "eproductiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eproductiva.findAll", query = "SELECT e FROM Eproductiva e")
    , @NamedQuery(name = "Eproductiva.findByCodigoeproductiva", query = "SELECT e FROM Eproductiva e WHERE e.codigoeproductiva = :codigoeproductiva")
    , @NamedQuery(name = "Eproductiva.findByFechainicioeproductiva", query = "SELECT e FROM Eproductiva e WHERE e.fechainicioeproductiva = :fechainicioeproductiva")
    , @NamedQuery(name = "Eproductiva.findByFechafineproductiva", query = "SELECT e FROM Eproductiva e WHERE e.fechafineproductiva = :fechafineproductiva")
    , @NamedQuery(name = "Eproductiva.findByEstadoeproductiva", query = "SELECT e FROM Eproductiva e WHERE e.estadoeproductiva = :estadoeproductiva")
    , @NamedQuery(name = "Eproductiva.findByDocumentocoformador", query = "SELECT e FROM Eproductiva e WHERE e.documentocoformador = :documentocoformador")
    , @NamedQuery(name = "Eproductiva.findByEtapaeproductiva", query = "SELECT e FROM Eproductiva e WHERE e.etapaeproductiva = :etapaeproductiva")
    , @NamedQuery(name = "Eproductiva.findByBitacoraseproductiva", query = "SELECT e FROM Eproductiva e WHERE e.bitacoraseproductiva = :bitacoraseproductiva")})
public class Eproductiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoeproductiva")
    private Integer codigoeproductiva;
    @Column(name = "fechainicioeproductiva")
    @Temporal(TemporalType.DATE)
    private Date fechainicioeproductiva;
    @Column(name = "fechafineproductiva")
    @Temporal(TemporalType.DATE)
    private Date fechafineproductiva;
    @Lob
    @Size(max = 65535)
    @Column(name = "funcioneseproductiva")
    private String funcioneseproductiva;
    @Size(max = 50)
    @Column(name = "estadoeproductiva")
    private String estadoeproductiva;
    @Column(name = "documentocoformador")
    private BigInteger documentocoformador;
    @Size(max = 50)
    @Column(name = "etapaeproductiva")
    private String etapaeproductiva;
    @Size(max = 50)
    @Column(name = "bitacoraseproductiva")
    private String bitacoraseproductiva;
    @OneToMany(mappedBy = "codigoeproductiva")
    private Collection<Comiteproductiva> comiteproductivaCollection;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentoaprendiz")
    @ManyToOne
    private Aprendiz documentoaprendiz;
    @JoinColumn(name = "numeroempresa", referencedColumnName = "numeroempresa")
    @ManyToOne
    private Empresa numeroempresa;
    @JoinColumn(name = "documentofuncionario", referencedColumnName = "documentofuncionario")
    @ManyToOne
    private Funcionario documentofuncionario;
    @JoinColumn(name = "codigotipopractica", referencedColumnName = "codigotipopractica")
    @ManyToOne
    private Tipopractica codigotipopractica;
    @OneToMany(mappedBy = "codigoeproductiva")
    private Collection<Novedadproductiva> novedadproductivaCollection;
    @OneToMany(mappedBy = "codigoeproductiva")
    private Collection<Visita> visitaCollection;

    public Eproductiva() {
    }

    public Eproductiva(Integer codigoeproductiva) {
        this.codigoeproductiva = codigoeproductiva;
    }

    public Integer getCodigoeproductiva() {
        return codigoeproductiva;
    }

    public void setCodigoeproductiva(Integer codigoeproductiva) {
        this.codigoeproductiva = codigoeproductiva;
    }

    public Date getFechainicioeproductiva() {
        return fechainicioeproductiva;
    }

    public void setFechainicioeproductiva(Date fechainicioeproductiva) {
        this.fechainicioeproductiva = fechainicioeproductiva;
    }

    public Date getFechafineproductiva() {
        return fechafineproductiva;
    }

    public void setFechafineproductiva(Date fechafineproductiva) {
        this.fechafineproductiva = fechafineproductiva;
    }

    public String getFuncioneseproductiva() {
        return funcioneseproductiva;
    }

    public void setFuncioneseproductiva(String funcioneseproductiva) {
        this.funcioneseproductiva = funcioneseproductiva;
    }

    public String getEstadoeproductiva() {
        return estadoeproductiva;
    }

    public void setEstadoeproductiva(String estadoeproductiva) {
        this.estadoeproductiva = estadoeproductiva;
    }

    public BigInteger getDocumentocoformador() {
        return documentocoformador;
    }

    public void setDocumentocoformador(BigInteger documentocoformador) {
        this.documentocoformador = documentocoformador;
    }

    public String getEtapaeproductiva() {
        return etapaeproductiva;
    }

    public void setEtapaeproductiva(String etapaeproductiva) {
        this.etapaeproductiva = etapaeproductiva;
    }

    public String getBitacoraseproductiva() {
        return bitacoraseproductiva;
    }

    public void setBitacoraseproductiva(String bitacoraseproductiva) {
        this.bitacoraseproductiva = bitacoraseproductiva;
    }

    @XmlTransient
    public Collection<Comiteproductiva> getComiteproductivaCollection() {
        return comiteproductivaCollection;
    }

    public void setComiteproductivaCollection(Collection<Comiteproductiva> comiteproductivaCollection) {
        this.comiteproductivaCollection = comiteproductivaCollection;
    }

    public Aprendiz getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(Aprendiz documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    public Empresa getNumeroempresa() {
        return numeroempresa;
    }

    public void setNumeroempresa(Empresa numeroempresa) {
        this.numeroempresa = numeroempresa;
    }

    public Funcionario getDocumentofuncionario() {
        return documentofuncionario;
    }

    public void setDocumentofuncionario(Funcionario documentofuncionario) {
        this.documentofuncionario = documentofuncionario;
    }

    public Tipopractica getCodigotipopractica() {
        return codigotipopractica;
    }

    public void setCodigotipopractica(Tipopractica codigotipopractica) {
        this.codigotipopractica = codigotipopractica;
    }

    @XmlTransient
    public Collection<Novedadproductiva> getNovedadproductivaCollection() {
        return novedadproductivaCollection;
    }

    public void setNovedadproductivaCollection(Collection<Novedadproductiva> novedadproductivaCollection) {
        this.novedadproductivaCollection = novedadproductivaCollection;
    }

    @XmlTransient
    public Collection<Visita> getVisitaCollection() {
        return visitaCollection;
    }

    public void setVisitaCollection(Collection<Visita> visitaCollection) {
        this.visitaCollection = visitaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoeproductiva != null ? codigoeproductiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eproductiva)) {
            return false;
        }
        Eproductiva other = (Eproductiva) object;
        if ((this.codigoeproductiva == null && other.codigoeproductiva != null) || (this.codigoeproductiva != null && !this.codigoeproductiva.equals(other.codigoeproductiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.sael.modelo.Eproductiva[ codigoeproductiva=" + codigoeproductiva + " ]";
    }
    
}
