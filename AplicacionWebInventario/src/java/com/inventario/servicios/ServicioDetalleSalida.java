/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.DetalleSalidaDAO;
import com.inventario.entidades.DetalleSalida;
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

    public boolean insertarDetalleSalida(DetalleSalida detalleSalida) {
        return detalleSalidaDAO.insertarDetalleSalida(detalleSalida);
    }

    public boolean actualizarDetalleSalida(DetalleSalida detalleSalida) {
        return detalleSalidaDAO.actualizarDetalleSalida(detalleSalida);
    }

    public DetalleSalida buscarDetalleSalida(int id) {
        return detalleSalidaDAO.buscarDetalleSalida(id);
    }

    public boolean eliminarDetalleSalida(DetalleSalida detalleSalida) {
        return detalleSalidaDAO.eliminarDetalleSalida(detalleSalida);
    }

    public List<DetalleSalida> listarDetalleSalidas() {
        return detalleSalidaDAO.listarDetalleSalidas();
    }
    
}
