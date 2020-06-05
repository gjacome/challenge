
package net.avalith.challenge.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import net.avalith.challenge.modelos.enumeraciones.EnumAreaVoto;

/**
 * Clase que mapea la tabla VOTO, en donde se almacena los votos de los empleados
 * @author Administrador
 */
@Entity
@Table(name = "voto",  schema = "challenge")
public class Voto extends Auditoria implements Serializable {       
    /**
     * Identificador del registro
     */
    @Id
    @GeneratedValue(generator = "voto_generador")
    @SequenceGenerator(
            name = "voto_generador",
            sequenceName = "voto_sequence",
            initialValue = 1
    )
    private Long id;    
    
    /**
     * Identificador de la persona que voto
     */
    @Column(columnDefinition = "id_persona_voto", nullable = false)
    private Long idPersonaVoto;
    
    /**
     * Identificador de la persona que recibio el voto
     */
    @Column(columnDefinition = "id_persona_candidato", nullable = false)
    private Long idPersonaCandidato;
    
    /**
     * Fecha del voto
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false)    
    private Date fecha;
    /**
     * Area de Voto
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "area_voto")
    private EnumAreaVoto areaVoto;
    
    /**
     * Detalle de otra area
     */
    @Column(name = "detalle_otro")
    private String detalleOtro;
    
//     /**
//     * Persona que realizo el voto
//     */
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_persona_voto", nullable = false)
//    @JsonIgnore   
//    private Persona personaVoto;
//    
//    /**
//     * Persona que recibio el voto
//     */
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_persona_candidato", nullable = false)
//    @JsonIgnore   
//    private Persona personaCandidato;

    /**
     * Metodo que obtiene el atributo id
     * @return valor de atributo
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que asigna un valor al atributo id
     * @param id valor a ser asignado
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene el atributo idPersonaVoto
     * @return valor de atributo
     */
    public Long getIdPersonaVoto() {
        return idPersonaVoto;
    }

    /**
     * Metodo que asigna un valor al atributo idPersonaVoto
     * @param idPersonaVoto valor a ser asignado
     */
    public void setIdPersonaVoto(Long idPersonaVoto) {
        this.idPersonaVoto = idPersonaVoto;
    }

    /**
     * Metodo que obtiene el atributo idPersonaCandidato
     * @return valor de atributo
     */
    public Long getIdPersonaCandidato() {
        return idPersonaCandidato;
    }

    /**
     * Metodo que asigna un valor al atributo idPersonaCandidato
     * @param idPersonaCandidato valor a ser asignado
     */
    public void setIdPersonaCandidato(Long idPersonaCandidato) {
        this.idPersonaCandidato = idPersonaCandidato;
    }

    /**
     * Metodo que obtiene el atributo fecha
     * @return valor de atributo
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Metodo que asigna un valor al atributo fecha
     * @param fecha valor a ser asignado
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo que obtiene el atributo areaVoto
     * @return valor de atributo
     */
    public EnumAreaVoto getAreaVoto() {
        return areaVoto;
    }

    /**
     * Metodo que asigna un valor al atributo areaVoto
     * @param areaVoto valor a ser asignado
     */
    public void setAreaVoto(EnumAreaVoto areaVoto) {
        this.areaVoto = areaVoto;
    }

    /**
     * Metodo que obtiene el atributo detalleOtro
     * @return valor de atributo
     */
    public String getDetalleOtro() {
        return detalleOtro;
    }

    /**
     * Metodo que asigna un valor al atributo detalleOtro
     * @param detalleOtro valor a ser asignado
     */
    public void setDetalleOtro(String detalleOtro) {
        this.detalleOtro = detalleOtro;
    }

//    /**
//     * Metodo que obtiene el atributo personaVoto
//     * @return valor de atributo
//     */
//    public Persona getPersonaVoto() {
//        return personaVoto;
//    }
//
//    /**
//     * Metodo que asigna un valor al atributo personaVoto
//     * @param personaVoto valor a ser asignado
//     */
//    public void setPersonaVoto(Persona personaVoto) {
//        this.personaVoto = personaVoto;
//    }
//    
//    /**
//     * Metodo que obtiene el atributo personaCandidato
//     * @return valor de atributo
//     */
//    public Persona getPersonaCandidato() {
//        return personaCandidato;
//    }
//
//    /**
//     * Metodo que asigna un valor al atributo personaCandidato
//     * @param personaCandidato valor a ser asignado
//     */
//    public void setPersonaCandidato(Persona personaCandidato) {
//        this.personaCandidato = personaCandidato;
//    }
////    

    public Voto() {
    }

    public Voto(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voto)) {
            return false;
        }
        Voto other = (Voto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.avalith.challenge.modelos.Voto[ id=" + id + " ]";
    }
    
    
    
}
