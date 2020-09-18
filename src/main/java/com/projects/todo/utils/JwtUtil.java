package com.projects.todo.utils;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

  private static final String SECRET_KEY = String.valueOf(System.getenv("SECRET_KEY"));

  public String extractUsername(String token) {
    return extractClaims(token, Claims::getSubject);
  }

  public Date extractExpiration(String token) {
    return extractClaims(token, Claims::getExpiration);
  }

  public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
  }

  public Boolean isTokenExpired(String token, Date date) {
    return extractExpiration(token).before(date);
  }

  public String generateToken(UserDetails userDetails, Integer expiresIn) {
    Map<String, Object> claims = new HashMap<>();
    return createToken(claims, userDetails.getUsername(), expiresIn);
  }

  private String createToken(Map<String, Object> claims, String subject, Integer minute) {
    return Jwts.builder().setClaims(claims).setSubject(subject)
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * minute))
      .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
  }

  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token, new Date()));
  }
}
