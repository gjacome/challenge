package net.avalith.challenge.rest;

import com.google.gson.Gson;
import java.util.List;
import net.avalith.challenge.dto.ReporteDTO;
import net.avalith.challenge.excepciones.ValidacionException;
import net.avalith.challenge.modelos.Persona;
import net.avalith.challenge.modelos.Voto;
import net.avalith.challenge.modelos.enumeraciones.EnumAreaVoto;
import net.avalith.challenge.service.ReporteService;
import net.avalith.challenge.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Servicio Rest para los Votos
 * @author Administrador
 */
@RequestMapping("/api")
@RestController()
public class ChallengeRest {
    /**
     * Clase de negocio de Votos
     */
    @Autowired
    private VotoService votoService;
    
    /**
     * Clase de negocio de Votos
     */
    @Autowired
    private ReporteService reporteService;
    
    /**
     * Utilitario JSON
     */
    @Autowired
    private Gson gson;
    
    /**
     * Metodo que registra un voto validando las reglas de negocio
     * @param voto información a ser registada
     * @return objeto de tipo ResponseEntity
     */
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @PostMapping("/registrarVoto")
    public ResponseEntity registrarVoto(@Validated @RequestBody Voto voto){
        ResponseEntity<String> respuesta;
        try {
            if (voto.getAreaVoto() ==  null) {
            voto.setAreaVoto(EnumAreaVoto.OTH);
            }
            this.votoService.registrarVoto(voto);
            respuesta = new ResponseEntity<>("Voto registrado existosamente", HttpStatus.OK);
        } catch (ValidacionException ve) {
           respuesta = new ResponseEntity<>(ve.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }  catch (Exception e) {
           respuesta = new ResponseEntity<>("Error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }
    
    /**
     * Método que obtiene los candidatos al voto diferentes a la persona enviada como parametro
     * @param idPersona identificador de la persona
     * @return objeto de tipo ResponseEntity
     */
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("/buscarCandidatos/{idPersona}")
    public ResponseEntity<String> buscarCandidatos(@PathVariable Long idPersona) {
        ResponseEntity<String> respueta;
        try {
            List<Persona> candidatos = this.votoService.buscarCandidatos(idPersona);
            respueta = new ResponseEntity<>(gson.toJson(candidatos), HttpStatus.OK);
        } catch (ValidacionException ve) {
           respueta = new ResponseEntity<>(ve.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }  catch (Exception e) {
           respueta = new ResponseEntity<>("Error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respueta;
    }
    
    /**
     * Método que obtiene los candidatos al voto diferentes a la persona enviada como parametro
     * @return objeto de tipo ResponseEntity
     */
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/obtenerEmpleadoDelMes")
    public ResponseEntity<String> obtenerEmpleadoDelMes() {
        ResponseEntity<String> respueta;
        try {
            List<ReporteDTO> empleadoMes = this.reporteService.obtenerEmpleadoDelMes();
            respueta = new ResponseEntity<>(gson.toJson(empleadoMes), HttpStatus.OK);
        }  catch (Exception e) {
           respueta = new ResponseEntity<>("Error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respueta;
    }
    
    /**
     * Método que obtiene los candidatos al voto diferentes a la persona enviada como parametro
     * @return objeto de tipo ResponseEntity
     */
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/obtenerEmpleadoPorArea")
    public ResponseEntity<String> obtenerEmpleadoPorArea() {
        ResponseEntity<String> respueta;
        try {
            List<ReporteDTO> empleadArea = this.reporteService.obtenerEmpleadoPorArea();
            respueta = new ResponseEntity<>(gson.toJson(empleadArea), HttpStatus.OK);
        }  catch (Exception e) {
           respueta = new ResponseEntity<>("Error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respueta;
    }
    
    /**
     * Método que obtiene los candidatos al voto diferentes a la persona enviada como parametro
     * @return objeto de tipo ResponseEntity
     */
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/obtenerNumeroEmpleadosRegistrados")
    public ResponseEntity<String> obtenerNumeroEmpleadosRegistrados() {
        ResponseEntity<String> respueta;
        try {
            Long cantidad = this.reporteService.obtenerNumeroEmpleadosRegistrados();
            respueta = new ResponseEntity<>("Empleados registrados: " + cantidad.toString(), HttpStatus.OK);
        }  catch (Exception e) {
           respueta = new ResponseEntity<>("Error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respueta;
    }
    
}
