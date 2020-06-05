package net.avalith.challenge.modelos.enumeraciones;

/**
 * Enumeraciones que contiene las areas de voto
 * @author Administrador
 */
public enum EnumAreaVoto {   
    
    TPL("Technical Player"),
    TRF("Technical Referent"),
    KPL("Key Player"),    
    CST("Client Satisfacion"),
    MOT("Motivation"),
    FUN("Fun"),
    OTH("Other");
    

    private final String descripcion;
    
    /**
     * Constructor de la enumeracion
     * @param descripcion valor del atributo descripcion
     */
    private EnumAreaVoto(String descripcion) {
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
