package com.wipro.springsecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/hello")
                .permitAll() 
                .anyRequest()
                .authenticated())
            .formLogin(Customizer.withDefaults()) 
            .logout(Customizer.withDefaults());   
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("user1")
            .password("{noop}pass1") // Plain text password
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user1);
    }
//    @Bean
//    public UserDetailsService userDetailsService2() {
//        UserDetails user2 = User.withUsername("user2")
//            .password("{noop}pass2") // Plain text password
//            .roles("USER")
//            .build();
//        return new InMemoryUserDetailsManager(user2);
//    }

    }

