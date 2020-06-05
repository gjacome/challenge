package net.avalith.challenge.service;

import java.util.List;
import java.util.stream.Collectors;
import net.avalith.challenge.modelos.Usuario;
import net.avalith.challenge.modelos.enumeraciones.EnumActivoInactivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import net.avalith.challenge.dao.UsuarioDAO;

/**
 * Metodo que administra las reglas de negocio de los votos
 *
 * @author Administrador
 */
@Service
public class SeguridadService implements UserDetailsService {

    /**
     * Repositorio de usuario
     */
    @Autowired
    private UsuarioDAO usuarioDAO;

    /**
     * Metodo que devuelve los detalles del usuario utilizado por spring
     * security
     *
     * @param nombre nombre del usuario
     * @return detalle del usuario
     * @throws UsernameNotFoundException es lanzada cuando el usuario no es
     * encontrado
     */
    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioDAO.obtenerUsuario(nombre);

        if (usuario == null) {
            throw new UsernameNotFoundException("Error en el login: no existe el usuario ingresado");
        }

        List<GrantedAuthority> authorities = usuario.getUsuarioPerfilList()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getPerfil().getNombre()))
                .collect(Collectors.toList());

        return new User(usuario.getUsername(), usuario.getPassword(), (usuario.getEstado() == EnumActivoInactivo.ACT),
                true, true, true, authorities);
    }

    /**
     * Metodo publico que permite buscar usuario por su nombre
     * @param nombre nombre del usuario
     * @return usuario
     */
    public Usuario findByUsername(String nombre) {
        return this.usuarioDAO.obtenerUsuario(nombre);
    }
}
