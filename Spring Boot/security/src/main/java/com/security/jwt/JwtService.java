package com.security.jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Component
public class JwtService {

    @Value("${spring.app.jwtSecret}")
    private  String SECRET_KEY ;

    @Value("${spring.app.jwtExpirationMs}")
    private  int jwtExpirationInMs ;

    private final  long refreshExpiration = 604800000;


    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);



    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
       byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
       return Keys.hmacShaKeyFor(keyBytes);
    }


    public String extractUserName(String token){
        return  extractClaim(token, Claims::getSubject);
    }


    public<T> T extractClaim(String token, Function<Claims, T> claimsResolver){
            final Claims claims = extractAllClaims(token);
            return claimsResolver.apply(claims);
    }



    public String generateToken(Map<String, Object> extraClaim, UserDetails userDetails){
        return  Jwts.builder()
                .setClaims(extraClaim)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS512)
                .compact();

    }


    public  String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }


    public boolean isTokenValid(String token , UserDetails userDetails){
        final  String username = extractUserName(token);
        logger.info("Username: checking valid token {}", username);
        try{
            boolean result = (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
            logger.info("Result: checking valid token {}", result);
            return result;
        }catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());

    }

    private Date extractExpiration(String token) {

        return extractClaim(token, Claims::getExpiration);

    }




}
