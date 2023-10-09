package com.example.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
		return new MvcRequestMatcher.Builder(introspector);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
		
		http.authorizeHttpRequests(authz -> authz
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.requestMatchers(PathRequest.toH2Console()).permitAll()
				.requestMatchers(mvc.pattern("/")).permitAll()
				.requestMatchers(mvc.pattern("/cart/add-to-cart")).permitAll()
				.requestMatchers(mvc.pattern("/cart/remove-from-cart")).permitAll()
				.requestMatchers(mvc.pattern("/login")).permitAll()
				.requestMatchers(mvc.pattern("/cart/view")).permitAll()
				.requestMatchers(mvc.pattern("/user/signup")).permitAll()
				.requestMatchers(mvc.pattern("/admin")).hasRole("ADMIN")
				.requestMatchers(mvc.pattern("/webjars/**")).permitAll()
				.requestMatchers(mvc.pattern("/error")).permitAll()
				.anyRequest().authenticated()
		).formLogin(login -> login
				.loginProcessingUrl("/login")
				.loginPage("/login")
				.failureUrl("/login?error")
				.usernameParameter("userId")
				.passwordParameter("password")
				.defaultSuccessUrl("/cart/view", true)
		).logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
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

