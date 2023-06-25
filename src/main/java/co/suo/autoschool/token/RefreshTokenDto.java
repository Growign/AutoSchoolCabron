package co.suo.autoschool.token;

import co.suo.autoschool.user.User;

import java.io.Serializable;
import java.time.LocalDateTime;

public record RefreshTokenDto(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, boolean active,
							  String RefreshToken, TokenType tokenType, User user) implements Serializable {
}
