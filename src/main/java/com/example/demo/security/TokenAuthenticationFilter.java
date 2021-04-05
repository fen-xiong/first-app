package com.example.demo.security;


import com.example.demo.repository.UserDataAccessService;
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
        SecurityContext context =   SecurityContextHolder.getContext();
        Authentication authentication;
        if(headerToken != null){
             headerToken = headerToken.replace("Bearer ","") ;
             String role =  UserDataAccessService.getUserRole(headerToken);
             role = role != null ? role : "ROLE_NULL";
             authentication = new TestingAuthenticationToken("fe34", "12", role);
        }else{
            authentication = new TestingAuthenticationToken("fe34", "12", "ROLE_NULL");
        }


        context.setAuthentication(authentication);
        request.setAttribute("user_id",3);
        chain.doFilter(request,response);
    }
}
