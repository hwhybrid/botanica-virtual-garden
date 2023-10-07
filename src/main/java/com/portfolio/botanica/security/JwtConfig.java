//package com.portfolio.botanica.security;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import io.jsonwebtoken.security.Keys;
//import java.security.Key;
//
//@Configuration
//public class JwtConfig {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expirationMs}")
//    private long expirationMs;
//
//    @Bean
//    public Key jwtSecretKey() {
//        // Generate a secret key (use a secure method to generate your secret)
//        return Keys.hmacShaKeyFor(secret.getBytes());
//    }
//
//    public long getExpirationMs() {
//        return expirationMs;
//    }
//}
