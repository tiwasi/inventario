/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.PersonalDAO;
import com.inventario.entidades.Personal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lio
 */
@Repository
public class ServicioPersona {
    @Autowired
    PersonalDAO personalDAO;

    public boolean insertarPersonal(Personal personal) {
        return personalDAO.insertarPersonal(personal);
    }

    public boolean actualizarPersonal(Personal personal) {
        return personalDAO.actualizarPersonal(personal);
    }

    public Personal buscarPersonal(int id) {
        return personalDAO.buscarPersonal(id);
    }

    public boolean eliminarPersonal(Personal personal) {
        return personalDAO.eliminarPersonal(personal);
    }

    public List<Personal> listarPersonals() {
        return personalDAO.listarPersonals();
    }
    
    
    
}
