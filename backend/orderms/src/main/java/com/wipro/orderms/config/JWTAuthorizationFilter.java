//package com.wipro.orderms.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.security.Key;
//import java.util.Base64;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@Component
//public class JWTAuthorizationFilter extends OncePerRequestFilter {
//
//  private static final String HEADER="Authorization";
//  private static final String PREFIX="Bearer ";
//
//  private final Key key;
//
//  public JWTAuthorizationFilter(@Value("${app.jwt.secret}") String secret) {
//    byte[] decoded = Base64.getDecoder().decode(secret.trim());
//    this.key = Keys.hmacShaKeyFor(decoded);
//  }
//
//  @Override
//  protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
//      throws ServletException, IOException {
//
//    String header = req.getHeader(HEADER);
//    if (header==null || !header.startsWith(PREFIX)) { chain.doFilter(req,res); return; }
//
//    try {
//      String token = header.substring(PREFIX.length()).trim();
//      Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
//      String subject = claims.getSubject();
//      var authorities = extractAuthorities(claims);
//      if (subject != null) {
//        SecurityContextHolder.getContext().setAuthentication(
//            new UsernamePasswordAuthenticationToken(subject, null, authorities));
//      }
//    } catch (Exception e) {
//      SecurityContextHolder.clearContext();
//      res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//      return;
//    }
//    chain.doFilter(req,res);
//  }
//
//  @SuppressWarnings("unchecked")
//  private Collection<SimpleGrantedAuthority> extractAuthorities(Claims claims) {
//    Object raw = claims.get("authorities");
//    if (raw == null) raw = claims.get("roles");
//    if (raw == null) raw = claims.get("role");
//
//    // Handles both List<String> and List<Map<String,String>> ({"authority":"ROLE_X"})
//    if (raw instanceof List<?> list) {
//      return list.stream()
//          .map(Object.class::cast)
//          .map(elem -> {
//            if (elem instanceof Map<?, ?> m) {
//              Object a = m.get("authority");
//              return (a == null) ? null : a.toString();
//            }
//            return elem.toString();
//          })
//          .filter(Objects::nonNull)
//          .filter(s -> !s.isBlank())
//          .map(SimpleGrantedAuthority::new)
//          .collect(Collectors.toList());
//    }
//
//    if (raw instanceof String s) {
//      return List.of(new SimpleGrantedAuthority(s));
//    }
//
//    return List.of();
//  }
//}
