package com.company.demo.config.jwt;

import io.jsonwebtoken.*;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.company.demo.service.security.UserLoginPrinciple;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtProvider {

	@Value("${jwt.secret}")
    private String jwtSecret;
	
	@Value("${jwt.expiration}")
    private int jwtExpiration;
	
	public String generateJwtToken(Authentication authentication) {
        UserLoginPrinciple userPrincipal = (UserLoginPrinciple) authentication.getPrincipal();

        return Jwts.builder()
		                .setSubject((userPrincipal.getUsername()))
		                .setIssuedAt(new Date())
		                .setExpiration(new Date((new Date()).getTime() + jwtExpiration * 1000))
		                .signWith(SignatureAlgorithm.HS512, jwtSecret)
		                .compact();
    }
	
	  public boolean validateJwtToken(String authToken) {
	        try {
	            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
	            return true;
	        } catch (SignatureException e) {
	            log.error("Invalid JWT signature -> Message: {} ", e);
	        } catch (MalformedJwtException e) {
	        	log.error("Invalid JWT token -> Message: {}", e);
	        } catch (ExpiredJwtException e) {
	        	log.error("Expired JWT token -> Message: {}", e);
	        } catch (UnsupportedJwtException e) {
	        	log.error("Unsupported JWT token -> Message: {}", e);
	        } catch (IllegalArgumentException e) {
	        	log.error("JWT claims string is empty -> Message: {}", e);
	        }
	        
	        return false;
	  }
	  
	  public String getUserNameFromJwtToken(String token) {
	        return Jwts.parser()
				                .setSigningKey(jwtSecret)
				                .parseClaimsJws(token)
				                .getBody().getSubject();
	  }
	  
}
