package co.suo.autoschool.dto.creatingdto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link co.suo.autoschool.model.GroupModel} entity
 */
public record GroupCreatingDto(@NotBlank(message = "Cannot be blank!") String name,
                               @Positive(message = "Cannot be zero or negative!") Long theoryTeacherId) implements Serializable {
}