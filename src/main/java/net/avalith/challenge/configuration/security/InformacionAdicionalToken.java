package net.avalith.challenge.configuration.security;

import java.util.HashMap;
import java.util.Map;
import net.avalith.challenge.modelos.Usuario;
import net.avalith.challenge.service.SeguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

/**
 * Clase que permite agregar informacion adicional al token
 * @author Administrador
 */
@Component
public class InformacionAdicionalToken implements TokenEnhancer {

    @Autowired
    private SeguridadService seguridadService;

    /**
     * Metodo que agrega información adicional del token
     * @param accessToken token de acceso
     * @param authentication informacion de autenticacion
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        Usuario usuario = seguridadService.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("info_adicional", "Usuario autenticado: ".concat(authentication.getName()));
        info.put("nombre", usuario.getPersona().getNombre());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }
}
