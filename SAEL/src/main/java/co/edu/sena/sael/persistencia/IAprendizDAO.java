/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.Aprendiz;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Felipe
 */
@Local
public interface IAprendizDAO {
    public void insertar(Aprendiz aprendiz) throws Exception;    
    public void modificar(Aprendiz aprendiz) throws Exception;
    public void eliminar(Aprendiz aprendiz) throws Exception;
    public Aprendiz consultarPorId(Long documento) throws Exception;
    public List<Aprendiz> consultar() throws Exception;
}
