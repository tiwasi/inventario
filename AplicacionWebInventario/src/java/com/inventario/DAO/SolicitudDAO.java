/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Solicitud;
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
public class SolicitudDAO extends HibernateDaoSupport{
    @Autowired
    public SolicitudDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public SolicitudDAO() {
    }
    public boolean insertarSolicitud(Solicitud solicitud){
        try {
            getHibernateTemplate().save(solicitud);
            //getHibernateTemplate().saveOrUpdate(solicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar solicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarSolicitud(Solicitud solicitud){
        try {
            getHibernateTemplate().update(solicitud);
           // getHibernateTemplate().saveOrUpdate(solicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar solicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Solicitud buscarSolicitud(int id){
        try {
            return getHibernateTemplate().get(Solicitud.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar solicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarSolicitud(Solicitud solicitud){
        try {
            getHibernateTemplate().delete(solicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar solicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Solicitud> listarSolicituds(){
        List<Solicitud> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Solicitud.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Solicituds", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
    
}
