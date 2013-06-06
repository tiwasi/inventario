/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.OrdenSalidaDAO;
import com.inventario.entidades.OrdenSalida;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioOrdenSalida {
    @Autowired
    OrdenSalidaDAO ordenSalidaDAO;

    public boolean insertarOrdenSalida(OrdenSalida detalleVenta) {
        return ordenSalidaDAO.insertarOrdenSalida(detalleVenta);
    }

    public boolean actualizarOrdenSalida(OrdenSalida detalleVenta) {
        return ordenSalidaDAO.actualizarOrdenSalida(detalleVenta);
    }

    public OrdenSalida buscarOrdenSalida(int id) {
        return ordenSalidaDAO.buscarOrdenSalida(id);
    }

    public boolean eliminarOrdenSalida(OrdenSalida detalleVenta) {
        return ordenSalidaDAO.eliminarOrdenSalida(detalleVenta);
    }

    public List<OrdenSalida> listarOrdenSalidas() {
        return ordenSalidaDAO.listarOrdenSalidas();
    }

    
}
