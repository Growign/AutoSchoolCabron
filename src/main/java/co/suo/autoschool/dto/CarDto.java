package co.suo.autoschool.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link co.suo.autoschool.model.CarModel} entity
 */
public record CarDto(Long id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, boolean active, String brand,
                     String model, String gearbox, String categoryCategory) implements Serializable {
}