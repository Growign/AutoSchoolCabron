package co.suo.autoschool.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link co.suo.autoschool.model.GroupModel} entity
 */
public record GroupDto(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, boolean active, String name,
                       String theoryTeacherName, String theoryTeacherSurname, List<CourseDto> courses) implements Serializable {
}