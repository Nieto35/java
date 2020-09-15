/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Coordinador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class CoordinadorDAO implements ICoordinadorDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void eliminar(Coordinador coordinador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Coordinador coordinador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Coordinador coordinador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Coordinador consultarPorId(Long documentocoordinador) throws Exception {
        try {
            return entityManager.find(Coordinador.class, documentocoordinador);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Coordinador> consultar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
