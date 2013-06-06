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
public class DetalleEntradaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto", nullable = false)
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEntrada", nullable = false)
    private int idEntrada;

    public DetalleEntradaPK() {
    }

    public DetalleEntradaPK(int idProducto, int idEntrada) {
        this.idProducto = idProducto;
        this.idEntrada = idEntrada;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idEntrada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEntradaPK)) {
            return false;
        }
        DetalleEntradaPK other = (DetalleEntradaPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idEntrada != other.idEntrada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.DetalleentradaPK[ idProducto=" + idProducto + ", idEntrada=" + idEntrada + " ]";
    }
    
}
