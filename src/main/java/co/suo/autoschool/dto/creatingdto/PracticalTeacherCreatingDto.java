package co.suo.autoschool.dto.creatingdto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link co.suo.autoschool.model.PracticalTeacherModel} entity
 */
public record PracticalTeacherCreatingDto(@NotBlank(message = "Cannot be blank!") String name,
                                          @NotBlank(message = "Cannot be blank!") String surname,
                                          @NotEmpty(message = "Cannot be empty!") List<Long> categoryIds,
                                          @NotEmpty(message = "Cannot be empty!") List<Long> carIds) implements Serializable {
}