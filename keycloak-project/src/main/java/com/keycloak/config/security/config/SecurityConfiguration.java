package com.keycloak.config.security.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
//@RequiredArgsConstructor
public class SecurityConfiguration {

//    @Autowired
//    private final JwtAuthenticationConverter jwtAuthenticationConverter;


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//	
//	http
//	    .sessionManagement()
//	    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
//	
//	http
//	    .authorizeHttpRequests()
//	                .requestMatchers("/unauthenticated", "/oauth2/**", "/login/**").permitAll()
//	                .anyRequest()
//	                    .fullyAuthenticated()
//	    .and()
//	        .logout()
//	        .logoutSuccessUrl("http://localhost:8080/realms/external/protocol/openid-connect/logout?redirect_uri=http://localhost:8081/");
	
        http.cors()
        .and()
        .sessionManagement()
	    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
	    .and()
	    .authorizeHttpRequests()
        .requestMatchers("/unauthenticated", "/oauth2/**", "/login/**").permitAll()
        .anyRequest()
        .fullyAuthenticated()
    	.and()
		.logout()
		.logoutSuccessUrl("http://localhost:8080/realms/external/protocol/openid-connect/logout?redirect_uri=http://localhost:8081/")
        .and()
        .oauth2ResourceServer()
        .jwt();
        
	return http.build();
	    }

}

 
 
