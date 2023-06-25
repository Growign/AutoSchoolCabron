package co.suo.autoschool.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link co.suo.autoschool.model.TheoryTeacherModel} entity
 */
public record TheoryTeacherDto(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, boolean active,
                               String name, String surname) implements Serializable {
}