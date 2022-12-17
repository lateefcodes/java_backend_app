/*
 @author: lateef
 @project: digitalashram
 @created: 19/06/2022 - 3:08 AM
 */
package com.digitalashram.config.google;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/","/first/hello").permitAll()
                .anyRequest().authenticated()
                .and().oauth2Login();
    }
}
