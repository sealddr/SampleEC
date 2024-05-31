package com.example.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
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
		CookieClearingLogoutHandler cookies = new CookieClearingLogoutHandler("our-custom-cookie");
		http.authorizeHttpRequests(authz -> authz
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.requestMatchers(PathRequest.toH2Console()).permitAll()
				.requestMatchers(mvc.pattern("/")).permitAll()
				.requestMatchers(mvc.pattern("/store")).permitAll()
				.requestMatchers(mvc.pattern("/api/cart/add")).permitAll()
				.requestMatchers(mvc.pattern("/api/cart/remove")).permitAll()
				.requestMatchers(mvc.pattern("/store/cart/view")).permitAll()
				.requestMatchers(mvc.pattern("/store/cart/view/loginInstraction")).permitAll()
				.requestMatchers(mvc.pattern("/login")).permitAll()
				.requestMatchers(mvc.pattern("/signup")).permitAll()
				.requestMatchers(mvc.pattern("/webjars/**")).permitAll()
				.requestMatchers(mvc.pattern("/error")).permitAll()
				.requestMatchers(mvc.pattern("/admin")).hasRole("ADMIN")
				.requestMatchers(mvc.pattern("/admin/products")).hasRole("ADMIN")
				.anyRequest().authenticated()
		).formLogin(login -> login
				.loginProcessingUrl("/login")
				.loginPage("/login")
				.failureUrl("/login?error")
				.usernameParameter("userId")
				.passwordParameter("password")
				.defaultSuccessUrl("/login/success", true)
		).logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
				.addLogoutHandler(cookies)
		).csrf(csrf -> csrf
				.ignoringRequestMatchers(
					AntPathRequestMatcher.antMatcher("/h2-console/**")
				)				
		);
		
        http.headers(headers -> headers.frameOptions().disable()); 		
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

