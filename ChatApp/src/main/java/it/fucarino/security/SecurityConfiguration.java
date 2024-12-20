package it.fucarino.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {


	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeHttpRequests().requestMatchers("/**").hasAnyAuthority("USER")
		.requestMatchers("/create").permitAll().and().formLogin().and().logout().and().exceptionHandling();
		return httpSecurity.build();
	}
	
	@Bean
	DatabaseUserDetailsService userDetailsService() {
	return new DatabaseUserDetailsService();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return authenticationProvider;
	}
	
	

	
	
}
