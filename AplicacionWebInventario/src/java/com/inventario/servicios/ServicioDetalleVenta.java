/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.DetalleVentaDAO;
import com.inventario.entidades.Detalleventa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioDetalleVenta {
    @Autowired
    DetalleVentaDAO detalleVentaDAO;

    public boolean insertarDetalleventa(Detalleventa detalleventa) {
        return detalleVentaDAO.insertarDetalleventa(detalleventa);
    }

    public boolean actualizarDetalleventa(Detalleventa detalleventa) {
        return detalleVentaDAO.actualizarDetalleventa(detalleventa);
    }

    public Detalleventa buscarDetalleventa(int id) {
        return detalleVentaDAO.buscarDetalleventa(id);
    }

    public boolean eliminarDetalleventa(Detalleventa detalleventa) {
        return detalleVentaDAO.eliminarDetalleventa(detalleventa);
    }

    public List<Detalleventa> listarDetalleventas() {
        return detalleVentaDAO.listarDetalleventas();
    }
    
}
