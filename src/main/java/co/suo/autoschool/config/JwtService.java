package co.suo.autoschool.config;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    public String extractUsername(String token);
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    public String generateToken(UserDetails userDetails);
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    );
    public String generateRefreshToken(UserDetails userDetails);
    public String generateRefreshToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    );
    public boolean isTokenGetSign(String token);
    public String getAccessTokenFromCookie(HttpServletRequest request);
    public String getRefreshTokenFromCookie(HttpServletRequest request);
    public void setJwtCookies(HttpServletResponse response, String accessToken, String refreshToken);
    public boolean isTokenValid(String token, UserDetails userDetails);
}
