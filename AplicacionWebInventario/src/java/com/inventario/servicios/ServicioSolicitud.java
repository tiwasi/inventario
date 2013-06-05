/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.SolicitudDAO;
import com.inventario.entidades.Solicitud;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lio
 */
@Repository
public class ServicioSolicitud {
    @Autowired
    SolicitudDAO solicitudDAO;

    public boolean insertarSolicitud(Solicitud solicitud) {
        return solicitudDAO.insertarSolicitud(solicitud);
    }

    public boolean actualizarSolicitud(Solicitud solicitud) {
        return solicitudDAO.actualizarSolicitud(solicitud);
    }

    public Solicitud buscarSolicitud(int id) {
        return solicitudDAO.buscarSolicitud(id);
    }

    public boolean eliminarSolicitud(Solicitud solicitud) {
        return solicitudDAO.eliminarSolicitud(solicitud);
    }

    public List<Solicitud> listarSolicituds() {
        return solicitudDAO.listarSolicituds();
    }
    
}
