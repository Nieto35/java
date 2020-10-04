/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Seguimiento;
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
public class SeguimientoDAO implements ISeguimientoDAO{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Seguimiento seguimiento) throws Exception {
        try {
            entityManager.persist(seguimiento);
        } catch (RuntimeException e) {
            throw e;
        }
    
    }

    @Override
    public void modificar(Seguimiento seguimiento) throws Exception {
       try {
            entityManager.merge(seguimiento);
        } catch (RuntimeException e) {
            throw e;
        }
    
    }

    @Override
    public Seguimiento consultarPorId(int codigoseguimiento) throws Exception {
        try {
            return entityManager.find(Seguimiento.class, codigoseguimiento);
        } catch (RuntimeException e) {
            throw e;
        }
    
    }

    @Override
    public List<Seguimiento> consultar() throws Exception {
        try {
            Query query=entityManager.createNamedQuery("Seguimiento.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    
    }
 
    
}
