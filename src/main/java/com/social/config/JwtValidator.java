package com.social.config;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class JwtValidator extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String jwt = request.getHeader(Constants.JWT_HEADER);
		System.out.println(jwt);
		if(jwt != null) {
			
			try {
			String email = JwtProvider.getEmailFromJWTToken(jwt);
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			Authentication auth = new UsernamePasswordAuthenticationToken(email,null,authorities);
			
			SecurityContextHolder.getContext().setAuthentication(auth);
			}
			catch(Exception e) 
			{
				throw new BadCredentialsException("invalid token.......");
			}
		}
//		else {
//			throw new BadCredentialsException("please provide the valid token");
//		}
		
		filterChain.doFilter(request, response);
	}
	
	
	
}
