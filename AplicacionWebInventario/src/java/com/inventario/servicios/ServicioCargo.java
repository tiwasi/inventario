/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.CargoDAO;
import com.inventario.entidades.Cargo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioCargo {
    @Autowired
    CargoDAO cargoDAO;

    public boolean insertarCargo(Cargo cargo) {
        return cargoDAO.insertarCargo(cargo);
    }

    public boolean actualizarCargo(Cargo cargo) {
        return cargoDAO.actualizarCargo(cargo);
    }

    public Cargo buscarCargo(int id) {
        return cargoDAO.buscarCargo(id);
    }

    public boolean eliminarCargo(Cargo cargo) {
        return cargoDAO.eliminarCargo(cargo);
    }

    public List<Cargo> listarCargos() {
        return cargoDAO.listarCargos();
    }
    
    
}
