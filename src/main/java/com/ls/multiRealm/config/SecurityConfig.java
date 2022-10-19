package com.ls.multiRealm.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtIssuerAuthenticationManagerResolver authenticationManagerResolver = new JwtIssuerAuthenticationManagerResolver(
			"http://localhost:8180/auth/realms/RealmTeste4",
			"http://localhost:8180/auth/realms/RealmTeste3",
			"http://localhost:8180/auth/realms/teste2",
			"http://localhost:8180/auth/realms/teste1"
	);

	@Override
	public void configure(final HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests(authz -> authz
					.antMatchers("/test").authenticated()
			)
			.oauth2ResourceServer((oauth2 -> oauth2.authenticationManagerResolver(authenticationManagerResolver)));

	}

}