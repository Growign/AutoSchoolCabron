package co.suo.autoschool.auth;

import co.suo.autoschool.dto.creatingdto.StudentCreatingDto;
import co.suo.autoschool.user.UserService;
import liquibase.pro.packaged.P;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationServiceImpl service;
	private final UserService userUervice;

	@GetMapping("/check-auth")
	public String checkAuth(Principal principal) {
		if(principal.getName()!=null){
			return userUervice.getUserRole(principal.getName());
		}
		return "";
	}

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody RegisterRequest request
	) throws MessagingException {
		return ResponseEntity.ok(service.register(request));
	}

	@GetMapping("/activate")
	public ResponseEntity<AuthenticationResponse> activate(@RequestParam(defaultValue = "") String activationCode) {
		return ResponseEntity.ok(service.activate(activationCode));
	}

	@PostMapping("/activate")
	public ResponseEntity<AuthenticationResponse> activate(@RequestParam(defaultValue = "") String activationCode, @RequestBody StudentCreatingDto studentCreatingDto) {
		return ResponseEntity.ok(service.studentCreating(activationCode, studentCreatingDto));
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(
			@RequestBody AuthenticationRequest request, HttpServletResponse response
	) {
		return ResponseEntity.ok(service.authenticate(request, response));
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(
			HttpServletResponse response
	) {
		return ResponseEntity.ok(service.logout(response));
	}

	@GetMapping("/refreshToken")
	public ResponseEntity<AuthenticationResponse> refreshToken(
			HttpServletRequest request, HttpServletResponse response
	) {
		var isTokenValid = service.refreshToken(request, response);
		if (isTokenValid != null) {
			return ResponseEntity.ok(isTokenValid);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
