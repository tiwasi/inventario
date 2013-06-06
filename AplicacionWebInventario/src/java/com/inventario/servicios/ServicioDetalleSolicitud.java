/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.DetalleSolicitudDAO;
import com.inventario.entidades.DetalleSolicitud;
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

    public boolean insertarDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
        return detalleSolicitudDAO.insertarDetalleSolicitud(detalleSolicitud);
    }

    public boolean actualizarDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
        return detalleSolicitudDAO.actualizarDetalleSolicitud(detalleSolicitud);
    }

    public DetalleSolicitud buscarDetalleSolicitud(int id) {
        return detalleSolicitudDAO.buscarDetalleSolicitud(id);
    }

    public boolean eliminarDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
        return detalleSolicitudDAO.eliminarDetalleSolicitud(detalleSolicitud);
    }

    public List<DetalleSolicitud> listarDetalleSolicituds() {
        return detalleSolicitudDAO.listarDetalleSolicituds();
    }

    
    
}
