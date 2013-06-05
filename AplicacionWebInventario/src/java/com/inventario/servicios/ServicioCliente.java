/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.servicios;

import com.inventario.DAO.ClienteDAO;
import com.inventario.entidades.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lio
 */
@Service
public class ServicioCliente {
    @Autowired
    ClienteDAO clienteDAO;

    public boolean insertarCliente(Cliente cliente) {
        return clienteDAO.insertarCliente(cliente);
    }

    public boolean actualizarCliente(Cliente cliente) {
        return clienteDAO.actualizarCliente(cliente);
    }

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarCliente(id);
    }

    public boolean eliminarCliente(Cliente cliente) {
        return clienteDAO.eliminarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }
    
    
}
