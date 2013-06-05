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
public class DetallesalidaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSalida", nullable = false)
    private int idSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto", nullable = false)
    private int idProducto;

    public DetallesalidaPK() {
    }

    public DetallesalidaPK(int idSalida, int idProducto) {
        this.idSalida = idSalida;
        this.idProducto = idProducto;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
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
        hash += (int) idSalida;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesalidaPK)) {
            return false;
        }
        DetallesalidaPK other = (DetallesalidaPK) object;
        if (this.idSalida != other.idSalida) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.DetallesalidadPK[ idSalida=" + idSalida + ", idProducto=" + idProducto + " ]";
    }
    
}
