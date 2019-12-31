/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Perteneceficha;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Felipe
 */
@Local
public interface IPertenecefichaDAO {
    public void insertar(Perteneceficha perteneceficha) throws Exception;    
    public void modificar(Perteneceficha perteneceficha) throws Exception;
    public void eliminar(Perteneceficha perteneceficha) throws Exception;
    public Perteneceficha consultarPorAprendiz(Long documento) throws Exception;
    public Perteneceficha consultarPorIds(Long documento, int ficha) throws Exception;
    public List<Perteneceficha> consultar() throws Exception;
}
