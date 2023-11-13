package com.eurekaway.config.security.config;


//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfiguration {
//    
//	@Autowired
//	private Environment env;
//	
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return JwtDecoders.fromIssuerLocation(env.getProperty("spring.security.oauth2.client.provider.keycloak.issuer-uri"));
//    }
    
//	@Bean
//	public JwtDecoder jwtDecoder() {
//	    return NimbusJwtDecoder.withJwkSetUri(env.getProperty("spring.security.oauth2.client.provider.keycloak.jwk-set-uri")).build();
//	}
	
//	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//	String issuerUri;

//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http
//				.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//				.oauth2ResourceServer(oauth2 -> oauth2
//						.jwt(jwt -> jwt.decoder(JwtDecoders.fromIssuerLocation(issuerUri))))
//				.build();
//	}

    //esto no se usa 
//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverterForKeycloak() {
//        Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter = jwt -> {
//            Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
//
//            Object client = resourceAccess.get("demo-client");
//
//            LinkedTreeMap<String, List<String>> clientRoleMap = (LinkedTreeMap<String, List<String>>) client;
//
//            List<String> clientRoles = new ArrayList<>(clientRoleMap.get("roles"));
//
//            return clientRoles.stream()
//                    .map(SimpleGrantedAuthority::new)
//                    .collect(Collectors.toList());
//        };
//
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
//
//        return jwtAuthenticationConverter;
//    }
	
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager(){
//	    UserDetails admin = User.withDefaultPasswordEncoder()
//	            .username("ADMIN")
//	            .password("123")
//	            .roles("ADMIN").build();
//
//	    return new InMemoryUserDetailsManager(admin);
//	}
//}