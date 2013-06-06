/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lio
 */
@Embeddable
public class DetalleVentaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVentas", nullable = false)
    private int idVentas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto", nullable = false)
    private int idProducto;

    public DetalleVentaPK() {
    }

    public DetalleVentaPK(int idVentas, int idProducto) {
        this.idVentas = idVentas;
        this.idProducto = idProducto;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVentas;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVentaPK)) {
            return false;
        }
        DetalleVentaPK other = (DetalleVentaPK) object;
        if (this.idVentas != other.idVentas) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.DetalleventaPK[ idVentas=" + idVentas + ", idProducto=" + idProducto + " ]";
    }
    
}
