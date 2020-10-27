/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.ConfigCorreo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author g2
 */
@Stateless
public class ConfigCorreoDAO implements IConfigCorreoDAO{
    @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    public void modificar(ConfigCorreo configCorreo) throws Exception {
        try {
            entityManager.merge(configCorreo);
        } catch (RuntimeException e) {
            throw e;
        }
    }


    @Override
    public ConfigCorreo consultarPorId(int idCorreo) throws Exception {
        try {
            return entityManager.find(ConfigCorreo.class, idCorreo);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<ConfigCorreo> consultar() throws Exception {
        try {
            Query query=entityManager.createNamedQuery("ConfigCorreo.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    

}
