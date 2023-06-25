package co.suo.autoschool.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link co.suo.autoschool.model.PracticalTeacherModel} entity
 */
public record PracticalTeacherDto(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, boolean active,
                                  String name, String surname, List<CategoryDto> categories, List<CarDto> cars) implements Serializable {
}