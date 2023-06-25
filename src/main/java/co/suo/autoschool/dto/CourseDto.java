package co.suo.autoschool.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link co.suo.autoschool.model.Course} entity
 */
public record CourseDto(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, boolean active,
                        String studyingCategoryCategory, String practicalTeacherName, String practicalTeacherSurname,
                        String educationForm, Integer payment, String category, String gearbox,
                        Integer experience) implements Serializable {
}