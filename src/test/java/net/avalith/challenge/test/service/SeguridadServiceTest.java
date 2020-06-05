package net.avalith.challenge.test.service;

import net.avalith.challenge.modelos.Usuario;
import net.avalith.challenge.service.SeguridadService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test del servicio Seguridad
 * @author Administrador
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SeguridadServiceTest {
    
    /**
     * Servicio seguridad
     */
    @Autowired
    private SeguridadService seguridadService;
    
    /**
     * Metodo que valida la carga de credenciales de un usuario
     * @throws Exception 
     */
    @Test
    public void loadUserByUsernameTest() throws Exception {
        String usuario = "gjacome";
        UserDetails respuesta = this.seguridadService.loadUserByUsername(usuario);
        assertThat(respuesta).isNotNull();
    }
    
    /**
     * Metodo que valida la busqueda de un usuario por su username
     * @throws Exception 
     */
    @Test
    public void findByUsernameTest() throws Exception {
        String usuario = "patmat";
        Usuario respuesta = this.seguridadService.findByUsername(usuario);
        assertThat(respuesta).isNotNull();
    }

    
}
