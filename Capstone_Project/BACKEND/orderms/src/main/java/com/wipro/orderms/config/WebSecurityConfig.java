package com.wipro.orderms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class WebSecurityConfig {

  private final JWTAuthorizationFilter jwtFilter;

  public WebSecurityConfig(JWTAuthorizationFilter jwtFilter) {
    this.jwtFilter = jwtFilter;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      .cors(c -> c.configurationSource(req -> {
        CorsConfiguration cfg = new CorsConfiguration();
        cfg.setAllowedOriginPatterns(List.of("*"));
        cfg.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        cfg.setAllowedHeaders(List.of("*"));
        cfg.setAllowCredentials(true);
        cfg.setMaxAge(3600L);
        return cfg;
      }))
      .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .requestMatchers("/actuator/**").permitAll()

        .requestMatchers("/cart/**").hasAnyAuthority("ROLE_USER","USER","ROLE_ADMIN","ADMIN")
        .requestMatchers(HttpMethod.POST, "/order/**").hasAnyAuthority("ROLE_USER","USER","ROLE_ADMIN","ADMIN")
        .requestMatchers(HttpMethod.PUT,  "/order/**").hasAnyAuthority("ROLE_USER","USER","ROLE_ADMIN","ADMIN")
        .requestMatchers(HttpMethod.GET,  "/order/**").hasAnyAuthority("ROLE_USER","USER","ROLE_ADMIN","ADMIN")

        .anyRequest().authenticated())
      .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}

