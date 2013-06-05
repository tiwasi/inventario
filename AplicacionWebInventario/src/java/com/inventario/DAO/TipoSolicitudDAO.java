/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Tiposolicitud;
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
public class TipoSolicitudDAO extends HibernateDaoSupport{
    @Autowired
    public TipoSolicitudDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public TipoSolicitudDAO() {
    }
    public boolean insertarTiposolicitud(Tiposolicitud tipoSolicitud){
        try {
            getHibernateTemplate().save(tipoSolicitud);
            //getHibernateTemplate().saveOrUpdate(tipoSolicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar tipoSolicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarTiposolicitud(Tiposolicitud tipoSolicitud){
        try {
            getHibernateTemplate().update(tipoSolicitud);
           // getHibernateTemplate().saveOrUpdate(tipoSolicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar tipoSolicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Tiposolicitud buscarTiposolicitud(int id){
        try {
            return getHibernateTemplate().get(Tiposolicitud.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar tipoSolicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarTiposolicitud(Tiposolicitud tipoSolicitud){
        try {
            getHibernateTemplate().delete(tipoSolicitud);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar tipoSolicitud", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Tiposolicitud> listarTiposolicituds(){
        List<Tiposolicitud> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Tiposolicitud.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Tiposolicituds", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
    
}
