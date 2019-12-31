/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Instructor;
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
public class InstructorDAO implements IInstructorDAO{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insertar(Instructor instructor) throws Exception {
        try {
            entityManager.persist(instructor);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Instructor instructor) throws Exception {
        try {
            entityManager.merge(instructor);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Instructor instructor) throws Exception {
        try {
            entityManager.remove(instructor);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Instructor consultarPorId(Long documento) throws Exception {
        try {
            return entityManager.find(Instructor.class, documento);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Instructor> consultar() throws Exception {
        try {
            Query query=entityManager.createNamedQuery("Instructor.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
