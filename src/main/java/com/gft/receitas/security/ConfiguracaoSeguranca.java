package com.gft.receitas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	        .authorizeRequests()
	        	.antMatchers("/index").permitAll()
	        	.antMatchers("/usuario/**").permitAll()
	        	.antMatchers("/receita/**").permitAll()	        	
	        	.antMatchers("/unidademedida/**").hasAuthority("admin")
	        	.antMatchers("/ingrediente/**").hasAuthority("admin")
	        	.antMatchers("/usuario/**").hasAuthority("admin")
		        .anyRequest().authenticated()
		    .and()
	        .formLogin()
	        	.loginPage("/entrar")
	        	.permitAll()
	        	.defaultSuccessUrl("/", true)
                .usernameParameter("username")
                .passwordParameter("password")
	        .and()
	        .logout()	 
	        	.logoutSuccessUrl("/entrar?logout")
	        	.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}


}
