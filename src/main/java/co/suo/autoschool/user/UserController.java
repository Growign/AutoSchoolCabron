package co.suo.autoschool.user;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping("/allUser")
	public ResponseEntity<Page<UserDto>> getAllUsers(@PageableDefault Pageable pageable) {
		Page<UserDto> users = userService.getAllUsers(pageable);
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@PutMapping("/allUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userChanges) {
		userService.changeUserInfo(id, userChanges);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
