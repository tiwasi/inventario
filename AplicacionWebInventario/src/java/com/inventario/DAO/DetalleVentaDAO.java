/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.DetalleVenta;
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
public class DetalleVentaDAO extends HibernateDaoSupport{
    @Autowired
    public DetalleVentaDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public DetalleVentaDAO() {
    }
    public boolean insertarDetalleVenta(DetalleVenta detalleVenta){
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
    public boolean actualizarDetalleVenta(DetalleVenta detalleVenta){
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
    public DetalleVenta buscarDetalleVenta(int id){
        try {
            return getHibernateTemplate().get(DetalleVenta.class, id);
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleVenta", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public boolean eliminarDetalleVenta(DetalleVenta detalleVenta){
        try {
            getHibernateTemplate().delete(detalleVenta);
            return true;
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar detalleVenta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<DetalleVenta> listarDetalleVentas(){
        List<DetalleVenta> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("DetalleVenta.findAll");
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar DetalleVentas", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}