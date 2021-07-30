package com.example.HelloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws  Exception {
		authenticationManagerBuilder.inMemoryAuthentication().withUser("ibo").password("ibo").roles("ADMIN")
		.and().withUser("obi").password("obi").roles("USER");
}
	

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return  NoOpPasswordEncoder.getInstance();
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// httpSecurity.authorizeRequests()
		//							.antMatchers("/**").hasRole("ADMIN").and().formLogin();
		
		
		httpSecurity.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll().and().formLogin();	
	}
	
}
