
package net.avalith.challenge.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import net.avalith.challenge.modelos.enumeraciones.EnumActivoInactivo;

/**
 * Clase que mapea la tabla Persona, en donde se almacena los votos de los empleados
 * @author Administrador
 */
@Entity
@Table(name = "persona", schema = "challenge")
public class Persona implements Serializable {
    
    /**
     * Identificador del registro
     */
    @Id
    @GeneratedValue(generator = "persona_generador")
    @SequenceGenerator(
            name = "persona_generador",
            sequenceName = "persona_sequence",
            initialValue = 1
    )
    private Long id;    
    
    /**
     * Nombre de la persona
     */
    @Column(columnDefinition = "nombre", nullable = false)
    private String nombre;
    
    /**
     * Estado del registro
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EnumActivoInactivo estado;
    
    
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
     * Metodo que obtiene el atributo nombre
     * @return valor de atributo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que asigna un valor al atributo nombre
     * @param nombre valor a ser asignado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el atributo estado
     * @return valor de atributo
     */
    public EnumActivoInactivo getEstado() {
        return estado;
    }

    /**
     * Metodo que asigna un valor al atributo estado
     * @param estado valor a ser asignado
     */
    public void setEstado(EnumActivoInactivo estado) {
        this.estado = estado;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.avalith.challenge.modelos.Persona[ id=" + id + " ]";
    }

    
    
    
}
