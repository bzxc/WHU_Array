package com.array.arrayserver.Utils;

import com.array.arrayserver.constants.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;


/**
 * @author yee
 */
public class JwtUtils {


    private static final byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SecurityConstants.JWT_SECRET_KEY);
    private static final SecretKey secretKey = Keys.hmacShaKeyFor(apiKeySecretBytes);

    public static String generateToken(String username, String role, boolean isRememberMe) {
        long expiration = isRememberMe ? SecurityConstants.EXPIRATION_REMEMBER : SecurityConstants.EXPIRATION;
        return SecurityConstants.TOKEN_PREFIX +
                Jwts.builder()
                .setHeaderParam("type", SecurityConstants.TOKEN_TYPE)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .setSubject(username)
                .claim(SecurityConstants.ROLE_CLAIMS, role)
                .setIssuer("Array")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    public static String getUsernameByToken(String token) {
        return getTokenBody(token).getSubject();
    }


    public static String getUserRolesByToken(String token) {

        String role = (String) getTokenBody(token)
                .get(SecurityConstants.ROLE_CLAIMS);
        return role;
    }
    // 是否已过期
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
