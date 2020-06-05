
package net.avalith.challenge.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.avalith.challenge.dto.ReporteDTO;
import net.avalith.challenge.excepciones.ValidacionException;
import net.avalith.challenge.modelos.Persona;
import net.avalith.challenge.modelos.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.avalith.challenge.dao.PersonaDAO;
import net.avalith.challenge.dao.ReporteDAO;

/**
 * Metodo que administra las reglas de negocio de los reportes
 * @author Administrador
 */
@Service
public class ReporteService {
    /**
     * Repositorio de Reportes
     */
    @Autowired
    private ReporteDAO reporteDAO;
    
    /**
     * Repositorio de persona
     */
    @Autowired
    private PersonaDAO personaDAO ;
    
    /**
     * Metodo que consulta los empleados con mas votos por mes
     * @return lista de arreglo de objetos
     */
    public List<ReporteDTO> obtenerEmpleadoDelMes(){
        List<ReporteDTO> resultado = new ArrayList<>();
        
        List<Object[]> reporte = this.reporteDAO.obtenerEmpleadoDelMes();
        if (reporte != null && reporte.size() >0) {
            reporte.forEach((Object[] fila) -> {
                resultado.add(new ReporteDTO(fila));
            });
        }
        
        return resultado;
    };
    
     /**
     * Metodo que consulta los empleados con mas votos por area
     * @return lista de arreglo de objetos
     */
    public List<ReporteDTO> obtenerEmpleadoPorArea(){
        List<ReporteDTO> resultado = new ArrayList<>();
        
        List<Object[]> reporte = this.reporteDAO.obtenerEmpleadoPorArea();
        if (reporte != null && reporte.size() >0) {
            reporte.forEach((Object[] fila) -> {
                resultado.add(new ReporteDTO(fila));
            });
        }
        
        return resultado;
    };
    
     /**
     * Metodo que obtiene la cantidad de empleados registrados
     * @return numero de empleados registrados
     */
    public Long obtenerNumeroEmpleadosRegistrados(){
        return this.personaDAO.count();
    }
}
