package co.suo.autoschool.controllers;

import co.suo.autoschool.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class ProfileController {

	private final StudentService studentService;

	@GetMapping("/userData")
	public ResponseEntity<?> activate(Principal email) {
		return ResponseEntity.ok(studentService.getUserData(email));
	}
}
