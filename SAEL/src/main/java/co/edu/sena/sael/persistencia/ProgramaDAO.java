/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Programa;
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
public class ProgramaDAO implements IProgramaDAO{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insertar(Programa programa) throws Exception {
        try {
            entityManager.persist(programa);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Programa programa) throws Exception {
        try {
            entityManager.merge(programa);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Programa programa) throws Exception {
        try {
            entityManager.remove(programa);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Programa consultarPorId(Integer codigoprograma) throws Exception {
        try {
            return entityManager.find(Programa.class, codigoprograma);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Programa> consultar() throws Exception {
        try {
            Query query=entityManager.createNamedQuery("Programa.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
