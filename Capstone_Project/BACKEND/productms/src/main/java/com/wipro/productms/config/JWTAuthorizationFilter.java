package com.wipro.productms.config;

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
import java.security.Key;
import java.util.*;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

  @Value("${app.jwt.secret}")
  private String secret;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {

    String h = request.getHeader("Authorization");
    if (h == null || !h.startsWith("Bearer ")) {
      chain.doFilter(request, response);
      return;
    }
    try {
      String token = h.substring(7);
      Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
      Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

      Object rolesObj = claims.get("authorities");
      List<SimpleGrantedAuthority> auths = new ArrayList<>();
      if (rolesObj instanceof Collection<?> col) {
        for (Object o : col) auths.add(new SimpleGrantedAuthority(o.toString()));
      } else if (rolesObj instanceof String s) {
        auths.add(new SimpleGrantedAuthority(s));
      }
      SecurityContextHolder.getContext().setAuthentication(
          new UsernamePasswordAuthenticationToken(claims.getSubject(), null, auths));
    } catch (Exception e) {
      SecurityContextHolder.clearContext();
    }
    chain.doFilter(request, response);
  }
}

