//package com.portfolio.botanica.security;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//import javax.naming.AuthenticationException;
//import java.io.IOException;
//
//public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {
//
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage());
//
//    }
//
//}
