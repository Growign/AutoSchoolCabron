package co.suo.autoschool.token;

import co.suo.autoschool.user.User;

import java.time.LocalDateTime;

public record TokenDto(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, boolean active,
					   String token, TokenType tokenType, boolean revoked, boolean expired, User user) {
}
