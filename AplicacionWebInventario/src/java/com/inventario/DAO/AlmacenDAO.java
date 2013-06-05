/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inventario.DAO;

import com.inventario.entidades.Almacen;
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
public class AlmacenDAO extends HibernateDaoSupport{
    @Autowired
    public AlmacenDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public AlmacenDAO() {
    }
    public boolean insertarAlmacen(Almacen almacen){
        try {
            getHibernateTemplate().save(almacen);
            //getHibernateTemplate().saveOrUpdate(almacen);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar almacen", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarAlmacen(Almacen almacen){
        try {
            getHibernateTemplate().update(almacen);
           // getHibernateTemplate().saveOrUpdate(almacen);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar almacen", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al actualizar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Almacen buscarAlmacen(int id){
        try {
            return getHibernateTemplate().get(Almacen.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar almacen", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarAlmacen(Almacen almacen){
        try {
            getHibernateTemplate().delete(almacen);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar almacen", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Almacen> listarAlmacens(){
        List<Almacen> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Almacen.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Almacens", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
}
