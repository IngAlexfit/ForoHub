package com.challenge.ForoHub.alura.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String secretKey = "SecretKeyToGenJWTs";
    private final long validityInMilliseconds = 864_000_000; // 10 days

    public String createToken(String correoElectronico, Long authorId) {
        return Jwts.builder()
                .setSubject(correoElectronico)
                .claim("authorId", authorId)
                .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}