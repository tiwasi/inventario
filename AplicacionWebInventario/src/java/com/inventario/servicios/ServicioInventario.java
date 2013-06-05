/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.InventarioDAO;
import com.inventario.entidades.Inventario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioInventario {
    @Autowired
    InventarioDAO inventarioDAO;

    public boolean insertarInventario(Inventario inventario) {
        return inventarioDAO.insertarInventario(inventario);
    }

    public boolean actualizarInventario(Inventario inventario) {
        return inventarioDAO.actualizarInventario(inventario);
    }

    public Inventario buscarInventario(int id) {
        return inventarioDAO.buscarInventario(id);
    }

    public boolean eliminarInventario(Inventario inventario) {
        return inventarioDAO.eliminarInventario(inventario);
    }

    public List<Inventario> listarInventarios() {
        return inventarioDAO.listarInventarios();
    }
    
    
}
