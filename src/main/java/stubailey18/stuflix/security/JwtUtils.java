package stubailey18.stuflix.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Component
public class JwtUtils {

    @Value("${jwtValidForMinutes}")
    private int jwtValidForMinutes;

    @Value("${jwtSecret}")
    private String jwtSecret;

    @Value("${userRole}")
    private String userRole;

    public String generateToken(UserDetails userDetails) {
        var timeNow = LocalDateTime.now();
        var expirationTime = timeNow.plus(jwtValidForMinutes, ChronoUnit.MINUTES);
        return JWT.create()
                .withClaim("una", userDetails.getUsername())
                .withClaim("uro", userRole)
                .withIssuedAt(Date.from(timeNow.atZone(ZoneId.systemDefault()).toInstant()))
                .withExpiresAt(Date.from(expirationTime.atZone(ZoneId.systemDefault()).toInstant()))
                .sign(Algorithm.HMAC256(jwtSecret));
    }

    public Map<String, Claim> verifyToken(String token) throws JWTVerificationException {
        var verifier = JWT.require(Algorithm.HMAC256(jwtSecret)).build();
        var decodedToken = verifier.verify(token);
        return decodedToken.getClaims();
    }
}
