package net.avalith.challenge.modelos.enumeraciones;

/**
 * Enumeraciones que contiene las areas de voto
 * @author Administrador
 */
public enum EnumActivoInactivo {   
    
    ACT("Activo"),
    INA("Inactivo");

    private final String descripcion;
    
    /**
     * Constructor de la enumeracion
     * @param descripcion valor del atributo descripcion
     */
    private EnumActivoInactivo(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo que obtiene el atributo fecha de descripcion
     * @return valor de atributo
     */
    public String getDescripcion() {
        return descripcion;
    }
    
}
