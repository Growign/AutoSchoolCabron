package co.suo.autoschool.dto.creatingdto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * A DTO for the {@link co.suo.autoschool.model.Course} entity
 */
public record CourseCreatingDto(@NotNull(message = "Cannot be null!") boolean active,
                                @Positive(message = "Cannot be zero or negative!") Long studyingCategoryId,
                                @Positive(message = "Cannot be zero or negative!") Long practicalTeacherId,
                                @NotBlank(message = "Cannot be blank!") String educationForm,
                                @Positive(message = "Cannot be zero or negative!") Integer payment,
                                @NotBlank(message = "Cannot be blank!") String category,
                                @NotBlank(message = "Cannot be blank!") String gearbox,
                                @Positive(message = "Cannot be zero or negative!") Integer experience,
                                @Positive(message = "Cannot be zero or negative!") Long groupId) implements Serializable {
}