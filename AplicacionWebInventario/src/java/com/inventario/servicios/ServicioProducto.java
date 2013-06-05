/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.ProductoDAO;
import com.inventario.entidades.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lio
 */
@Repository
public class ServicioProducto {
    @Autowired
    ProductoDAO productoDAO;

    public boolean insertarProducto(Producto producto) {
        return productoDAO.insertarProducto(producto);
    }

    public boolean actualizarProducto(Producto producto) {
        return productoDAO.actualizarProducto(producto);
    }

    public Producto buscarProducto(int id) {
        return productoDAO.buscarProducto(id);
    }

    public boolean eliminarProducto(Producto producto) {
        return productoDAO.eliminarProducto(producto);
    }

    public List<Producto> listarProductos() {
        return productoDAO.listarProductos();
    }
    
    
    
}
