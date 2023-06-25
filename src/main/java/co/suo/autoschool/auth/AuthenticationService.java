package co.suo.autoschool.auth;

import org.springframework.http.ResponseEntity;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthenticationService {
    public AuthenticationResponse register(RegisterRequest request) throws MessagingException;
    public ResponseEntity<?> authenticate(AuthenticationRequest request, HttpServletResponse response);
    public AuthenticationResponse refreshToken(HttpServletRequest request, HttpServletResponse response);
}
