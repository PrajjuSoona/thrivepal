package com.thrivepal.userservice.util;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private  String secret;

	public String generateToken(String email) {
		try {
			System.out.println("token:"+secret);

			//byte[] keyBytes = secret.getBytes();
			//SecretKey key = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
			//Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		//	System.out.println("key:"+key);
			String token= Jwts.builder()
					.setSubject(email)
					.setIssuedAt(new Date())
					.setExpiration(Date.from(Instant.now().plus(8, ChronoUnit.DAYS)))
					.signWith(SignatureAlgorithm.HS256, secret)
					.compact();
			System.out.println("token:"+token);
			return token;
		} catch (Exception e) {
			System.out.println("Token generation error: " + e.getMessage());
			throw e;
		}
	}


	/*public String extractEmail(String token) {
		return Jwts.parser().setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody().getSubject();
	}*/
}
