/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.persistencia;

import co.edu.sena.sael.modelo.ConfigCorreo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author g2
 */
@Local
public interface IConfigCorreoDAO {
    public void modificar(ConfigCorreo configCorreo) throws Exception;
    public ConfigCorreo consultarPorId(int idCorreo) throws Exception;
    public List<ConfigCorreo> consultar() throws Exception;
}
