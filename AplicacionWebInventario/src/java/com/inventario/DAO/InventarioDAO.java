/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Inventario;
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
public class InventarioDAO extends HibernateDaoSupport{
    @Autowired
    public InventarioDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public InventarioDAO() {
    }
    public boolean insertarInventario(Inventario inventario){
        try {
            getHibernateTemplate().save(inventario);
            //getHibernateTemplate().saveOrUpdate(inventario);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar inventario", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarInventario(Inventario inventario){
        try {
            getHibernateTemplate().update(inventario);
           // getHibernateTemplate().saveOrUpdate(inventario);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar inventario", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Inventario buscarInventario(int id){
        try {
            return getHibernateTemplate().get(Inventario.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar inventario", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarInventario(Inventario inventario){
        try {
            getHibernateTemplate().delete(inventario);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar inventario", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Inventario> listarInventarios(){
        List<Inventario> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Inventario.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Inventarios", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
    
}
