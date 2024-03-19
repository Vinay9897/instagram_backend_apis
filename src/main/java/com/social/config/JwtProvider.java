package com.social.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtProvider {

	private static SecretKey secretKey = Keys.hmacShaKeyFor(Constants.SECRET_KEY.getBytes());

	public static String generateToken(Authentication auth) {
		String jwt = Jwts.builder().setIssuer("vinay").setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + 60 * 60 * 1000)).claim("email", auth.getName())
				.signWith(secretKey).compact();

		return jwt;
	}

	public static String getEmailFromJWTToken(String jwt) {
		jwt = jwt.substring(7);

		Claims claims = Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(jwt).getBody();

		String email = String.valueOf(claims.get("email"));

		return email;
	}

}
