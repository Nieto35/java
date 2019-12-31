/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;


import co.edu.sena.sael.modelo.Personal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author FELIPE
 */

@Stateless
public class PersonalDAO implements IPersonalDAO{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insertar(Personal personal) throws Exception {
        try {
            entityManager.persist(personal);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Personal personal) throws Exception {
        try {
            entityManager.merge(personal);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Personal personal) throws Exception {
        try {
            entityManager.remove(personal);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Personal consultarPorId(Long documento) throws Exception {
        try {
           return  entityManager.find(Personal.class, documento);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Personal> consultar() throws Exception {
        try {
            Query query=entityManager.createNamedQuery("Personal.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    
  
    
    
}
