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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import net.avalith.challenge.modelos.enumeraciones.EnumActivoInactivo;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "usuario", schema = "challenge")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Usuario para el login
     */
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    
    /**
     * Clave del usuario
     */
    @Column(name = "password")
    private String password;
    
    /**
     * Estado del usuario
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EnumActivoInactivo estado;
    
    /**
     * Lsta de pefiles de este usuario
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario1", fetch = FetchType.EAGER)
    private List<UsuarioPerfil> usuarioPerfilList;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    
    /**
     * Persona a quien pertenece este usuario
     */
    @ManyToOne
    private Persona persona;

    public Usuario() {
    }

    public Usuario(String usuario) {
        this.username = usuario;
    }

    /**
     * Metodo que obtiene el atributo username
     * @return valor de atributo
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo que asigna un valor al atributo username
     * @param username valor a ser asignado
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Metodo que obtiene el atributo clave
     * @return valor de atributo
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo que asigna un valor al atributo password
     * @param password valor a ser asignado
     */
    public void setPassword(String password) {
        this.password = password;
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

    /**
     * Metodo que obtiene el atributo persona
     * @return valor de atributo
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Metodo que asigna un valor al atributo persona
     * @param persona valor a ser asignado
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.avalith.challenge.modelos.Usuario[ usuario=" + username + " ]";
    }
    
}
