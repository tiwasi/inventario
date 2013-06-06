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
@Table(name = "solicitud", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud"),
    @NamedQuery(name = "Solicitud.findByFechaSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "Solicitud.findByMontoTotal", query = "SELECT s FROM Solicitud s WHERE s.montoTotal = :montoTotal")})
public class Solicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitud", nullable = false)
    private Integer idSolicitud;
    @Column(name = "FechaSolicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MontoTotal", precision = 22)
    private Double montoTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud")
    private List<DetalleSolicitud> detallesolicitudList;
    @JoinColumn(name = "idTipoSolicitud", referencedColumnName = "idTipoSolicitud", nullable = false)
    @ManyToOne(optional = false)
    private Tiposolicitud idTipoSolicitud;
    @JoinColumn(name = "idPersonal", referencedColumnName = "idPersonal", nullable = false)
    @ManyToOne(optional = false)
    private Personal idPersonal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitud")
    private List<OrdenCompra> ordencompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitud")
    private List<OrdenSalida> ordensalidaList;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @XmlTransient
    public List<DetalleSolicitud> getDetallesolicitudList() {
        return detallesolicitudList;
    }

    public void setDetallesolicitudList(List<DetalleSolicitud> detallesolicitudList) {
        this.detallesolicitudList = detallesolicitudList;
    }

    public Tiposolicitud getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(Tiposolicitud idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public Personal getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Personal idPersonal) {
        this.idPersonal = idPersonal;
    }

    @XmlTransient
    public List<OrdenCompra> getOrdencompraList() {
        return ordencompraList;
    }

    public void setOrdencompraList(List<OrdenCompra> ordencompraList) {
        this.ordencompraList = ordencompraList;
    }

    @XmlTransient
    public List<OrdenSalida> getOrdensalidaList() {
        return ordensalidaList;
    }

    public void setOrdensalidaList(List<OrdenSalida> ordensalidaList) {
        this.ordensalidaList = ordensalidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Solicitud[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
