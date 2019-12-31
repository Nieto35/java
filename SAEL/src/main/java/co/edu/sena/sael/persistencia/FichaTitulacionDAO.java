/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Fichatitulacion;
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
public class FichaTitulacionDAO implements IFichaTitulacionDAO{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insertar(Fichatitulacion fichaTitulacion) throws Exception {
        try {
            entityManager.persist(fichaTitulacion);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Fichatitulacion fichaTitulacion) throws Exception {
        try {
            entityManager.merge(fichaTitulacion);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Fichatitulacion fichaTitulacion) throws Exception {
        try {
            entityManager.remove(fichaTitulacion);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Fichatitulacion consultarPorId(int ficha) throws Exception {
        try {
            return entityManager.find(Fichatitulacion.class, ficha);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Fichatitulacion> consultar() throws Exception {
        try {
            Query query=entityManager.createNamedQuery("Fichatitulacion.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Fichatitulacion> consultarDisponibles(Instructor instructor) throws Exception {
        try {
            Query query=entityManager.createQuery("Select f from Fichatitulacion f where f.numeroficha NOT IN (Select f.numeroficha from Fichatitulacion f, Instructor i where i.documentoinstructor = :documento and f.numeroficha=i.fichatitulacionCollection.numeroficha)")
                    .setParameter("documento", instructor.getDocumentoinstructor());
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Fichatitulacion> consultarAsignadas(Instructor instructor) throws Exception {
        try {
            Query query=entityManager.createQuery("Select f from Fichatitulacion f, Instructor i where i.documentoinstructor = :documento and f.numeroficha=i.fichatitulacionCollection.numeroficha")
                    .setParameter("documento", instructor.getDocumentoinstructor());
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
