/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.DetalleSolicitud;
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
public class DetalleSolicitudDAO extends HibernateDaoSupport{
    @Autowired
    public DetalleSolicitudDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public DetalleSolicitudDAO() {
    }
    public boolean insertarDetalleSolicitud(DetalleSolicitud detalleSolicitud){
        try {
            getHibernateTemplate().save(detalleSolicitud);
            //getHibernateTemplate().saveOrUpdate(detalleSolicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleSolicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarDetalleSolicitud(DetalleSolicitud detalleSolicitud){
        try {
            getHibernateTemplate().update(detalleSolicitud);
           // getHibernateTemplate().saveOrUpdate(detalleSolicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleSolicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public DetalleSolicitud buscarDetalleSolicitud(int id){
        try {
            return getHibernateTemplate().get(DetalleSolicitud.class, id);
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleSolicitud", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public boolean eliminarDetalleSolicitud(DetalleSolicitud detalleSolicitud){
        try {
            getHibernateTemplate().delete(detalleSolicitud);
            return true;
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar detalleSolicitud", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<DetalleSolicitud> listarDetalleSolicituds(){
        List<DetalleSolicitud> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("DetalleSolicitud.findAll");
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar DetalleSolicituds", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }  
}
