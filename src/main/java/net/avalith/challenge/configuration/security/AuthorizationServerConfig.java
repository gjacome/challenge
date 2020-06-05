package net.avalith.challenge.configuration.security;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Clase que permite generar el token de seguridad para el consumo de los Rest
 * @author Administrador
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	/**
         * Administrador de autenticacion
         */
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
        /**
         * Componente que permite adicionar informacion al token
         */
	@Autowired
	private InformacionAdicionalToken informacionAdicionalToken;

        /**
         * Metodo de configuracion de accesos
         * @param security informacion de configuracion
         * @throws Exception 
         */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()");
	}

        /**
         * Registra el cliente que utilizara el servicio y el tiempo de vigencia del token
         * @param clients configuracion del cliente
         * @throws Exception 
         */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("clienteRest")
		.secret(passwordEncoder.encode("12345"))
		.scopes("read", "write")
		.authorizedGrantTypes("password", "refresh_token")
		.accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(3600);
	}

        /**
         * Configuracion para endpoints
         * @param endpoints configuracion de endpoint
         * @throws Exception 
         */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(
                        Arrays.asList(informacionAdicionalToken, accessTokenConverter()));
		
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore())
		.accessTokenConverter(accessTokenConverter())
		.tokenEnhancer(tokenEnhancerChain);
	}

        /**
         * Permite almacenar el token en store de jwt
         * @return JwtTokenStore
         */
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

        /**
         * Retorna una instanacia de tipo JwtAccessTokenConverter
         * @return instancia de tipo JwtAccessTokenConverter
         */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		return jwtAccessTokenConverter;
	}
	

}