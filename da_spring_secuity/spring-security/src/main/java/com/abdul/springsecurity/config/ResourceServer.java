package com.abdul.springsecurity.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * The Class ResourceServer.
 */
@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {

	/** The Constant RESOURCE_ID. */
	private static final String RESOURCE_ID = "lateef";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.
	 * ResourceServerConfigurerAdapter#configure(org.springframework.security.oauth2
	 * .config.annotation.web.configurers.ResourceServerSecurityConfigurer)
	 */
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.
	 * ResourceServerConfigurerAdapter#configure(org.springframework.security.config
	 * .annotation.web.builders.HttpSecurity)
	 */
	/*
	 * @Override public void configure(HttpSecurity httpSecurity) throws Exception {
	 * httpSecurity.csrf().disable().anonymous().disable() .authorizeRequests()
	 * .antMatchers("/oauth/token").permitAll(); }
	 */

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests()
				.antMatchers(
						"/first/hello"
				)
				.permitAll() // Allow urls
				.anyRequest().authenticated().and().antMatcher("/api/**").authorizeRequests(); // Authenticate all urls
																								// with this body
																								// /api/home,
																								// /api/gallery
				//.antMatchers("/api/**").hasRole("ADMIN"); // This is optional if you want to handle exception
	}

}
