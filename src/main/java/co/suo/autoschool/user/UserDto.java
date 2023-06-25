package co.suo.autoschool.user;

import co.suo.autoschool.token.Token;
import co.suo.autoschool.user.Role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record UserDto(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, boolean active,
					  String email, String password, Role role) implements Serializable {
}
