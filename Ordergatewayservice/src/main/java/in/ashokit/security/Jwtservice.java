package in.ashokit.security;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;



@Component
public class Jwtservice {

    // Same secret as AuthService
    public static final String SECRET = "357638792F423F4428472B4B6250655368566D597133743677397A2443264629";

    private Key getSignKey() {
        // Decode the secret as Base64, same as AuthService
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                   .setSigningKey(getSignKey())
                   .build()
                   .parseClaimsJws(token)
                   .getBody();
    }
}

	



