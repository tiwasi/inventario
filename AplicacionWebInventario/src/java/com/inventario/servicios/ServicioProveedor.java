/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.ProveedorDAO;
import com.inventario.entidades.Proveedor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lio
 */
@Repository
public class ServicioProveedor {
    @Autowired
    ProveedorDAO proveedorDAO;

    public boolean insertarProveedor(Proveedor proveedor) {
        return proveedorDAO.insertarProveedor(proveedor);
    }

    public boolean actualizarProveedor(Proveedor proveedor) {
        return proveedorDAO.actualizarProveedor(proveedor);
    }

    public Proveedor buscarProveedor(int id) {
        return proveedorDAO.buscarProveedor(id);
    }

    public boolean eliminarProveedor(Proveedor proveedor) {
        return proveedorDAO.eliminarProveedor(proveedor);
    }

    public List<Proveedor> listarProveedors() {
        return proveedorDAO.listarProveedors();
    }
    
    
}
