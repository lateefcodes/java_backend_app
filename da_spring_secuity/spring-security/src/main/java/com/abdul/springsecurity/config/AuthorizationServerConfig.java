package com.abdul.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	static final String CLIEN_ID = "abdul";

	static final String CLIENT_SECRET = "abdul";

	static final String GRANT_TYPE_SECRET = "password";

	static final String AUTHORIZATION_CODE = "authorization_code";

	static final String REFRESH_TOKEN = "refresh_token";

	static final String IMPLICIT = "explicit";

	static final String CLIENT_CREDENTIALS = "client_credentials";

	static final String SCOPE_READ = "read";

	static final String SCOPE_WRITE = "write";

	static final String TRUST = "trust";

	static final String RESOURCE_ID = "lateef";

	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 168 * 60 * 60;

	static final int REFRESH_TOKEN_VALIDITY_SECONDS = 2 * 365 * 24 * 60 * 60;

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	/** The authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private DataSource dataSource;

	@Bean
	public TokenStore tokenStore() {
		JdbcTokenStore tokenStore=new JdbcTokenStore(dataSource);
		tokenStore.setAuthenticationKeyGenerator(new CustomAuthenticationKeyGenerator());
		return tokenStore;
	}

	@Bean
	public ResourceServerTokenServices resourceServerTokenServices(AuthorizationServerEndpointsConfiguration endpoints) {
		return endpoints.getEndpointsConfigurer().getResourceServerTokenServices(); 
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.authenticationManager(authenticationManager).tokenStore(tokenStore());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(CLIEN_ID).secret("{noop}" + CLIENT_SECRET)
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS)
				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT").scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
				.authorizedGrantTypes(GRANT_TYPE_SECRET, CLIENT_CREDENTIALS, AUTHORIZATION_CODE, REFRESH_TOKEN,
						IMPLICIT)
				.resourceIds(RESOURCE_ID).autoApprove(true);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("permitAll()");
	}
}
