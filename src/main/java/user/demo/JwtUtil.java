package user.demo;

import java.sql.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private String secret = "secreto";

    public String generateToken(UserDetails userDetails) {
        return ((Object) Jwts.builder())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(0, 0, 0))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims extractClaims(String token) {
        return ((Object) Jwts.parser())
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractClaims(token).getSubject();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
