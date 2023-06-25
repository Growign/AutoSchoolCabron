package co.suo.autoschool.dto.creatingdto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * A DTO for the {@link co.suo.autoschool.model.CarModel} entity
 */
public record CarCreatingDto(@NotBlank(message = "Cannot be blank!") String brand,
                             @NotBlank(message = "Cannot be blank!") String model,
                             @NotBlank(message = "Cannot be blank!") String gearbox,
                             @Positive(message = "Cannot be zero or negative!") Long categoryId) implements Serializable {
}