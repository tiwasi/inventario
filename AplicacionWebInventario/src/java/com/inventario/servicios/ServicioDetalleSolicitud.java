/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.DetalleSolicitudDAO;
import com.inventario.entidades.Detallesolicitud;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioDetalleSolicitud {
    @Autowired
    DetalleSolicitudDAO detalleSolicitudDAO;

    public boolean insertarDetallesolicitud(Detallesolicitud detallesolicitud) {
        return detalleSolicitudDAO.insertarDetallesolicitud(detallesolicitud);
    }

    public boolean actualizarDetallesolicitud(Detallesolicitud detallesolicitud) {
        return detalleSolicitudDAO.actualizarDetallesolicitud(detallesolicitud);
    }

    public Detallesolicitud buscarDetallesolicitud(int id) {
        return detalleSolicitudDAO.buscarDetallesolicitud(id);
    }

    public boolean eliminarDetallesolicitud(Detallesolicitud detallesolicitud) {
        return detalleSolicitudDAO.eliminarDetallesolicitud(detallesolicitud);
    }

    public List<Detallesolicitud> listarDetallesolicituds() {
        return detalleSolicitudDAO.listarDetallesolicituds();
    }
    
    
}
