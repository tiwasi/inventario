/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.DetalleEntradaDAO;
import com.inventario.entidades.Detalleentrada;
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

    public boolean insertarDetalleentrada(Detalleentrada dedao) {
        return detalleEntradaDAO.insertarDetalleentrada(dedao);
    }

    public boolean actualizarDetalleentrada(Detalleentrada dedao) {
        return detalleEntradaDAO.actualizarDetalleentrada(dedao);
    }

    public Detalleentrada buscarDetalleentrada(int id) {
        return detalleEntradaDAO.buscarDetalleentrada(id);
    }

    public boolean eliminarDetalleentrada(Detalleentrada dedao) {
        return detalleEntradaDAO.eliminarDetalleentrada(dedao);
    }

    public List<Detalleentrada> listarDetalleentradas() {
        return detalleEntradaDAO.listarDetalleentradas();
    }
    
}
