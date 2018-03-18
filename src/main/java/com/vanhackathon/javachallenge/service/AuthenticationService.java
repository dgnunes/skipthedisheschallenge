/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.service;

import com.vanhackathon.javachallenge.dao.CustomerDAO;
import com.vanhackathon.javachallenge.model.Customer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author douglas
 */
public class AuthenticationService {
    
    private static final String MAGIC_WORD = "SKIPTHEDISHES";
    private static final int TTLMILLIS = 1000*60*15;
    
    public static String createToken(Customer customer){
        return createJWT(customer.getCustomerEmail());
    }
    
    public static boolean validateToken(String token){
        return isJWTValid(token);
    }
    
    private static String createJWT(String id) {
        long ttlMillis = TTLMILLIS;
        
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        
        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(MAGIC_WORD);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                                    .setIssuedAt(now)
                                    .signWith(signatureAlgorithm, signingKey);
        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
    
    private static boolean isJWTValid(String jwt) {
        
        try {
            //This line will throw an exception if it is not a signed JWS (as expected)
            Claims claims = Jwts.parser()         
               .setSigningKey(DatatypeConverter.parseBase64Binary(MAGIC_WORD))
               .parseClaimsJws(jwt).getBody();

            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    
    public static Customer parseJWTId(String jwt) {
        
        try {
            //This line will throw an exception if it is not a signed JWS (as expected)
            Claims claims = Jwts.parser()         
               .setSigningKey(DatatypeConverter.parseBase64Binary(MAGIC_WORD))
               .parseClaimsJws(jwt).getBody();

            CustomerDAO dao = new CustomerDAO();
            
            return dao.searchById(claims.getId());
        }
        catch (Exception e){
            return null;
        }
    }
}
