/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.SalidaDAO;
import com.inventario.entidades.Salida;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lio
 */
@Repository
public class ServicioSalida {
    @Autowired
    SalidaDAO salidaDAO;

    public boolean insertarSalida(Salida salida) {
        return salidaDAO.insertarSalida(salida);
    }

    public boolean actualizarSalida(Salida salida) {
        return salidaDAO.actualizarSalida(salida);
    }

    public Salida buscarSalida(int id) {
        return salidaDAO.buscarSalida(id);
    }

    public boolean eliminarSalida(Salida salida) {
        return salidaDAO.eliminarSalida(salida);
    }

    public List<Salida> listarSalidas() {
        return salidaDAO.listarSalidas();
    }
    
    
}
