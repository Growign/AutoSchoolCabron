package co.suo.autoschool.dto.creatingdto;

import co.suo.autoschool.user.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link co.suo.autoschool.model.Student} entity
 */
public record StudentCreatingDto(@NotBlank(message = "Cannot be blank!") String name,
                                 @NotBlank(message = "Cannot be blank!") String surname,
                                 @Positive(message = "Cannot be zero or negative!") Integer age,
                                 @NotEmpty(message = "Cannot be empty!") List<Long> categoryIds) implements Serializable {
}