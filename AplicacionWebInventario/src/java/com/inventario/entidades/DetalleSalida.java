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
@Table(name = "detallesalida", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallesalida.findAll", query = "SELECT d FROM Detallesalida d"),
    @NamedQuery(name = "Detallesalida.findByIdSalida", query = "SELECT d FROM Detallesalida d WHERE d.detallesalidaPK.idSalida = :idSalida"),
    @NamedQuery(name = "Detallesalida.findByIdProducto", query = "SELECT d FROM Detallesalida d WHERE d.detallesalidaPK.idProducto = :idProducto"),
    @NamedQuery(name = "Detallesalida.findByCantidad", query = "SELECT d FROM Detallesalida d WHERE d.cantidad = :cantidad")})
public class DetalleSalida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleSalidaPK detallesalidaPK;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "idSalida", referencedColumnName = "idSalida", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Salida salida;

    public DetalleSalida() {
    }

    public DetalleSalida(DetalleSalidaPK detallesalidaPK) {
        this.detallesalidaPK = detallesalidaPK;
    }

    public DetalleSalida(int idSalida, int idProducto) {
        this.detallesalidaPK = new DetalleSalidaPK(idSalida, idProducto);
    }

    public DetalleSalidaPK getDetallesalidaPK() {
        return detallesalidaPK;
    }

    public void setDetallesalidaPK(DetalleSalidaPK detallesalidaPK) {
        this.detallesalidaPK = detallesalidaPK;
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

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallesalidaPK != null ? detallesalidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSalida)) {
            return false;
        }
        DetalleSalida other = (DetalleSalida) object;
        if ((this.detallesalidaPK == null && other.detallesalidaPK != null) || (this.detallesalidaPK != null && !this.detallesalidaPK.equals(other.detallesalidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Detallesalida[ detallesalidaPK=" + detallesalidaPK + " ]";
    }
    
}
