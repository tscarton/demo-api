package com.example.demo.services;

import java.util.Collections;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import io.jsonwebtoken.Jwts;  
import io.jsonwebtoken.SignatureAlgorithm; 

public class AuthenticationService {

    //24 hours
    static final long EXPIRATIONTIME = 864_000_00;  
    static final String SIGNINGKEY = "tscartonkey";  
    static final String BEARER_PREFIX = "Bearer";  

    static public void addJWTToken(HttpServletResponse response, String username) {  
        String JwtToken = Jwts.builder().setSubject(username)  
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))  
                .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)  
                .compact();  
        response.addHeader("Authorization", BEARER_PREFIX + " " + JwtToken);  
        response.addHeader("Access-Control-Expose-Headers", "Authorization");  
    } 

    static public Authentication getAuthentication(HttpServletRequest request) {  
        String token = request.getHeader("Authorization");  
        if (token != null) {  
            String user = Jwts.parser()  
                    .setSigningKey(SIGNINGKEY)  
                    .parseClaimsJws(token.replace(BEARER_PREFIX, ""))  
                    .getBody()  
                    .getSubject();  
  
            if (user != null) {  
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());  
            } else {  
                throw new RuntimeException("Authentication failed");  
            }  
        }  
        return null;  
    }  

}