package net.avalith.challenge.dao;


import java.util.List;
import net.avalith.challenge.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Interface que permite el acceso a datos de la entidad Voto
 * @author Administrador
 */
public interface UsuarioDAO extends CrudRepository<Usuario, Long>{
    
    /**
     * Metodo que busca usuarios por nombre
     
     * @param username nombre del usuario
     * @return 
     */    
    @Query("select u from Usuario u where u.username = ?1 ")
    Usuario obtenerUsuario(@Param("username") String username);    
}
