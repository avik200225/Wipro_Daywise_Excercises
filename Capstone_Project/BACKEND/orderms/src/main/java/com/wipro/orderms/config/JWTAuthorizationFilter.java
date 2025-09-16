package com.wipro.orderms.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

  @Value("${app.jwt.secret}")
  private String secret;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {

    String header = request.getHeader("Authorization");
    if (header == null || !header.startsWith("Bearer ")) {
      chain.doFilter(request, response);
      return;
    }

    try {
      String token = header.substring(7);
      Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
      Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

      Object val = claims.get("authorities");
      if (val == null) val = claims.get("roles");
      if (val == null) val = claims.get("role");

      List<SimpleGrantedAuthority> authorities = switch (val) {
        case List<?> list -> list.stream().map(String::valueOf).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        case String s -> List.of(new SimpleGrantedAuthority(s));
        default -> List.of();
      };

      UsernamePasswordAuthenticationToken auth =
          new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities);
      SecurityContextHolder.getContext().setAuthentication(auth);
    } catch (Exception e) {
      SecurityContextHolder.clearContext();
    }
    chain.doFilter(request, response);
  }
}


