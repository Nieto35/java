/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Aprendiz;
import co.edu.sena.sael.modelo.Fichatitulacion;
import co.edu.sena.sael.modelo.Perteneceficha;
import co.edu.sena.sael.persistencia.IPertenecefichaDAO;
import co.edu.sena.sael.utils.Constantes;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Felipe
 */
@Stateless
public class PertenecefichaLogica implements PertenecefichaLogicaLocal {

    @EJB
    private IPertenecefichaDAO pertenecefichaDAO;
    @EJB
    private AprendizLogicaLocal aprendizLogica;
    @EJB
    private FichaTitulacionLogicaLocal fichaTitulacionLogica;
    
    

    @Override
    public void insertar(Perteneceficha perteneceficha) throws Exception {
        if (perteneceficha == null) {
            throw new Exception("PerteneceFicha es nulo");
        }
        
        if (perteneceficha.getAprendiz() == null) {
            throw new Exception("El Aprendiz de PerteneceFicha es nulo");
        }
        if (perteneceficha.getFichatitulacion() == null) {
            throw new Exception("La Ficha de PerteneceFicha es nula");
        }

        Aprendiz aprendiz = aprendizLogica.consultarPorId(perteneceficha.getPertenecefichaPK().getDocumentoaprendiz());
        Fichatitulacion fichatitulacion = fichaTitulacionLogica.consultarPorId(perteneceficha.getPertenecefichaPK().getNumeroficha());
        

        perteneceficha.setAprendiz(aprendiz);
        perteneceficha.setFichatitulacion(fichatitulacion);
        perteneceficha.setEstadoperteneceficha(perteneceficha.getEstadoperteneceficha());

        pertenecefichaDAO.insertar(perteneceficha);
    }

    @Override
    public void modificar(Perteneceficha perteneceficha) throws Exception {
        if (perteneceficha == null) {
            throw new Exception("PerteneceFicha es nulo");
        }
        
        if (perteneceficha.getAprendiz() == null) {
            throw new Exception("El Aprendiz de PerteneceFicha es nulo");
        }
        if (perteneceficha.getFichatitulacion() == null) {
            throw new Exception("La Ficha de PerteneceFicha es nula");
        }
        
        Aprendiz aprendiz = aprendizLogica.consultarPorId(perteneceficha.getPertenecefichaPK().getDocumentoaprendiz());
        Fichatitulacion fichatitulacion = fichaTitulacionLogica.consultarPorId(perteneceficha.getPertenecefichaPK().getNumeroficha());
        
        Perteneceficha perteneceficha1Existente = pertenecefichaDAO.consultarPorIds(aprendiz.getDocumentoaprendiz(), fichatitulacion.getNumeroficha());
        if (perteneceficha1Existente == null) {
            throw new Exception("El aprendiz no pertenece a la ficha o no existe");
        }                

        perteneceficha1Existente.setAprendiz(aprendiz);
        perteneceficha1Existente.setFichatitulacion(fichatitulacion);
        perteneceficha1Existente.setPertenecefichaPK(perteneceficha.getPertenecefichaPK());
        perteneceficha1Existente.setEstadoperteneceficha(perteneceficha.getEstadoperteneceficha());       

        pertenecefichaDAO.modificar(perteneceficha1Existente);
    }

    @Override
    public void eliminar(Perteneceficha perteneceficha) throws Exception {
        if (perteneceficha == null) {
            throw new Exception("Perteneceficha es nulo");
        }
        pertenecefichaDAO.eliminar(perteneceficha);
    }

    @Override
    public Perteneceficha consultarPorAprendiz(Long documento) throws Exception {
        if(documento == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        return pertenecefichaDAO.consultarPorAprendiz(documento);
    }

    @Override
    public Perteneceficha consultarPorIds(Long documento, int ficha) throws Exception {
        if(documento == 0 || ficha==0)
        {
            throw new Exception("El documento y/o el número de ficha son obligatorios");
        }
        
        return pertenecefichaDAO.consultarPorIds(documento, ficha);
    }

    @Override
    public List<Perteneceficha> consultar() throws Exception {
        return pertenecefichaDAO.consultar();
    }
    
    @Override
    public Perteneceficha consultarFichaActiva(Aprendiz aprendiz) throws Exception{
        if(aprendiz==null)
        {
            throw new Exception("El aprendiz es nulo!");
        }
        
        Perteneceficha pertenecefichaActiva=null;
        
        List<Perteneceficha> pertenecefichaCollection = (List<Perteneceficha>) aprendiz.getPertenecefichaCollection();
        for (Perteneceficha perteneceficha : pertenecefichaCollection) {
            if(Constantes.FICHA_ESTADO_ACTIVA.equals(perteneceficha.getEstadoperteneceficha()))
                pertenecefichaActiva=perteneceficha;
        }
        
        return pertenecefichaActiva;
    }
}
