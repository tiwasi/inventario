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
public class DetallesalidadPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSalidad", nullable = false)
    private int idSalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto", nullable = false)
    private int idProducto;

    public DetallesalidadPK() {
    }

    public DetallesalidadPK(int idSalidad, int idProducto) {
        this.idSalidad = idSalidad;
        this.idProducto = idProducto;
    }

    public int getIdSalidad() {
        return idSalidad;
    }

    public void setIdSalidad(int idSalidad) {
        this.idSalidad = idSalidad;
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
        hash += (int) idSalidad;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallesalidadPK)) {
            return false;
        }
        DetallesalidadPK other = (DetallesalidadPK) object;
        if (this.idSalidad != other.idSalidad) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.DetallesalidadPK[ idSalidad=" + idSalidad + ", idProducto=" + idProducto + " ]";
    }
    
}
