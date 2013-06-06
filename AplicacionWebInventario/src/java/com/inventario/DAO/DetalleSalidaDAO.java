/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.DetalleSalida;
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
public class DetalleSalidaDAO extends HibernateDaoSupport{
    @Autowired
    public DetalleSalidaDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public DetalleSalidaDAO() {
    }
    public boolean insertarDetalleSalida(DetalleSalida detalleSalida){
        try {
            getHibernateTemplate().save(detalleSalida);
            //getHibernateTemplate().saveOrUpdate(detalleSalida);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleSalida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarDetalleSalida(DetalleSalida detalleSalida){
        try {
            getHibernateTemplate().update(detalleSalida);
           // getHibernateTemplate().saveOrUpdate(detalleSalida);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleSalida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public DetalleSalida buscarDetalleSalida(int id){
        try {
            return getHibernateTemplate().get(DetalleSalida.class, id);
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleSalida", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public boolean eliminarDetalleSalida(DetalleSalida detalleSalida){
        try {
            getHibernateTemplate().delete(detalleSalida);
            return true;
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar detalleSalida", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<DetalleSalida> listarDetalleSalidas(){
        List<DetalleSalida> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("DetalleSalida.findAll");
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar DetalleSalidas", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }  
}

