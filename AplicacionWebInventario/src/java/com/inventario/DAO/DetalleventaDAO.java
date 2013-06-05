/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Detalleventa;
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
public class DetalleventaDAO extends HibernateDaoSupport{
    @Autowired
    public DetalleventaDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public DetalleventaDAO() {
    }
    public boolean insertarDetalleventa(Detalleventa detalleventa){
        try {
            getHibernateTemplate().save(detalleventa);
            //getHibernateTemplate().saveOrUpdate(detalleventa);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleventa", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarDetalleventa(Detalleventa detalleventa){
        try {
            getHibernateTemplate().update(detalleventa);
           // getHibernateTemplate().saveOrUpdate(detalleventa);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleventa", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Detalleventa buscarDetalleventa(int id){
        try {
            return getHibernateTemplate().get(Detalleventa.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleventa", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarDetalleventa(Detalleventa detalleventa){
        try {
            getHibernateTemplate().delete(detalleventa);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar detalleventa", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Detalleventa> listarDetalleventas(){
        List<Detalleventa> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Detalleventa.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Detalleventas", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
}
