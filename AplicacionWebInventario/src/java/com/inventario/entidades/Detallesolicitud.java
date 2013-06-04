/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lio
 */
@Entity
@Table(name = "detallesolicitud", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallesolicitud.findAll", query = "SELECT d FROM Detallesolicitud d"),
    @NamedQuery(name = "Detallesolicitud.findByIdProducto", query = "SELECT d FROM Detallesolicitud d WHERE d.detallesolicitudPK.idProducto = :idProducto"),
    @NamedQuery(name = "Detallesolicitud.findByIdSolicitud", query = "SELECT d FROM Detallesolicitud d WHERE d.detallesolicitudPK.idSolicitud = :idSolicitud"),
    @NamedQuery(name = "Detallesolicitud.findByCantidad", query = "SELECT d FROM Detallesolicitud d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detallesolicitud.findByUnidadMedida", query = "SELECT d FROM Detallesolicitud d WHERE d.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "Detallesolicitud.findByValorUnitario", query = "SELECT d FROM Detallesolicitud d WHERE d.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Detallesolicitud.findByValorTotal", query = "SELECT d FROM Detallesolicitud d WHERE d.valorTotal = :valorTotal")})
public class Detallesolicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallesolicitudPK detallesolicitudPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 20)
    @Column(name = "unidadMedida", length = 20)
    private String unidadMedida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorUnitario", precision = 22)
    private Double valorUnitario;
    @Column(name = "valorTotal", precision = 22)
    private Double valorTotal;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "idSolicitud", referencedColumnName = "idSolicitud", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Solicitud solicitud;

    public Detallesolicitud() {
    }

    public Detallesolicitud(DetallesolicitudPK detallesolicitudPK) {
        this.detallesolicitudPK = detallesolicitudPK;
    }

    public Detallesolicitud(int idProducto, int idSolicitud) {
        this.detallesolicitudPK = new DetallesolicitudPK(idProducto, idSolicitud);
    }

    public DetallesolicitudPK getDetallesolicitudPK() {
        return detallesolicitudPK;
    }

    public void setDetallesolicitudPK(DetallesolicitudPK detallesolicitudPK) {
        this.detallesolicitudPK = detallesolicitudPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallesolicitudPK != null ? detallesolicitudPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallesolicitud)) {
            return false;
        }
        Detallesolicitud other = (Detallesolicitud) object;
        if ((this.detallesolicitudPK == null && other.detallesolicitudPK != null) || (this.detallesolicitudPK != null && !this.detallesolicitudPK.equals(other.detallesolicitudPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Detallesolicitud[ detallesolicitudPK=" + detallesolicitudPK + " ]";
    }
    
}
