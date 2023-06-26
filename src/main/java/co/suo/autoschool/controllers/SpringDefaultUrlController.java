package co.suo.autoschool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringDefaultUrlController {
	@GetMapping("/login")
	public String showLoginPage() { return ""; }
	@GetMapping("/sign-up")
	public String showSignUpPage() { return ""; }
	@GetMapping("/profile")
	public String showProfilePage() { return ""; }
	@GetMapping("/about")
	public String showAboutPage() {
		return "";
	}
	@GetMapping("/teachers")
	public String showTeachersPage() {
		return "";
	}
	@GetMapping("/courses")
	public String showCoursesPage() {
		return "";
	}
	@GetMapping("/mistake")
	public String showMistakePage() {
		return "";
	}
	@GetMapping("/activate")
	public String showActivatePage() { return ""; }
	@GetMapping("/quiz")
	public String showQuizPage() { return ""; }
	@GetMapping("/admin")
	public String showAdminPage() { return ""; }
}
