/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.VentasDAO;
import com.inventario.entidades.Ventas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class SolicitudVentas {
    @Autowired
    VentasDAO ventasDAO;

    public boolean insertarVentas(Ventas ventas) {
        return ventasDAO.insertarVentas(ventas);
    }

    public boolean actualizarVentas(Ventas ventas) {
        return ventasDAO.actualizarVentas(ventas);
    }

    public Ventas buscarVentas(int id) {
        return ventasDAO.buscarVentas(id);
    }

    public boolean eliminarVentas(Ventas ventas) {
        return ventasDAO.eliminarVentas(ventas);
    }

    public List<Ventas> listarVentass() {
        return ventasDAO.listarVentass();
    }
    
    
}
