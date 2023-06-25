package co.suo.autoschool.dto;

import java.io.Serializable;

public record QuizQuestionDto(Long id, String jsonQuestion) implements Serializable {
}
