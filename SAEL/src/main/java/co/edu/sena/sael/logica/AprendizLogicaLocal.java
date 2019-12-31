/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Aprendiz;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author Felipe
 */
@Local
public interface AprendizLogicaLocal {
    public void registrar(Aprendiz aprendiz) throws Exception;
    public void modificar(Aprendiz aprendiz) throws Exception;
    public void eliminar(Aprendiz aprendiz) throws Exception;
    public Aprendiz consultarPorId(Long documentoaprendiz) throws Exception;
    public List<Aprendiz> consultar() throws Exception;
    public Map importarAprendices(String archivo) throws Exception;
}
