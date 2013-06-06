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
@Table(name = "detalleentrada", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleentrada.findAll", query = "SELECT d FROM Detalleentrada d"),
    @NamedQuery(name = "Detalleentrada.findByIdProducto", query = "SELECT d FROM Detalleentrada d WHERE d.detalleentradaPK.idProducto = :idProducto"),
    @NamedQuery(name = "Detalleentrada.findByIdEntrada", query = "SELECT d FROM Detalleentrada d WHERE d.detalleentradaPK.idEntrada = :idEntrada"),
    @NamedQuery(name = "Detalleentrada.findByCantidad", query = "SELECT d FROM Detalleentrada d WHERE d.cantidad = :cantidad")})
public class DetalleEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleEntradaPK detalleentradaPK;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "idEntrada", referencedColumnName = "idEntrada", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Entrada entrada;

    public DetalleEntrada() {
    }

    public DetalleEntrada(DetalleEntradaPK detalleentradaPK) {
        this.detalleentradaPK = detalleentradaPK;
    }

    public DetalleEntrada(int idProducto, int idEntrada) {
        this.detalleentradaPK = new DetalleEntradaPK(idProducto, idEntrada);
    }

    public DetalleEntradaPK getDetalleentradaPK() {
        return detalleentradaPK;
    }

    public void setDetalleentradaPK(DetalleEntradaPK detalleentradaPK) {
        this.detalleentradaPK = detalleentradaPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleentradaPK != null ? detalleentradaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEntrada)) {
            return false;
        }
        DetalleEntrada other = (DetalleEntrada) object;
        if ((this.detalleentradaPK == null && other.detalleentradaPK != null) || (this.detalleentradaPK != null && !this.detalleentradaPK.equals(other.detalleentradaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Detalleentrada[ detalleentradaPK=" + detalleentradaPK + " ]";
    }
    
}
