/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Proveedor;
import java.util.List;
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
public class ProveedorDAO extends HibernateDaoSupport{
    @Autowired
    public ProveedorDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public ProveedorDAO() {
    }
    public boolean insertarProveedor(Proveedor proveedor){
        try {
            getHibernateTemplate().save(proveedor);
            //getHibernateTemplate().saveOrUpdate(proveedor);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar proveedor", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarProveedor(Proveedor proveedor){
        try {
            getHibernateTemplate().update(proveedor);
           // getHibernateTemplate().saveOrUpdate(proveedor);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar proveedor", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Proveedor buscarProveedor(int id){
        try {
            return getHibernateTemplate().get(Proveedor.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar proveedor", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarProveedor(Proveedor proveedor){
        try {
            getHibernateTemplate().delete(proveedor);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar proveedor", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Proveedor> listarProveedors(){
        List<Proveedor> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Proveedor.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Proveedors", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
    
}
