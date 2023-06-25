package co.suo.autoschool.controllers;

import co.suo.autoschool.dto.QuizQuestionDto;
import co.suo.autoschool.dto.creatingdto.CreateQuizQuestionDto;
import co.suo.autoschool.services.QuizQuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartResolver;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/quiz")
public class QuizQuestionController {

	private final QuizQuestionService quizQuestionService;
	private MultipartResolver multipartResolver;

	@PostMapping("/saveQuiz")
	public ResponseEntity<QuizQuestionDto> saveQuizQuestion(@ModelAttribute CreateQuizQuestionDto createQuizQuestionDto) throws IOException {
		quizQuestionService.saveQuizQuestion(createQuizQuestionDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/getQuestion")
	public ResponseEntity<List<QuizQuestionDto>> getTwentyRandomQuestion() throws JsonProcessingException {
		List<QuizQuestionDto> quizQuestions = quizQuestionService.getTwentyRandomQuestion();
		return ResponseEntity.ok(quizQuestions);
	}

}
