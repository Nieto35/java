/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Aprendiz;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Felipe
 */
@Stateless
public class AprendizDAO implements IAprendizDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Aprendiz aprendiz) throws Exception {
        try {
            entityManager.persist(aprendiz);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Aprendiz aprendiz) throws Exception {
        try {
            entityManager.merge(aprendiz);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Aprendiz aprendiz) throws Exception {
        try {
            entityManager.remove(aprendiz);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Aprendiz consultarPorId(Long documento) throws Exception {
        try {
            return entityManager.find(Aprendiz.class, documento);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Aprendiz> consultar() throws Exception {
        try {
            Query query=entityManager.createNamedQuery("Aprendiz.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
    
}
