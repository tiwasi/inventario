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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lio
 */
@Entity
@Table(name = "detalleventa", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleventa.findAll", query = "SELECT d FROM Detalleventa d"),
    @NamedQuery(name = "Detalleventa.findByIdVentas", query = "SELECT d FROM Detalleventa d WHERE d.detalleventaPK.idVentas = :idVentas"),
    @NamedQuery(name = "Detalleventa.findByIdProducto", query = "SELECT d FROM Detalleventa d WHERE d.detalleventaPK.idProducto = :idProducto"),
    @NamedQuery(name = "Detalleventa.findByCantidad", query = "SELECT d FROM Detalleventa d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detalleventa.findByDescuento", query = "SELECT d FROM Detalleventa d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "Detalleventa.findByIgv", query = "SELECT d FROM Detalleventa d WHERE d.igv = :igv"),
    @NamedQuery(name = "Detalleventa.findBySubTotal", query = "SELECT d FROM Detalleventa d WHERE d.subTotal = :subTotal"),
    @NamedQuery(name = "Detalleventa.findByMontoVenta", query = "SELECT d FROM Detalleventa d WHERE d.montoVenta = :montoVenta")})
public class DetalleVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleVentaPK detalleventaPK;
    @Column(name = "Cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Descuento", precision = 22)
    private Double descuento;
    @Column(name = "IGV", precision = 22)
    private Double igv;
    @Column(name = "SubTotal", precision = 22)
    private Double subTotal;
    @Column(name = "MontoVenta", precision = 22)
    private Double montoVenta;
    @JoinColumn(name = "idVentas", referencedColumnName = "idVentas", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ventas ventas;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public DetalleVenta() {
    }

    public DetalleVenta(DetalleVentaPK detalleventaPK) {
        this.detalleventaPK = detalleventaPK;
    }

    public DetalleVenta(int idVentas, int idProducto) {
        this.detalleventaPK = new DetalleVentaPK(idVentas, idProducto);
    }

    public DetalleVentaPK getDetalleventaPK() {
        return detalleventaPK;
    }

    public void setDetalleventaPK(DetalleVentaPK detalleventaPK) {
        this.detalleventaPK = detalleventaPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(Double montoVenta) {
        this.montoVenta = montoVenta;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleventaPK != null ? detalleventaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.detalleventaPK == null && other.detalleventaPK != null) || (this.detalleventaPK != null && !this.detalleventaPK.equals(other.detalleventaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Detalleventa[ detalleventaPK=" + detalleventaPK + " ]";
    }
    
}
