package com.auxirem.blogs.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())// ✅ new syntax
                
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/blogs/public/**").permitAll()
                        .anyRequest().access((authentication, context) -> {
                            String fromGateway = context.getRequest().getHeader("From-Gateway");
                            if ("true".equals(fromGateway)) {
                                return new AuthorizationDecision(true);
                            }
                            return new AuthorizationDecision(false);
                        })
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((req, res, excep) -> res.sendError(401, "Unauthorized"))
                );



        return http.build();
    }
}