package co.suo.autoschool.dto.creatingdto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

public record CreateQuizQuestionDto(String text, String correctAnswer, List<String> answers, MultipartFile photo) implements Serializable {
}
