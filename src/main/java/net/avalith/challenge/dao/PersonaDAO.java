package net.avalith.challenge.dao;


import java.util.List;
import net.avalith.challenge.modelos.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interface que permite el acceso a datos de la entidad Persona
 * @author Administrador
 */
public interface PersonaDAO extends JpaRepository <Persona, Long>{
    
    
    /**
     * Método que obtiene los candidatos al voto diferentes a la persona enviada como parametro
     * @param idPersona identificador de la persona
     * @return Lista de tipo Persona
     */
    @Query("select p from Persona p where p.id <> :idPersona")
    List<Persona> buscarCandidatos(@Param("idPersona") Long idPersona);
    
}
