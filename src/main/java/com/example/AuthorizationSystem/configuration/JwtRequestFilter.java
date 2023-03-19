package com.example.AuthorizationSystem.configuration;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class JwtRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      final String header= request.getHeader("Authorization");
      String jwtToken=null;
      if(header!=null && header.startsWith("Bearer ")){

          //whatever jwttoken we retrive from the header
          // is stored in "jwtToken"

         jwtToken = header.substring(7);   //length of the bearer =6 + space=1

          //to retrive the username

          try{

          }
          catch (IllegalArgumentException e){
            System.out.println("Unable to get JWT token");
          }
          catch(ExpiredJwtException e){
              System.out.println("JWT token is expired");
          }
      }
    }
}
