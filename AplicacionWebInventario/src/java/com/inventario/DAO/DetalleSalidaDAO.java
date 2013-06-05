/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Detallesalida;
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
public class DetallesalidaDAO extends HibernateDaoSupport{
    @Autowired
    public DetallesalidaDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public DetallesalidaDAO() {
    }
    public boolean insertarDetallesalida(Detallesalida detallesalida){
        try {
            getHibernateTemplate().save(detallesalida);
            //getHibernateTemplate().saveOrUpdate(detallesalida);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detallesalida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarDetallesalida(Detallesalida detallesalida){
        try {
            getHibernateTemplate().update(detallesalida);
           // getHibernateTemplate().saveOrUpdate(detallesalida);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detallesalida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Detallesalida buscarDetallesalida(int id){
        try {
            return getHibernateTemplate().get(Detallesalida.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detallesalida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarDetallesalida(Detallesalida detallesalida){
        try {
            getHibernateTemplate().delete(detallesalida);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar detallesalida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Detallesalida> listarDetallesalidas(){
        List<Detallesalida> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Detallesalida.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Detallesalidas", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
}
