package co.suo.autoschool.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link co.suo.autoschool.model.Category} entity
 */
public record CategoryDto(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, boolean active,
                          String category) implements Serializable {
}