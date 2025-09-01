package com.wipro.productms.config;

import com.wipro.productms.config.JWTAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {

    private final JWTAuthorizationFilter jwtFilter;

    public WebSecurityConfig(JWTAuthorizationFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
           .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
           .authorizeHttpRequests(auth -> auth
               .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()

               .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
               .requestMatchers(HttpMethod.GET, "/product/**").permitAll()
               .requestMatchers(HttpMethod.POST, "/product/**").hasAnyAuthority("ROLE_ADMIN","ADMIN")
               .requestMatchers(HttpMethod.PUT,  "/product/**").hasAnyAuthority("ROLE_ADMIN","ADMIN")
               .requestMatchers(HttpMethod.DELETE,"/product/**").hasAnyAuthority("ROLE_ADMIN","ADMIN")
               .anyRequest().authenticated()
           )
           .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
