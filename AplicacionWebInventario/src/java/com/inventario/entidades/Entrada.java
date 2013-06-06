/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lio
 */
@Entity
@Table(name = "entrada", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e"),
    @NamedQuery(name = "Entrada.findByIdEntrada", query = "SELECT e FROM Entrada e WHERE e.idEntrada = :idEntrada"),
    @NamedQuery(name = "Entrada.findByFechaEntrada", query = "SELECT e FROM Entrada e WHERE e.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "Entrada.findByNumComprobante", query = "SELECT e FROM Entrada e WHERE e.numComprobante = :numComprobante"),
    @NamedQuery(name = "Entrada.findByNumProductos", query = "SELECT e FROM Entrada e WHERE e.numProductos = :numProductos"),
    @NamedQuery(name = "Entrada.findByMontoTotal", query = "SELECT e FROM Entrada e WHERE e.montoTotal = :montoTotal"),
    @NamedQuery(name = "Entrada.findByTipoPago", query = "SELECT e FROM Entrada e WHERE e.tipoPago = :tipoPago")})
public class Entrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEntrada", nullable = false)
    private Integer idEntrada;
    @Column(name = "FechaEntrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @Column(name = "NumComprobante")
    private Integer numComprobante;
    @Column(name = "NumProductos")
    private Integer numProductos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MontoTotal", precision = 22)
    private Double montoTotal;
    @Size(max = 20)
    @Column(name = "TipoPago", length = 20)
    private String tipoPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrada")
    private List<DetalleEntrada> detalleentradaList;
    @JoinColumn(name = "idAlmacen", referencedColumnName = "idAlmacen", nullable = false)
    @ManyToOne(optional = false)
    private Almacen idAlmacen;
    @JoinColumn(name = "idOrdenCompra", referencedColumnName = "idOrdenCompra", nullable = false)
    @ManyToOne(optional = false)
    private OrdenCompra idOrdenCompra;

    public Entrada() {
    }

    public Entrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Integer getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(Integer numComprobante) {
        this.numComprobante = numComprobante;
    }

    public Integer getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(Integer numProductos) {
        this.numProductos = numProductos;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @XmlTransient
    public List<DetalleEntrada> getDetalleentradaList() {
        return detalleentradaList;
    }

    public void setDetalleentradaList(List<DetalleEntrada> detalleentradaList) {
        this.detalleentradaList = detalleentradaList;
    }

    public Almacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Almacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public OrdenCompra getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(OrdenCompra idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrada != null ? idEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.idEntrada == null && other.idEntrada != null) || (this.idEntrada != null && !this.idEntrada.equals(other.idEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Entrada[ idEntrada=" + idEntrada + " ]";
    }
    
}
