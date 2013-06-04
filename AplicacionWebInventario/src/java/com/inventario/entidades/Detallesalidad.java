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
@Table(name = "detallesalidad", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallesalidad.findAll", query = "SELECT d FROM Detallesalidad d"),
    @NamedQuery(name = "Detallesalidad.findByIdSalidad", query = "SELECT d FROM Detallesalidad d WHERE d.detallesalidadPK.idSalidad = :idSalidad"),
    @NamedQuery(name = "Detallesalidad.findByIdProducto", query = "SELECT d FROM Detallesalidad d WHERE d.detallesalidadPK.idProducto = :idProducto"),
    @NamedQuery(name = "Detallesalidad.findByCantidad", query = "SELECT d FROM Detallesalidad d WHERE d.cantidad = :cantidad")})
public class Detallesalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallesalidadPK detallesalidadPK;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "idSalidad", referencedColumnName = "idSalidad", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Salidad salidad;

    public Detallesalidad() {
    }

    public Detallesalidad(DetallesalidadPK detallesalidadPK) {
        this.detallesalidadPK = detallesalidadPK;
    }

    public Detallesalidad(int idSalidad, int idProducto) {
        this.detallesalidadPK = new DetallesalidadPK(idSalidad, idProducto);
    }

    public DetallesalidadPK getDetallesalidadPK() {
        return detallesalidadPK;
    }

    public void setDetallesalidadPK(DetallesalidadPK detallesalidadPK) {
        this.detallesalidadPK = detallesalidadPK;
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

    public Salidad getSalidad() {
        return salidad;
    }

    public void setSalidad(Salidad salidad) {
        this.salidad = salidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallesalidadPK != null ? detallesalidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallesalidad)) {
            return false;
        }
        Detallesalidad other = (Detallesalidad) object;
        if ((this.detallesalidadPK == null && other.detallesalidadPK != null) || (this.detallesalidadPK != null && !this.detallesalidadPK.equals(other.detallesalidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Detallesalidad[ detallesalidadPK=" + detallesalidadPK + " ]";
    }
    
}
