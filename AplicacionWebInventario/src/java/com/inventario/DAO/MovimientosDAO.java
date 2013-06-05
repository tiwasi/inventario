/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Movimientos;
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
public class MovimientosDAO extends HibernateDaoSupport{
    @Autowired
    public MovimientosDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public MovimientosDAO() {
    }
    public boolean insertarMovimientos(Movimientos movimientos){
        try {
            getHibernateTemplate().save(movimientos);
            //getHibernateTemplate().saveOrUpdate(movimientos);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar movimientos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarMovimientos(Movimientos movimientos){
        try {
            getHibernateTemplate().update(movimientos);
           // getHibernateTemplate().saveOrUpdate(movimientos);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar movimientos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Movimientos buscarMovimientos(int id){
        try {
            return getHibernateTemplate().get(Movimientos.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar movimientos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarMovimientos(Movimientos movimientos){
        try {
            getHibernateTemplate().delete(movimientos);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar movimientos", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Movimientos> listarMovimientoss(){
        List<Movimientos> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Movimientos.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Movimientoss", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
    
}
