/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.DetalleSalidaDAO;
import com.inventario.entidades.Detallesalida;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioDetalleSalida {
    @Autowired
    DetalleSalidaDAO detalleSalidaDAO;

    public boolean insertarDetallesalida(Detallesalida detallesalida) {
        return detalleSalidaDAO.insertarDetallesalida(detallesalida);
    }

    public boolean actualizarDetallesalida(Detallesalida detallesalida) {
        return detalleSalidaDAO.actualizarDetallesalida(detallesalida);
    }

    public Detallesalida buscarDetallesalida(int id) {
        return detalleSalidaDAO.buscarDetallesalida(id);
    }

    public boolean eliminarDetallesalida(Detallesalida detallesalida) {
        return detalleSalidaDAO.eliminarDetallesalida(detallesalida);
    }

    public List<Detallesalida> listarDetallesalidas() {
        return detalleSalidaDAO.listarDetallesalidas();
    }
    
}
