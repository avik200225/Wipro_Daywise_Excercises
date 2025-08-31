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
  public WebSecurityConfig(JWTAuthorizationFilter jwtFilter) { this.jwtFilter = jwtFilter; }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      .cors(cors -> cors.configurationSource(req -> {
        CorsConfiguration c = new CorsConfiguration();
        c.setAllowedOrigins(List.of("http://localhost:4200"));
        c.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        c.setAllowedHeaders(List.of("*"));
        c.setAllowCredentials(true);
        c.setMaxAge(3600L);
        return c;
      }))
      .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(auth -> auth
          .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()

          .requestMatchers("/cart/**").hasAnyAuthority("ROLE_USER","USER","ROLE_ADMIN","ADMIN")

          .requestMatchers(HttpMethod.POST,"/order/**").hasAnyAuthority("ROLE_USER","USER","ROLE_ADMIN","ADMIN")
          .requestMatchers(HttpMethod.PUT, "/order/**").hasAnyAuthority("ROLE_USER","USER","ROLE_ADMIN","ADMIN")

          .requestMatchers(HttpMethod.GET,"/order").hasAnyAuthority("ROLE_ADMIN","ADMIN")

          .requestMatchers(HttpMethod.GET,"/order/**").authenticated()

          .anyRequest().authenticated())
      .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
