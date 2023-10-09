package com.example.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.formLogin(login -> login
				.loginProcessingUrl("/login")
				.loginPage("/login")
				.failureUrl("/login?error")
				.usernameParameter("userId")
				.passwordParameter("password")
				.defaultSuccessUrl("/cart/view", true)
		).logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
        ).authorizeHttpRequests(authz -> authz
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.requestMatchers("/").permitAll()
				.requestMatchers("/cart/add-to-cart").permitAll()
				.requestMatchers("/cart/remove-from-cart").permitAll()
				.requestMatchers("/login").permitAll()
				.requestMatchers("/cart/view").permitAll()
				.requestMatchers("/user/signup").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.requestMatchers("/webjars/**").permitAll()
				.requestMatchers("/h2-console/**").permitAll()
				.requestMatchers("/error").permitAll()
				.anyRequest().authenticated()
		);	
				
		http.csrf().disable();
		http.headers().frameOptions().disable(); 
		
		return http.build();
		
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}

