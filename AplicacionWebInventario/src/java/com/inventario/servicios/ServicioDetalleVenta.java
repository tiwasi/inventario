/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.DetalleVentaDAO;
import com.inventario.entidades.DetalleVenta;
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

    public boolean insertarDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaDAO.insertarDetalleVenta(detalleVenta);
    }

    public boolean actualizarDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaDAO.actualizarDetalleVenta(detalleVenta);
    }

    public DetalleVenta buscarDetalleVenta(int id) {
        return detalleVentaDAO.buscarDetalleVenta(id);
    }

    public boolean eliminarDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaDAO.eliminarDetalleVenta(detalleVenta);
    }

    public List<DetalleVenta> listarDetalleVentas() {
        return detalleVentaDAO.listarDetalleVentas();
    }

    
    
}
