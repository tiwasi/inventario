/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.DAO;

import com.inventario.entidades.Cargo;
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
public class CargoDAO extends HibernateDaoSupport{

    @Autowired
    public CargoDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public CargoDAO() {
    }
    public boolean insertarCargo(Cargo cargo){
        try {
            getHibernateTemplate().save(cargo);
            //getHibernateTemplate().saveOrUpdate(cargo);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar cargo", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public boolean actualizarCargo(Cargo cargo){
        try {
            getHibernateTemplate().update(cargo);
           // getHibernateTemplate().saveOrUpdate(cargo);
            return true;
        } catch (DataAccessException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar cargo", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al insertar en el DAO :" +e.getMessage());
        }
        return false;
    }
    public Cargo buscarCargo(int id){
        try {
            return getHibernateTemplate().get(Cargo.class, id);
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al insertar cargo", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public boolean eliminarCargo(Cargo cargo){
        try {
            getHibernateTemplate().delete(cargo);
            return true;
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar cargo", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public List<Cargo> listarCargos(){
        List<Cargo> lista=null;
        try {
            lista= getHibernateTemplate().findByNamedQuery("Cargo.findAll");
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Listar Cargos", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }  
    
    
}
