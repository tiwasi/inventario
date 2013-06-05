/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Ordencompra;
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
public class OrdenCompraDAO extends HibernateDaoSupport{
    @Autowired
    public OrdenCompraDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public OrdenCompraDAO() {
    }
    public boolean insertarOrdencompra(Ordencompra ordencompra){
        try {
            getHibernateTemplate().save(ordencompra);
            //getHibernateTemplate().saveOrUpdate(ordencompra);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar ordencompra", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarOrdencompra(Ordencompra ordencompra){
        try {
            getHibernateTemplate().update(ordencompra);
           // getHibernateTemplate().saveOrUpdate(ordencompra);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar ordencompra", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Ordencompra buscarOrdencompra(int id){
        try {
            return getHibernateTemplate().get(Ordencompra.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar ordencompra", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarOrdencompra(Ordencompra ordencompra){
        try {
            getHibernateTemplate().delete(ordencompra);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar ordencompra", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Ordencompra> listarOrdencompras(){
        List<Ordencompra> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Ordencompra.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Ordencompras", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
    
}
