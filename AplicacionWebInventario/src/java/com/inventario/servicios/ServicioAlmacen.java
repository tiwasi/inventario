/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.AlmacenDAO;
import com.inventario.entidades.Almacen;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioAlmacen {
    @Autowired
    AlmacenDAO almacenDAO;

    public boolean insertarAlmacen(Almacen almacen) {
        return almacenDAO.insertarAlmacen(almacen);
    }

    public boolean actualizarAlmacen(Almacen almacen) {
        return almacenDAO.actualizarAlmacen(almacen);
    }

    public Almacen buscarAlmacen(int id) {
        return almacenDAO.buscarAlmacen(id);
    }

    public boolean eliminarAlmacen(Almacen almacen) {
        return almacenDAO.eliminarAlmacen(almacen);
    }

    public List<Almacen> listarAlmacens() {
        return almacenDAO.listarAlmacens();
    }
    
    
}
