/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Programarseguimiento;
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
public class ProgramarSeguimientoDAO implements IProgramarSeguimientoDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Programarseguimiento programarSeguimiento) throws Exception {
        try {
            entityManager.persist(programarSeguimiento);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Programarseguimiento programarSeguimiento) throws Exception {
        try {
            entityManager.merge(programarSeguimiento);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    

    @Override
    public Programarseguimiento consultarPorId(int id) throws Exception {
        try {
            return entityManager.find(Programarseguimiento.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Programarseguimiento> consultar() throws Exception {
        try {
            Query query=entityManager.createNamedQuery("Programarseguimiento.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
    
}
