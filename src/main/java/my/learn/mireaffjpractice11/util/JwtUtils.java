package my.learn.mireaffjpractice11.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice11.exception.JWTException;
import my.learn.mireaffjpractice11.model.TokenType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtUtils {

    private final SecretKey secretKey;

    public String generateToken(UserDetails userDetails,
                                Date issuedAt,
                                Date expiresAt,
                                TokenType tokenType) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("iat", issuedAt.getTime());
        claims.put("exp", expiresAt.getTime());
        claims.put("ath", userDetails.getAuthorities());
        claims.put("type", tokenType.toString());

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claims(claims)
                .issuedAt(issuedAt)
                .expiration(expiresAt)
                .signWith(secretKey)
                .compact();
    }

    private Claims getClaimsFromToken(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException | IllegalArgumentException e) {
            throw new JWTException(e.getMessage());
        }

    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public List<String> getAuthoritiesFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.get("ath", List.class);
    }

    public TokenType getTokenTypeFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return TokenType.valueOf((String) claims.get("type"));
    }







}
