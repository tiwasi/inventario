/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lio
 */
@Entity
@Table(name = "salidad", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salidad.findAll", query = "SELECT s FROM Salidad s"),
    @NamedQuery(name = "Salidad.findByIdSalidad", query = "SELECT s FROM Salidad s WHERE s.idSalidad = :idSalidad")})
public class Salidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSalidad", nullable = false)
    private Integer idSalidad;
    @JoinColumn(name = "idOrdenSalida", referencedColumnName = "idOrdenSalida", nullable = false)
    @ManyToOne(optional = false)
    private Ordensalida idOrdenSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salidad")
    private List<Detallesalidad> detallesalidadList;

    public Salidad() {
    }

    public Salidad(Integer idSalidad) {
        this.idSalidad = idSalidad;
    }

    public Integer getIdSalidad() {
        return idSalidad;
    }

    public void setIdSalidad(Integer idSalidad) {
        this.idSalidad = idSalidad;
    }

    public Ordensalida getIdOrdenSalida() {
        return idOrdenSalida;
    }

    public void setIdOrdenSalida(Ordensalida idOrdenSalida) {
        this.idOrdenSalida = idOrdenSalida;
    }

    @XmlTransient
    public List<Detallesalidad> getDetallesalidadList() {
        return detallesalidadList;
    }

    public void setDetallesalidadList(List<Detallesalidad> detallesalidadList) {
        this.detallesalidadList = detallesalidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalidad != null ? idSalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salidad)) {
            return false;
        }
        Salidad other = (Salidad) object;
        if ((this.idSalidad == null && other.idSalidad != null) || (this.idSalidad != null && !this.idSalidad.equals(other.idSalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Salidad[ idSalidad=" + idSalidad + " ]";
    }
    
}
