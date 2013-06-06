/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.OrdenCompraDAO;
import com.inventario.entidades.OrdenCompra;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioOrdenCompra {
    @Autowired
    OrdenCompraDAO ordenCompraDAO;

    public boolean insertarOrdencompra(OrdenCompra ordencompra) {
        return ordenCompraDAO.insertarOrdencompra(ordencompra);
    }

    public boolean actualizarOrdencompra(OrdenCompra ordencompra) {
        return ordenCompraDAO.actualizarOrdencompra(ordencompra);
    }

    public OrdenCompra buscarOrdencompra(int id) {
        return ordenCompraDAO.buscarOrdencompra(id);
    }

    public boolean eliminarOrdencompra(OrdenCompra ordencompra) {
        return ordenCompraDAO.eliminarOrdencompra(ordencompra);
    }

    public List<OrdenCompra> listarOrdencompras() {
        return ordenCompraDAO.listarOrdencompras();
    }
    
    
}
