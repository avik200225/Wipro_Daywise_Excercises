package com.wipro.jwtdemo.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.jwtdemo.dto.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

    @PostMapping("/login")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        if("Memanasa".equals(username) && "pass".equals(pwd)) {
            String token = getJWTToken(username);
            User user = new User();
            user.setUser(username);
            user.setToken(token);
            return user;
        } else {
            throw new RuntimeException("Login unsuccessful. Invalid credentials.");
        }
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        System.out.println("Current Time (ms): " + System.currentTimeMillis());
        System.out.println("Issued At: " + new Date(System.currentTimeMillis()));
        String token = Jwts.builder()
                .setId("wiproJWT")
                .setSubject(username)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();
        return "Bearer " + token;
    }
}
