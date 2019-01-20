package com.bank.bookstore.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${security.username}")
	private String username;
	@Value("${security.password}")
	private String password;
	private static final String[] AUTH_WHITELIST = {
			// -- swagger ui
			"/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
			"/configuration/security", "/swagger-ui.html", "/webjars/**"
			// other public endpoints of your API may be appended to this array
	};
	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
				.withUser("user1").password("secret1").roles("USER").and().withUser(username).password(password)
				.roles("USER", "ADMIN");
	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and().authorizeRequests()
//		.antMatchers("/**").hasRole("USER")
//		.antMatchers("/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/**").permitAll()
		.antMatchers(AUTH_WHITELIST).permitAll()
		.antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/**").hasRole("USER")
		.antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/**").hasRole("USER")
		.anyRequest().authenticated()
		.and().csrf().disable().headers().frameOptions().disable();
	}

}
