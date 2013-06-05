/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Categoria;
import java.util.List;
//import javax.swing.JOptionPane;
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
public class CategoriaDAO extends HibernateDaoSupport{
     @Autowired
    public CategoriaDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public CategoriaDAO() {
    }
    public boolean insertarCategoria(Categoria categoria){
        try {
            getHibernateTemplate().save(categoria);
            //getHibernateTemplate().saveOrUpdate(categoria);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar categoria", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarCategoria(Categoria categoria){
        try {
            getHibernateTemplate().update(categoria);
           // getHibernateTemplate().saveOrUpdate(categoria);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar categoria", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Categoria buscarCategoria(int id){
        try {
            return getHibernateTemplate().get(Categoria.class, id);
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar categoria", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al buscar en el DAO :" +e.getMessage());
        }
        return null;
    }
    public boolean eliminarCategoria(Categoria categoria){
        try {
            getHibernateTemplate().delete(categoria);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar categoria", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al eliminar en el DAO :" +e.getMessage());
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Categoria> listarCategorias(){
        List<Categoria> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Categoria.findAll");
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Categorias", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al Listar en el DAO :" +e.getMessage());
        }
        return lista;
    }  
}
