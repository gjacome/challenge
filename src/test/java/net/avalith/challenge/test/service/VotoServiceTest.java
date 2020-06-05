package net.avalith.challenge.test.service;

import java.util.List;
import net.avalith.challenge.modelos.Persona;
import net.avalith.challenge.modelos.Voto;
import net.avalith.challenge.modelos.enumeraciones.EnumAreaVoto;
import net.avalith.challenge.service.VotoService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test del servicio Voto
 * @author Administrador
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VotoServiceTest {
    
    /**
     * Servicio Voto
     */
    @Autowired
    private VotoService votoService;
    
    /**
     * Metodo que valida la consulta de candidatos
     * @throws Exception 
     */
    @Test
    public void consultarCandidatosTest() throws Exception {
        Long idPersona = 1L;
        List<Persona> candidatos = this.votoService.buscarCandidatos(idPersona);
        assertThat(candidatos).isNotEmpty();
    }
    
    /**
     * Metodo que valida el registro de votos
     * @throws Exception 
     */
    @Test
    public void registrarVotoTest() throws Exception {
        String error = "";
        Voto voto = new Voto();
        voto.setIdPersonaVoto(3L);
        voto.setIdPersonaCandidato(1L);
        voto.setAreaVoto(EnumAreaVoto.MOT);
        this.votoService.registrarVoto(voto);
        
    }
    
}
