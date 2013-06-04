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
@Table(name = "producto", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombreProd", query = "SELECT p FROM Producto p WHERE p.nombreProd = :nombreProd"),
    @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock"),
    @NamedQuery(name = "Producto.findByPrecioCompra", query = "SELECT p FROM Producto p WHERE p.precioCompra = :precioCompra"),
    @NamedQuery(name = "Producto.findByPrecioVenta", query = "SELECT p FROM Producto p WHERE p.precioVenta = :precioVenta"),
    @NamedQuery(name = "Producto.findByEstado", query = "SELECT p FROM Producto p WHERE p.estado = :estado"),
    @NamedQuery(name = "Producto.findByFechaIngreso", query = "SELECT p FROM Producto p WHERE p.fechaIngreso = :fechaIngreso")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto", nullable = false)
    private Integer idProducto;
    @Size(max = 45)
    @Column(name = "NombreProd", length = 45)
    private String nombreProd;
    @Column(name = "Stock")
    private Integer stock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PrecioCompra", precision = 22)
    private Double precioCompra;
    @Column(name = "PrecioVenta", precision = 22)
    private Double precioVenta;
    @Column(name = "Estado")
    private Boolean estado;
    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Detalleentrada> detalleentradaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Detallesolicitud> detallesolicitudList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<Inventario> inventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Detallesalidad> detallesalidadList;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria", nullable = false)
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor", nullable = false)
    @ManyToOne(optional = false)
    private Proveedor idProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Detalleventa> detalleventaList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @XmlTransient
    public List<Detalleentrada> getDetalleentradaList() {
        return detalleentradaList;
    }

    public void setDetalleentradaList(List<Detalleentrada> detalleentradaList) {
        this.detalleentradaList = detalleentradaList;
    }

    @XmlTransient
    public List<Detallesolicitud> getDetallesolicitudList() {
        return detallesolicitudList;
    }

    public void setDetallesolicitudList(List<Detallesolicitud> detallesolicitudList) {
        this.detallesolicitudList = detallesolicitudList;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    @XmlTransient
    public List<Detallesalidad> getDetallesalidadList() {
        return detallesalidadList;
    }

    public void setDetallesalidadList(List<Detallesalidad> detallesalidadList) {
        this.detallesalidadList = detallesalidadList;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @XmlTransient
    public List<Detalleventa> getDetalleventaList() {
        return detalleventaList;
    }

    public void setDetalleventaList(List<Detalleventa> detalleventaList) {
        this.detalleventaList = detalleventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
