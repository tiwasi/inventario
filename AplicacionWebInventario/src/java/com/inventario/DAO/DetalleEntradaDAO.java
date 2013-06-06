/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.DetalleEntrada;
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
public class DetalleEntradaDAO extends HibernateDaoSupport{
    @Autowired
    public DetalleEntradaDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public DetalleEntradaDAO() {
    }
    public boolean insertarDetalleEntrada(DetalleEntrada detalleEntrada){
        try {
            getHibernateTemplate().save(detalleEntrada);
            //getHibernateTemplate().saveOrUpdate(detalleEntrada);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleEntrada", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarDetalleEntrada(DetalleEntrada detalleEntrada){
        try {
            getHibernateTemplate().update(detalleEntrada);
           // getHibernateTemplate().saveOrUpdate(detalleEntrada);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleEntrada", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public DetalleEntrada buscarDetalleEntrada(int id){
        try {
            return getHibernateTemplate().get(DetalleEntrada.class, id);
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar detalleEntrada", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public boolean eliminarDetalleEntrada(DetalleEntrada detalleEntrada){
        try {
            getHibernateTemplate().delete(detalleEntrada);
            return true;
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar detalleEntrada", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<DetalleEntrada> listarDetalleEntradas(){
        List<DetalleEntrada> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("DetalleEntrada.findAll");
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar DetalleEntradas", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }  
}
