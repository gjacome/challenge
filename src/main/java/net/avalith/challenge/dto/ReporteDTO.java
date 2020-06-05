package net.avalith.challenge.dto;

import java.io.Serializable;

/**
 * DTO utilizado para los reportes Critero / Empleado
 * @author Administrador
 */
public class ReporteDTO implements Serializable{
    /**
     * Criterio del reporte
     */
    private String criterio;
    /**
     * Empleado
     */
    private String empleado;
    
    /**
     * Constructor de la clase
     * @param datos informacion de inicializacion
     */
    public ReporteDTO(Object[] datos) {
        if (datos == null || datos.length < 2) {
            this.criterio = "";
            this.empleado = "";
        } else {
            this.criterio = (datos[0] == null) ? "" : datos[0].toString();
            this.empleado = (datos[1] == null) ? "" : datos[1].toString();
        }
        
    }

    /**
     * Metodo que obtiene el atributo criterio
     * @return valor de atributo
     */
    public String getCriterio() {
        return criterio;
    }

    /**
     * Metodo que asigna un valor al atributo criterio
     * @param criterio valor a ser asignado
     */
    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    /**
     * Metodo que obtiene el atributo empleado
     * @return valor de atributo
     */
    public String getEmpleado() {
        return empleado;
    }

    /**
     * Metodo que asigna un valor al atributo empleado
     * @param empleado valor a ser asignado
     */
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
    
    
}
