/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Entrada;
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
public class EntradaDAO extends HibernateDaoSupport{
    @Autowired
    public EntradaDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public EntradaDAO() {
    }
    public boolean insertarEntrada(Entrada entrada){
        try {
            getHibernateTemplate().save(entrada);
            //getHibernateTemplate().saveOrUpdate(entrada);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar entrada", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarEntrada(Entrada entrada){
        try {
            getHibernateTemplate().update(entrada);
           // getHibernateTemplate().saveOrUpdate(entrada);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar entrada", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Entrada buscarEntrada(int id){
        try {
            return getHibernateTemplate().get(Entrada.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar entrada", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarEntrada(Entrada entrada){
        try {
            getHibernateTemplate().delete(entrada);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar entrada", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Entrada> listarEntradas(){
        List<Entrada> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Entrada.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Entradas", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
}
