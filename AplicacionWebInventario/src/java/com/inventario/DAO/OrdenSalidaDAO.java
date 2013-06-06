/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.OrdenSalida;
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
public class OrdenSalidaDAO extends HibernateDaoSupport{
    @Autowired
    public OrdenSalidaDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public OrdenSalidaDAO() {
    }
    public boolean insertarOrdenSalida(OrdenSalida detalleVenta){
        try {
            getHibernateTemplate().save(detalleVenta);
            //getHibernateTemplate().saveOrUpdate(detalleVenta);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleVenta", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarOrdenSalida(OrdenSalida detalleVenta){
        try {
            getHibernateTemplate().update(detalleVenta);
           // getHibernateTemplate().saveOrUpdate(detalleVenta);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleVenta", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public OrdenSalida buscarOrdenSalida(int id){
        try {
            return getHibernateTemplate().get(OrdenSalida.class, id);
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleVenta", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public boolean eliminarOrdenSalida(OrdenSalida detalleVenta){
        try {
            getHibernateTemplate().delete(detalleVenta);
            return true;
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar detalleVenta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<OrdenSalida> listarOrdenSalidas(){
        List<OrdenSalida> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("OrdenSalida.findAll");
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar OrdenSalidas", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
}
