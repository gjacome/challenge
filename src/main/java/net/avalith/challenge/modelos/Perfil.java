/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.avalith.challenge.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "perfil", schema = "challenge")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador del registro
     */
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    /**
     * Nombre del perfil
     */
    @Column(name = "nombre")
    private String nombre;
    
    /**
     * Estado del registro
     */
    @Column(name = "estado")
    private String estado;
    
    /**
     * Lista de usuarios que tienen este perfil
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil", fetch = FetchType.EAGER)
    private List<UsuarioPerfil> usuarioPerfilList;

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
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo que asigna un valor al atributo estado
     * @param estado valor a ser asignado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo que obtiene el atributo usuarioPerfilList
     * @return valor de atributo
     */
    public List<UsuarioPerfil> getUsuarioPerfilList() {
        return usuarioPerfilList;
    }

    /**
     * Metodo que asigna un valor al atributo usuarioPerfilList
     * @param usuarioPerfilList valor a ser asignado
     */
    public void setUsuarioPerfilList(List<UsuarioPerfil> usuarioPerfilList) {
        this.usuarioPerfilList = usuarioPerfilList;
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
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.avalith.challenge.modelos.Perfil[ id=" + id + " ]";
    }
    
}
