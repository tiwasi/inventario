/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.CategoriaDAO;
import com.inventario.entidades.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioCategoria {
    @Autowired
    CategoriaDAO categoriaDAO;

    public boolean insertarCategoria(Categoria categoria) {
        return categoriaDAO.insertarCategoria(categoria);
    }

    public boolean actualizarCategoria(Categoria categoria) {
        return categoriaDAO.actualizarCategoria(categoria);
    }

    public Categoria buscarCategoria(int id) {
        return categoriaDAO.buscarCategoria(id);
    }

    public boolean eliminarCategoria(Categoria categoria) {
        return categoriaDAO.eliminarCategoria(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaDAO.listarCategorias();
    }
    
    
}