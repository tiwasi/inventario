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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lio
 */
@Entity
@Table(name = "tiposolicitud", catalog = "bdinventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposolicitud.findAll", query = "SELECT t FROM Tiposolicitud t"),
    @NamedQuery(name = "Tiposolicitud.findByIdTipoSolicitud", query = "SELECT t FROM Tiposolicitud t WHERE t.idTipoSolicitud = :idTipoSolicitud"),
    @NamedQuery(name = "Tiposolicitud.findByNombre", query = "SELECT t FROM Tiposolicitud t WHERE t.nombre = :nombre")})
public class Tiposolicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoSolicitud", nullable = false)
    private Integer idTipoSolicitud;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoSolicitud")
    private List<Solicitud> solicitudList;

    public Tiposolicitud() {
    }

    public Tiposolicitud(Integer idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public Integer getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(Integer idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSolicitud != null ? idTipoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposolicitud)) {
            return false;
        }
        Tiposolicitud other = (Tiposolicitud) object;
        if ((this.idTipoSolicitud == null && other.idTipoSolicitud != null) || (this.idTipoSolicitud != null && !this.idTipoSolicitud.equals(other.idTipoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.entidades.Tiposolicitud[ idTipoSolicitud=" + idTipoSolicitud + " ]";
    }
    
}
