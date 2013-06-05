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
@Table(name = "ordensalida", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordensalida.findAll", query = "SELECT o FROM Ordensalida o"),
    @NamedQuery(name = "Ordensalida.findByIdOrdenSalida", query = "SELECT o FROM Ordensalida o WHERE o.idOrdenSalida = :idOrdenSalida"),
    @NamedQuery(name = "Ordensalida.findByFechaOrden", query = "SELECT o FROM Ordensalida o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "Ordensalida.findByFechaSalida", query = "SELECT o FROM Ordensalida o WHERE o.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Ordensalida.findByAprobado", query = "SELECT o FROM Ordensalida o WHERE o.aprobado = :aprobado")})
public class Ordensalida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrdenSalida", nullable = false)
    private Integer idOrdenSalida;
    @Column(name = "FechaOrden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Column(name = "FechaSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Column(name = "Aprobado")
    private Boolean aprobado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenSalida")
    private List<Salida> salidadList;
    @JoinColumn(name = "idSolicitud", referencedColumnName = "idSolicitud", nullable = false)
    @ManyToOne(optional = false)
    private Solicitud idSolicitud;

    public Ordensalida() {
    }

    public Ordensalida(Integer idOrdenSalida) {
        this.idOrdenSalida = idOrdenSalida;
    }

    public Integer getIdOrdenSalida() {
        return idOrdenSalida;
    }

    public void setIdOrdenSalida(Integer idOrdenSalida) {
        this.idOrdenSalida = idOrdenSalida;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    @XmlTransient
    public List<Salida> getSalidadList() {
        return salidadList;
    }

    public void setSalidadList(List<Salida> salidadList) {
        this.salidadList = salidadList;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenSalida != null ? idOrdenSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordensalida)) {
            return false;
        }
        Ordensalida other = (Ordensalida) object;
        if ((this.idOrdenSalida == null && other.idOrdenSalida != null) || (this.idOrdenSalida != null && !this.idOrdenSalida.equals(other.idOrdenSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Ordensalida[ idOrdenSalida=" + idOrdenSalida + " ]";
    }
    
}
