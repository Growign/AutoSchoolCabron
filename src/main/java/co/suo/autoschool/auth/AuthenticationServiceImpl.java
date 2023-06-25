package co.suo.autoschool.auth;

import co.suo.autoschool.dto.creatingdto.StudentCreatingDto;
import co.suo.autoschool.email.EmailServiceImpl;
import co.suo.autoschool.exceptionhandler.InvalidPasswordAccountException;
import co.suo.autoschool.exceptionhandler.VerifyAccountException;
import co.suo.autoschool.services.StudentService;
import co.suo.autoschool.token.*;
import co.suo.autoschool.config.JwtServiceImpl;
import co.suo.autoschool.user.Role;
import co.suo.autoschool.user.User;
import co.suo.autoschool.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenRepository refreshTokenRepository;
    private final EmailServiceImpl emailService;
    private final StudentService studentService;

    //TODO: добавити провірку одинакових email

    public AuthenticationResponse register(RegisterRequest request) throws MessagingException {
        if(repository.existsByEmail(request.getEmail())){
            throw new VerifyAccountException("User with this email is already exist");
        }
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .activationCode(UUID.randomUUID().toString())
                .build();
        user.setActive(false);
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        saveRefreshToken(user, refreshToken);
        emailService.sendEmail(user.getEmail(), "Account registration", user.getActivationCode());
        return AuthenticationResponse.builder()
                .message("Registration successful")
                .build();
    }

    //TODO: додати exception до аккаунта

    @Transactional
    public ResponseEntity<?> authenticate(AuthenticationRequest request, HttpServletResponse response) {
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidPasswordAccountException("User not found!"));
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        }catch (BadCredentialsException e){
            throw new InvalidPasswordAccountException("Invalid password!");
        }
        if(!user.isActive()){
            throw new VerifyAccountException("Please verify account");
        }
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        updateToken(user, jwtToken);
        updateRefreshToken(user, refreshToken);
        jwtService.setJwtCookies(response, jwtToken, refreshToken);
        return ResponseEntity.ok(AuthenticationResponse.builder().message("Authentication successful").build());
    }

    @Transactional
    public AuthenticationResponse refreshToken(HttpServletRequest request, HttpServletResponse response) {
        var refreshToken = jwtService.getRefreshTokenFromCookie(request);
        if (refreshToken != null && jwtService.isTokenGetSign(refreshToken) && refreshTokenRepository.findRefreshTokenByRefreshToken(refreshToken)) {
            var user = repository.findByEmail(jwtService.extractUsername(refreshToken))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
            var jwtToken = jwtService.generateToken(user);
            var newRefreshToken = jwtService.generateRefreshToken(user);
            updateToken(user, jwtToken);
            updateRefreshToken(user, newRefreshToken);
            jwtService.setJwtCookies(response, jwtToken, newRefreshToken);
            return AuthenticationResponse.builder().message("new Tokens").build();
        } else {
            return null;
        }
    }

    private void saveRefreshToken(User user, String refreshToken) {
        var token = RefreshToken.builder()
                .user(user)
                .RefreshToken(refreshToken)
                .tokenType(TokenType.BEARER)
                .build();
        refreshTokenRepository.save(token);
    }

    private void updateRefreshToken(User user, String refreshToken) {
        refreshTokenRepository.updateRefreshTokenById(user.getId(), refreshToken);
    }

    private void updateToken(User user, String token) {
        tokenRepository.updateTokenById(user.getId(), token);
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .build();
        tokenRepository.save(token);
    }

    @Transactional
    public AuthenticationResponse activate(String activationCode) {
        var user = repository.findByActivationCode(activationCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));

        return AuthenticationResponse.builder().message("User found").build();
    }

    @Transactional
    public AuthenticationResponse studentCreating(String activationCode, StudentCreatingDto studentCreatingDto) {
        var user = repository.findByActivationCode(activationCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
        user.setActivationCode(null);
        user.setActive(true);

        studentService.createStudent(studentCreatingDto, user.getId());
        return AuthenticationResponse.builder().message("User activated").build();
    }
}
