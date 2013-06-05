/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.EntradaDAO;
import com.inventario.entidades.Entrada;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioEntrada {
    @Autowired
    EntradaDAO entradaDAO;

    public boolean insertarEntrada(Entrada entrada) {
        return entradaDAO.insertarEntrada(entrada);
    }

    public boolean actualizarEntrada(Entrada entrada) {
        return entradaDAO.actualizarEntrada(entrada);
    }

    public Entrada buscarEntrada(int id) {
        return entradaDAO.buscarEntrada(id);
    }

    public boolean eliminarEntrada(Entrada entrada) {
        return entradaDAO.eliminarEntrada(entrada);
    }

    public List<Entrada> listarEntradas() {
        return entradaDAO.listarEntradas();
    }
    
    
}
