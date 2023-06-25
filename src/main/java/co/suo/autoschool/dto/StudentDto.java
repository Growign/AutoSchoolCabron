package co.suo.autoschool.dto;

import co.suo.autoschool.user.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link co.suo.autoschool.model.Student} entity
 */
public record StudentDto(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, boolean active,
                         String name, String surname, Integer age, User user, List<CategoryDto> categories, List<CourseDto> courses) implements Serializable {
}