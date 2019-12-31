/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Perteneceficha;
import co.edu.sena.sael.modelo.PertenecefichaPK;
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
public class PertenecefichaDAO implements IPertenecefichaDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Perteneceficha perteneceficha) throws Exception {
        try {
            entityManager.persist(perteneceficha);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Perteneceficha perteneceficha) throws Exception {
        try {
            entityManager.merge(perteneceficha);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Perteneceficha perteneceficha) throws Exception {
        try {
            perteneceficha = entityManager.merge(perteneceficha);
            entityManager.remove(perteneceficha);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Perteneceficha consultarPorAprendiz(Long documento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Perteneceficha consultarPorIds(Long documento, int ficha) throws Exception {
        try {
            Query query = entityManager.createQuery("select p FROM Perteneceficha p WHERE p.pertenecefichaPK.documentoaprendiz = :fk_aprendiz AND p.pertenecefichaPK.numeroficha = :fk_ficha").setParameter("fk_aprendiz", documento).setParameter("fk_ficha", ficha);
            return (Perteneceficha) query.getSingleResult();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Perteneceficha> consultar() throws Exception {
        try {
            Query query = entityManager.createNamedQuery("Perteneceficha.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
    
    
}
