package co.suo.autoschool.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class JwtServiceImpl {

	private static final String SECRET_KEY = "753778214125442A472D4B614E645267556B58703273357638792F423F452848";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}

	public String generateToken(
			Map<String, Object> extraClaims,
			UserDetails userDetails
	) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 300000)) // 1000 * 30 * 10
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	public String generateRefreshToken(UserDetails userDetails) {
		return generateRefreshToken(new HashMap<>(), userDetails);
	}

	public String generateRefreshToken(
			Map<String, Object> extraClaims,
			UserDetails userDetails
	) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.claim("Token", "Refresh")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 144000000)) // 10000 * 60 * 24 * 10
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	// TODO: refact code:
	public boolean isTokenGetSign(String token) {
		try {
			Jwts.parser().setSigningKey(getSignInKey()).parseClaimsJws(token).getBody();
			return true;
		} catch (SignatureException e) {
		} catch (MalformedJwtException e) {
		} catch (ExpiredJwtException e) {
		} catch (UnsupportedJwtException e) {
		} catch (IllegalArgumentException e) {
		}
		return false;
	}

	public String getAccessTokenFromCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("accessToken".equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public String getRefreshTokenFromCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("refreshToken".equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	//TODO:поміняти secure на true
	public void setJwtCookies(HttpServletResponse response, String accessToken, String refreshToken) {
		ResponseCookie accessTokenCookie = ResponseCookie.from("accessToken", accessToken)
				.httpOnly(true)
				.secure(false)
				.maxAge(300000)
				.path("/")
				.build();
		ResponseCookie refreshTokenCookie = ResponseCookie.from("refreshToken", refreshToken)
				.httpOnly(true)
				.secure(false)
				.maxAge(14400000)
				.path("/")
				.build();
		response.setHeader(HttpHeaders.SET_COOKIE, accessTokenCookie.toString());
		response.addHeader(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString());
	}

	public void deleteJwtCookies(HttpServletResponse response) {
		ResponseCookie accessTokenCookie = ResponseCookie.from("accessToken", "")
				.httpOnly(true)
				.secure(false)
				.maxAge(0)
				.path("/")
				.build();
		ResponseCookie refreshTokenCookie = ResponseCookie.from("refreshToken", "")
				.httpOnly(true)
				.secure(false)
				.maxAge(0)
				.path("/")
				.build();
		response.setHeader(HttpHeaders.SET_COOKIE, accessTokenCookie.toString());
		response.addHeader(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString());
	}


	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
