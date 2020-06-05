package net.avalith.challenge.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Clase que permite realizara la auditoria al crear o actualizar registros de 
 * otras entidades
 * @author Administrador
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"fechaCreacion", "fechaCreacion"},
        allowGetters = true
)
public abstract class Auditoria implements Serializable {

    /**
     * Representa la columna fecha de creacion del registro para fines de auditoria
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @CreatedDate
    private Date fechaCreacion;

    /**
     * Representa la columna fecha de ultima actualizacion del registro para fines de auditoria
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion", nullable = true)
    @LastModifiedDate
    private Date fechaActualizacion;

    /**
     * Metodo que obtiene el atributo fecha de creacion
     * @return valor de atributo
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Metodo que asigna un valor al atributo fechaCreacion
     * @param fechaCreacion valor a ser asignado
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Metodo que obtiene el atributo fecha de fechaActualizacion
     * @return valor de atributo
     */
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * Metodo que asigna un valor al atributo fechaActualizacion
     * @param fechaActualizacion valor a ser asignado
     */
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    
    
}
