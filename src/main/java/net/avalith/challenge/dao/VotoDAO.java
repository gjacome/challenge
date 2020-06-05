package net.avalith.challenge.dao;


import java.util.List;
import net.avalith.challenge.modelos.Voto;
import net.avalith.challenge.modelos.enumeraciones.EnumAreaVoto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Interface que permite el acceso a datos de la entidad Voto
 * @author Administrador
 */
public interface VotoDAO extends CrudRepository<Voto, Long>{
    
    /**
     * Metodo que permite buscar votos por los siguientes criterios
     * @param idPersonaVoto identificador de la persona que voto
     * @param idPersonaCandidato identificador de la persona que recibio el voto
     * @param areaVoto area del voto
     * @param mes mes del voto
     * @param anio anio del voto
     * @return 
     */
    @Query("select      v from Voto v "
            + "where    v.idPersonaVoto = ?1 "
            + "and      v.idPersonaCandidato = ?2 "
            + "and      v.areaVoto = ?3 "
            + "and      extract(month from v.fecha) = ?4 "
            + "and      extract(year from v.fecha) = ?5 ")
    List<Voto> validarVotoFecha(@Param("idPersonaVoto") Long idPersonaVoto,
            @Param("idPersonaCandidato") Long idPersonaCandidato, 
            @Param("areaVoto") EnumAreaVoto areaVoto,
            @Param("mes") Integer mes, 
            @Param("anio") Integer anio);    
}
