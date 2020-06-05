
package net.avalith.challenge.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.avalith.challenge.excepciones.ValidacionException;
import net.avalith.challenge.modelos.Persona;
import net.avalith.challenge.modelos.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.avalith.challenge.dao.PersonaDAO;
import net.avalith.challenge.dao.VotoDAO;

/**
 * Metodo que administra las reglas de negocio de los votos
 * @author Administrador
 */
@Service
public class VotoService {
    /**
     * Repositorio de voto
     */
    @Autowired
    private VotoDAO votoDAO;
    
    /**
     * Repositorio de persona
     */
    @Autowired
    private PersonaDAO personaDAO ;
    
    /**
     * Metodo que registra un voto validando las reglas de negocio
     * @param voto información a ser registada
     * @throws ValidacionException es lanzada cuando no se cumplen las reglas de negocio
     */
    public void registrarVoto(Voto voto) throws ValidacionException {
        try {
            if (voto.getFecha() == null) {
                voto.setFecha(new Date());
            }
            
            Calendar calendar = Calendar.getInstance(Locale.forLanguageTag("es-Ec"));
            calendar.setTime(voto.getFecha());
            List<Voto> votosExistentes = 
                    this.votoDAO.validarVotoFecha(
                            voto.getIdPersonaVoto(),
                            voto.getIdPersonaCandidato(),
                            voto.getAreaVoto(),
                            calendar.get(Calendar.MONTH)+1,
                            calendar.get(Calendar.YEAR));
            
            if (votosExistentes != null && votosExistentes.size() > 0) {
                throw new ValidacionException(
                        "Usted ya ha registrado un voto con el empleado y area seleccionados en este mes");
            } 
            
            this.votoDAO.save(voto);
            
        } catch (ValidacionException ve) {
            throw ve;
        } catch (Exception e) {
            throw new ValidacionException("Error inesperado al registrar el voto", e);
        }
    }
    
    /**
     * Método que obtiene los candidatos al voto diferentes a la persona enviada como parametro
     * @param idPersona identificador de la persona
     * @return Lista de tipo Persona
     * @throws ValidacionException es lanzada si existe un error no controlado
     */
    public List<Persona> buscarCandidatos(Long idPersona) throws ValidacionException {
        try {
            return this.personaDAO.buscarCandidatos(idPersona);
        } catch (Exception e) {
            throw new ValidacionException("Error inesperado al buscar los candidatos", e);
        }         
    }
}
