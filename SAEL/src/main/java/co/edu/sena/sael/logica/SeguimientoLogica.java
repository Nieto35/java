/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.sael.logica;

import co.edu.sena.sael.modelo.Seguimiento;
import co.edu.sena.sael.persistencia.ISeguimientoDAO;
import co.edu.sena.sael.persistencia.IFichaTitulacionDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Felipe
 */
@Stateless
public class SeguimientoLogica implements SeguimientoLogicaLocal {
    @EJB
    private ISeguimientoDAO seguimientoDAO;
    @EJB
    private IFichaTitulacionDAO fichaTitulacionDAO;
     

    @Override
    public void insertar(Seguimiento seguimiento) throws Exception {
        if (seguimiento == null) {
            throw new Exception("El seguimiento es nulo");
        }
        if (seguimiento.getFecha() == null) {
            throw new Exception("La fecha es nulo");
        }
        
        if (seguimiento.getHorainicio() == null) {
            throw new Exception("La hora de inicio es nulo");
        }
        if (seguimiento.getHorafin() == null) {
            throw new Exception("La hora de fin es nulo");
        }
        if (seguimiento.getNumeroficha() == null) {
            throw new Exception("La numero ficha es nulo");
        }
        seguimientoDAO.insertar(seguimiento);
    }

    @Override
    public void modificar(Seguimiento seguimiento) throws Exception {
        if (seguimiento == null) {
            throw new Exception("El seguimiento es nulo");
        }
        if (seguimiento.getFecha() == null) {
            throw new Exception("La fecha es nulo");
        }
        
        if (seguimiento.getHorainicio() == null) {
            throw new Exception("La hora de inicio es nulo");
        }
        if (seguimiento.getHorafin() == null) {
            throw new Exception("La hora de fin es nulo");
        }
        if (seguimiento.getNumeroficha() == null) {
            throw new Exception("La numero ficha es nulo");
        }

        seguimientoDAO.modificar(seguimiento);
    }


    @Override
    public Seguimiento consultarPorId(int codigoseguimiento) throws Exception {
        if ( codigoseguimiento == 0) {
            throw new Exception("La Identificación es obligatoria");
        }

        return seguimientoDAO.consultarPorId(codigoseguimiento);
    }

    @Override
    public List<Seguimiento> consultar() throws Exception {
        return seguimientoDAO.consultar();
    }

}
