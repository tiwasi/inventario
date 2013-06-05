/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.OrdenSalidaDAO;
import com.inventario.entidades.Ordensalida;
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

    public boolean insertarOrdensalida(Ordensalida ordenSalida) {
        return ordenSalidaDAO.insertarOrdensalida(ordenSalida);
    }

    public boolean actualizarOrdensalida(Ordensalida ordenSalida) {
        return ordenSalidaDAO.actualizarOrdensalida(ordenSalida);
    }

    public Ordensalida buscarOrdensalida(int id) {
        return ordenSalidaDAO.buscarOrdensalida(id);
    }

    public boolean eliminarOrdensalida(Ordensalida ordenSalida) {
        return ordenSalidaDAO.eliminarOrdensalida(ordenSalida);
    }

    public List<Ordensalida> listarOrdensalidas() {
        return ordenSalidaDAO.listarOrdensalidas();
    }
    
    
}
