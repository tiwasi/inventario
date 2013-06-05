/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Ordensalida;
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
public class OrdensalidaDAO extends HibernateDaoSupport{
    @Autowired
    public OrdensalidaDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public OrdensalidaDAO() {
    }
    public boolean insertarOrdensalida(Ordensalida ordenSalida){
        try {
            getHibernateTemplate().save(ordenSalida);
            //getHibernateTemplate().saveOrUpdate(ordenSalida);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar ordenSalida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarOrdensalida(Ordensalida ordenSalida){
        try {
            getHibernateTemplate().update(ordenSalida);
           // getHibernateTemplate().saveOrUpdate(ordenSalida);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar ordenSalida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Ordensalida buscarOrdensalida(int id){
        try {
            return getHibernateTemplate().get(Ordensalida.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar ordenSalida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarOrdensalida(Ordensalida ordenSalida){
        try {
            getHibernateTemplate().delete(ordenSalida);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar ordenSalida", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Ordensalida> listarOrdensalidas(){
        List<Ordensalida> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Ordensalida.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Ordensalidas", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
    
}
