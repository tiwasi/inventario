/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lio
 */
@Repository
public class ClienteDAO extends HibernateDaoSupport{
    @Autowired
    public ClienteDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public ClienteDAO() {
    }
    public boolean insertarCliente(Cliente cliente){
        try {
            getHibernateTemplate().save(cliente);
            //getHibernateTemplate().saveOrUpdate(cliente);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar cliente", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarCliente(Cliente cliente){
        try {
            getHibernateTemplate().update(cliente);
           // getHibernateTemplate().saveOrUpdate(cliente);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar cliente", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Cliente buscarCliente(int id){
        try {
            return getHibernateTemplate().get(Cliente.class, id);
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar cliente", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public boolean eliminarCliente(Cliente cliente){
        try {
            getHibernateTemplate().delete(cliente);
            return true;
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar cliente", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Cliente> listarClientes(){
        List<Cliente> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Cliente.findAll");
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Clientes", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }  
}
