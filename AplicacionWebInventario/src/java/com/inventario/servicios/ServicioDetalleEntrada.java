/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.DetalleEntradaDAO;
import com.inventario.entidades.DetalleEntrada;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioDetalleEntrada {
    @Autowired
    DetalleEntradaDAO detalleEntradaDAO;

    public boolean insertarDetalleEntrada(DetalleEntrada detalleEntrada) {
        return detalleEntradaDAO.insertarDetalleEntrada(detalleEntrada);
    }

    public boolean actualizarDetalleEntrada(DetalleEntrada detalleEntrada) {
        return detalleEntradaDAO.actualizarDetalleEntrada(detalleEntrada);
    }

    public DetalleEntrada buscarDetalleEntrada(int id) {
        return detalleEntradaDAO.buscarDetalleEntrada(id);
    }

    public boolean eliminarDetalleEntrada(DetalleEntrada detalleEntrada) {
        return detalleEntradaDAO.eliminarDetalleEntrada(detalleEntrada);
    }

    public List<DetalleEntrada> listarDetalleEntradas() {
        return detalleEntradaDAO.listarDetalleEntradas();
    }

   
    
}
