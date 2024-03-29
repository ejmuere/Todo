package com.collabera.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
//	protected void configure() throws Exception{
//		http
//			.authorizeRequests()
//			.antMatchers("/login","logout","/error").permitAll()
//			.antMatchers("/addtodos","/updatetodos","/listtodos").hasRole("User");
//			
//	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication().withUser("root").password(passwordEncoder().encode("root")).roles("User")
//		.and()
//		.withUser("groot").password(passwordEncoder().encode("groot")).roles("User");
		
		//list of users in database 
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}
		
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login","/logout","/error","/signup").permitAll()
			.antMatchers("/webjars/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/hello",true)
			.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("JSESSIONID");
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImp();
	}
}
