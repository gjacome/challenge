/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.avalith.challenge.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrador
 */
@Embeddable
public class UsuarioPerfilPK implements Serializable {
    /**
     * Usuario 
     */
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    
    /**
     * Identificador del perfil
     */
    @Basic(optional = false)
    @Column(name = "id_perfil")
    private Long idPerfil;

    public UsuarioPerfilPK() {
    }

    public UsuarioPerfilPK(String usuario, long idPerfil) {
        this.usuario = usuario;
        this.idPerfil = idPerfil;
    }

    /**
     * Metodo que obtiene el atributo usuario
     * @return valor de atributo
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo que asigna un valor al atributo usuario
     * @param usuario valor a ser asignado
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo que obtiene el atributo idPerfil
     * @return valor de atributo
     */
    public Long getIdPerfil() {
        return idPerfil;
    }

    /**
     * Metodo que asigna un valor al atributo idPerfil
     * @param idPerfil valor a ser asignado
     */
    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        hash += (long) idPerfil;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPerfilPK)) {
            return false;
        }
        UsuarioPerfilPK other = (UsuarioPerfilPK) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        if (this.idPerfil != other.idPerfil) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.avalith.challenge.modelos.UsuarioPerfilPK[ usuario=" + usuario + ", idPerfil=" + idPerfil + " ]";
    }
    
}
