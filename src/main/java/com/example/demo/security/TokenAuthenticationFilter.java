package com.example.demo.security;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String headerToken = request.getHeader("Authorization");
        headerToken = headerToken.replace("Bearer ","");
        SecurityContext context =   SecurityContextHolder.getContext();
        if( headerToken != null &&  headerToken.equals("hello")){
            Authentication authentication = new TestingAuthenticationToken("fen123", "123456", "ROLE_ADMIN");
            context.setAuthentication(authentication);
        }else{
            Authentication authentication = new TestingAuthenticationToken("fe34", "12", "ROLE_NULL");
            context.setAuthentication(authentication);
        }
        chain.doFilter(request,response);
    }
}
