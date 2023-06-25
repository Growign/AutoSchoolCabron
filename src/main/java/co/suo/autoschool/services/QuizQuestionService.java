package co.suo.autoschool.services;

import co.suo.autoschool.dto.QuizQuestionDto;
import co.suo.autoschool.dto.creatingdto.CreateQuizQuestionDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface QuizQuestionService {
	String saveQuizQuestion(CreateQuizQuestionDto createQuizQuestionDto) throws IOException;

	List<QuizQuestionDto> getTwentyRandomQuestion() throws JsonProcessingException;
}
