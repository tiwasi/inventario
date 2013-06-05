/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.MovimientosDAO;
import com.inventario.entidades.Movimientos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioMovimientos {
    @Autowired
    MovimientosDAO movimientosDAO;

    public boolean insertarMovimientos(Movimientos movimientos) {
        return movimientosDAO.insertarMovimientos(movimientos);
    }

    public boolean actualizarMovimientos(Movimientos movimientos) {
        return movimientosDAO.actualizarMovimientos(movimientos);
    }

    public Movimientos buscarMovimientos(int id) {
        return movimientosDAO.buscarMovimientos(id);
    }

    public boolean eliminarMovimientos(Movimientos movimientos) {
        return movimientosDAO.eliminarMovimientos(movimientos);
    }

    public List<Movimientos> listarMovimientoss() {
        return movimientosDAO.listarMovimientoss();
    }
    
    
    
}
