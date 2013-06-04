/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lio
 */
@Entity
@Table(name = "movimientos", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT m FROM Movimientos m"),
    @NamedQuery(name = "Movimientos.findByIdMovimientos", query = "SELECT m FROM Movimientos m WHERE m.idMovimientos = :idMovimientos"),
    @NamedQuery(name = "Movimientos.findByTipoMovimiento", query = "SELECT m FROM Movimientos m WHERE m.tipoMovimiento = :tipoMovimiento"),
    @NamedQuery(name = "Movimientos.findByFechaMovimiento", query = "SELECT m FROM Movimientos m WHERE m.fechaMovimiento = :fechaMovimiento"),
    @NamedQuery(name = "Movimientos.findByMotivo", query = "SELECT m FROM Movimientos m WHERE m.motivo = :motivo")})
public class Movimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimientos", nullable = false)
    private Integer idMovimientos;
    @Size(max = 45)
    @Column(name = "TipoMovimiento", length = 45)
    private String tipoMovimiento;
    @Column(name = "FechaMovimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovimiento;
    @Size(max = 255)
    @Column(name = "Motivo", length = 255)
    private String motivo;
    @JoinColumn(name = "idPersonal", referencedColumnName = "idPersonal", nullable = false)
    @ManyToOne(optional = false)
    private Personal idPersonal;

    public Movimientos() {
    }

    public Movimientos(Integer idMovimientos) {
        this.idMovimientos = idMovimientos;
    }

    public Integer getIdMovimientos() {
        return idMovimientos;
    }

    public void setIdMovimientos(Integer idMovimientos) {
        this.idMovimientos = idMovimientos;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Personal getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Personal idPersonal) {
        this.idPersonal = idPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimientos != null ? idMovimientos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.idMovimientos == null && other.idMovimientos != null) || (this.idMovimientos != null && !this.idMovimientos.equals(other.idMovimientos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Movimientos[ idMovimientos=" + idMovimientos + " ]";
    }
    
}
