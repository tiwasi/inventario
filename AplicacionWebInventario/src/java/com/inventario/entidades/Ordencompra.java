/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author lio
 */
@Entity
@Table(name = "ordencompra", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM Ordencompra o"),
    @NamedQuery(name = "Ordencompra.findByIdOrdenCompra", query = "SELECT o FROM Ordencompra o WHERE o.idOrdenCompra = :idOrdenCompra"),
    @NamedQuery(name = "Ordencompra.findByAprobado", query = "SELECT o FROM Ordencompra o WHERE o.aprobado = :aprobado"),
    @NamedQuery(name = "Ordencompra.findByFechaOrden", query = "SELECT o FROM Ordencompra o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "Ordencompra.findByFechaEntre", query = "SELECT o FROM Ordencompra o WHERE o.fechaEntre = :fechaEntre"),
    @NamedQuery(name = "Ordencompra.findByMontoOrden", query = "SELECT o FROM Ordencompra o WHERE o.montoOrden = :montoOrden")})
public class Ordencompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrdenCompra", nullable = false)
    private Integer idOrdenCompra;
    @Column(name = "Aprobado")
    private Boolean aprobado;
    @Column(name = "FechaOrden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Column(name = "FechaEntre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MontoOrden", precision = 22)
    private Double montoOrden;
    @JoinColumn(name = "idSolicitud", referencedColumnName = "idSolicitud", nullable = false)
    @ManyToOne(optional = false)
    private Solicitud idSolicitud;
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor", nullable = false)
    @ManyToOne(optional = false)
    private Proveedor idProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenCompra")
    private List<Entrada> entradaList;

    public Ordencompra() {
    }

    public Ordencompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public Integer getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Date getFechaEntre() {
        return fechaEntre;
    }

    public void setFechaEntre(Date fechaEntre) {
        this.fechaEntre = fechaEntre;
    }

    public Double getMontoOrden() {
        return montoOrden;
    }

    public void setMontoOrden(Double montoOrden) {
        this.montoOrden = montoOrden;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @XmlTransient
    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenCompra != null ? idOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordencompra)) {
            return false;
        }
        Ordencompra other = (Ordencompra) object;
        if ((this.idOrdenCompra == null && other.idOrdenCompra != null) || (this.idOrdenCompra != null && !this.idOrdenCompra.equals(other.idOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Ordencompra[ idOrdenCompra=" + idOrdenCompra + " ]";
    }
    
}
