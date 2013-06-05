/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Ventas;
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
public class VentasDAO extends HibernateDaoSupport{
    @Autowired
    public VentasDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public VentasDAO() {
    }
    public boolean insertarVentas(Ventas ventas){
        try {
            getHibernateTemplate().save(ventas);
            //getHibernateTemplate().saveOrUpdate(ventas);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar ventas", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarVentas(Ventas ventas){
        try {
            getHibernateTemplate().update(ventas);
           // getHibernateTemplate().saveOrUpdate(ventas);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar ventas", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Ventas buscarVentas(int id){
        try {
            return getHibernateTemplate().get(Ventas.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar ventas", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarVentas(Ventas ventas){
        try {
            getHibernateTemplate().delete(ventas);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar ventas", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Ventas> listarVentass(){
        List<Ventas> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Ventas.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Ventass", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
}
