/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Detallesolicitud;
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
public class DetallesolicitudDAO extends HibernateDaoSupport{
    @Autowired
    public DetallesolicitudDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public DetallesolicitudDAO() {
    }
    public boolean insertarDetallesolicitud(Detallesolicitud detallesolicitud){
        try {
            getHibernateTemplate().save(detallesolicitud);
            //getHibernateTemplate().saveOrUpdate(detallesolicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detallesolicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarDetallesolicitud(Detallesolicitud detallesolicitud){
        try {
            getHibernateTemplate().update(detallesolicitud);
           // getHibernateTemplate().saveOrUpdate(detallesolicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detallesolicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Detallesolicitud buscarDetallesolicitud(int id){
        try {
            return getHibernateTemplate().get(Detallesolicitud.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detallesolicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarDetallesolicitud(Detallesolicitud detallesolicitud){
        try {
            getHibernateTemplate().delete(detallesolicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar detallesolicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Detallesolicitud> listarDetallesolicituds(){
        List<Detallesolicitud> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Detallesolicitud.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Detallesolicituds", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
}
