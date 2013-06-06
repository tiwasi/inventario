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
public class DetalleSolicitudPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto", nullable = false)
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSolicitud", nullable = false)
    private int idSolicitud;

    public DetalleSolicitudPK() {
    }

    public DetalleSolicitudPK(int idProducto, int idSolicitud) {
        this.idProducto = idProducto;
        this.idSolicitud = idSolicitud;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idSolicitud;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSolicitudPK)) {
            return false;
        }
        DetalleSolicitudPK other = (DetalleSolicitudPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idSolicitud != other.idSolicitud) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.DetallesolicitudPK[ idProducto=" + idProducto + ", idSolicitud=" + idSolicitud + " ]";
    }
    
}
