//package com.wipro.productms.config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@EnableWebSecurity
//@Configuration
//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable()
//            .authorizeHttpRequests(auth -> auth
//            		.requestMatchers("/user/login","/user/logout/**","/user/saveuser","/user/saveadmin").permitAll()
//                .anyRequest().authenticated() 
//            )
//            .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//}



//src/main/java/com/wipro/productms/config/SecurityConfig.java
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
public WebSecurityConfig(JWTAuthorizationFilter jwtFilter) { this.jwtFilter = jwtFilter; }

@Bean
SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 http.csrf(csrf -> csrf.disable())
     .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
     .authorizeHttpRequests(auth -> auth
         .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
         .requestMatchers(HttpMethod.GET, "/product/**").permitAll()
         .requestMatchers(HttpMethod.POST, "/product/**").hasAnyAuthority("ROLE_ADMIN","ADMIN")
         .requestMatchers(HttpMethod.PUT,  "/product/**").hasAnyAuthority("ROLE_ADMIN","ADMIN")
         .requestMatchers(HttpMethod.DELETE,"/product/**").hasAnyAuthority("ROLE_ADMIN","ADMIN")
         .anyRequest().authenticated())
     .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
 return http.build();
}
}

