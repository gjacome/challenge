package net.avalith.challenge.dao;


import java.util.List;
import net.avalith.challenge.modelos.Voto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface que permite el acceso a datos de la entidad Persona
 * @author Administrador
 */
public interface ReporteDAO extends CrudRepository<Voto, Long>{
    
    /**
     * Metodo que consulta los empleados con mas votos por mes
     * @return lista de arreglo de objetos
     */
    @Query(value="select 	'Mes: ' || cast(c.mes as varchar) || ' Año: ' || cast(c.anio as varchar) as criterio, " +
            "		(select 	(p.nombre || ' - Votos: ' || cast(count(*) as varchar)) " +
            "		from		challenge.voto v, challenge.persona p " +
            "		where		v.id_persona_candidato = p.id " +
            "		and		extract(year from v.fecha) = c.anio and extract(month from v.fecha) = c.mes " +
            "		group by 	p.nombre " +
            "		order by	count(*) desc " +
            "		limit 1) as empleado " +
            "from " +
            "	(select 	extract(year from v.fecha) as anio, extract(month from v.fecha) as mes " +
            "	from		challenge.voto v " +
            "	group by 	extract(year from v.fecha), extract(month from v.fecha)) as c ", nativeQuery = true)
    List<Object[]> obtenerEmpleadoDelMes();
    
    /**
     * Metodo que consulta los empleados con mas votos por area
     * @return lista de arreglo de objetos
     */
    @Query(value="select 		c.area_voto as criterio, " +
                    "		(select 	(p.nombre || ' - Votos: ' || cast(count(*) as varchar)) " +
                    "		from		challenge.voto v, challenge.persona p " +
                    "		where		v.id_persona_candidato = p.id " +
                    "		and		v.area_voto = c.area_voto " +
                    "		group by 	p.nombre " +
                    "		order by	count(*) desc " +
                    "		limit 1) as empleado " +
                    "from " +
                    "	(select 	v.area_voto " +
                    "	from		challenge.voto v " +
                    "	group by 	v.area_voto) as c", nativeQuery = true)
    List<Object[]> obtenerEmpleadoPorArea();
    
}
