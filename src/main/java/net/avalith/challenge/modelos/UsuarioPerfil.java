/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.avalith.challenge.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import net.avalith.challenge.modelos.enumeraciones.EnumActivoInactivo;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "usuario_perfil", schema = "challenge")
@NamedQueries({
    @NamedQuery(name = "UsuarioPerfil.findAll", query = "SELECT u FROM UsuarioPerfil u")})
public class UsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Clase identificadora del registro
     */
    @EmbeddedId
    protected UsuarioPerfilPK usuarioPerfilPK;
    
    /**
     * Estado del registro
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")   
    private EnumActivoInactivo estado;
    
    /**
     * Perfil
     */
    @JoinColumn(name = "id_perfil", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;
    
    /**
     * Usuario
     */
    @JoinColumn(name = "usuario", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(UsuarioPerfilPK usuarioPerfilPK) {
        this.usuarioPerfilPK = usuarioPerfilPK;
    }

    public UsuarioPerfil(String usuario, long idPerfil) {
        this.usuarioPerfilPK = new UsuarioPerfilPK(usuario, idPerfil);
    }

    /**
     * Metodo que obtiene el atributo usuarioPerfilPK
     * @return valor de atributo
     */
    public UsuarioPerfilPK getUsuarioPerfilPK() {
        return usuarioPerfilPK;
    }

    /**
     * Metodo que asigna un valor al atributo usuarioPerfilPK
     * @param usuarioPerfilPK valor a ser asignado
     */
    public void setUsuarioPerfilPK(UsuarioPerfilPK usuarioPerfilPK) {
        this.usuarioPerfilPK = usuarioPerfilPK;
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
     * Metodo que obtiene el atributo perfil
     * @return valor de atributo
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * Metodo que asigna un valor al atributo perfil
     * @param perfil valor a ser asignado
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * Metodo que obtiene el atributo usuario1
     * @return valor de atributo
     */
    public Usuario getUsuario1() {
        return usuario1;
    }

    /**
     * Metodo que asigna un valor al atributo usuario1
     * @param usuario1 valor a ser asignado
     */
    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPerfilPK != null ? usuarioPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPerfil)) {
            return false;
        }
        UsuarioPerfil other = (UsuarioPerfil) object;
        if ((this.usuarioPerfilPK == null && other.usuarioPerfilPK != null) || (this.usuarioPerfilPK != null && !this.usuarioPerfilPK.equals(other.usuarioPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.avalith.challenge.modelos.UsuarioPerfil[ usuarioPerfilPK=" + usuarioPerfilPK + " ]";
    }
    
}
