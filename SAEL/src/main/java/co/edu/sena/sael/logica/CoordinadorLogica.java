/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Coordinador;
import co.edu.sena.sael.persistencia.CoordinadorDAO;
import co.edu.sena.sael.persistencia.ICoordinadorDAO;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DILOVE
 */
@Stateless
public class CoordinadorLogica implements CoordinadorLogicaLocal {
    
    @EJB
    private ICoordinadorDAO coordinadorDAO;

    @Override
    public void registrar(Coordinador coordinador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Coordinador coordinado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Coordinador coordinado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Coordinador consultarPorId(Long documentocoordinador) throws Exception {
        if(documentocoordinador==null || documentocoordinador==0){
            throw new Exception("La identificación es obligatoria!");
        }
        
        return coordinadorDAO.consultarPorId(documentocoordinador);
    }
   

    @Override
    public List<Coordinador> consultar() throws Exception {
       return coordinadorDAO.consultar();  
    }

    @Override
    public Map importarCoordinadores(String archivo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

    