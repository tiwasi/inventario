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
@Table(name = "salida", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salida.findAll", query = "SELECT s FROM Salida s"),
    @NamedQuery(name = "Salida.findByIdSalida", query = "SELECT s FROM Salida s WHERE s.idSalida = :idSalida")})
public class Salida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSalida", nullable = false)
    private Integer idSalida;
    @JoinColumn(name = "idOrdenSalida", referencedColumnName = "idOrdenSalida", nullable = false)
    @ManyToOne(optional = false)
    private Ordensalida idOrdenSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salida")
    private List<Detallesalida> detallesalidaList;

    public Salida() {
    }

    public Salida(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public Integer getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public Ordensalida getIdOrdenSalida() {
        return idOrdenSalida;
    }

    public void setIdOrdenSalida(Ordensalida idOrdenSalida) {
        this.idOrdenSalida = idOrdenSalida;
    }

    @XmlTransient
    public List<Detallesalida> getDetallesalidaList() {
        return detallesalidaList;
    }

    public void setDetallesalidaList(List<Detallesalida> detallesalidaList) {
        this.detallesalidaList = detallesalidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalida != null ? idSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salida)) {
            return false;
        }
        Salida other = (Salida) object;
        if ((this.idSalida == null && other.idSalida != null) || (this.idSalida != null && !this.idSalida.equals(other.idSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Salida[ idSalida=" + idSalida + " ]";
    }
    
}
