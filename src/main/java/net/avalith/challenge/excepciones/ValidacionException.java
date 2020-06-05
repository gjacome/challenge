package net.avalith.challenge.excepciones;

/**
 * Validación utilizada en las validaciones de reglas de negocio de la aplicacion
 * @author Administrador
 */
public class ValidacionException extends Exception {
    
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
    
    public ValidacionException(String mensaje, Exception ex) {
        super(mensaje, ex);
    }
        
}
