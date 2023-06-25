package co.suo.autoschool.mapper;

import co.suo.autoschool.dto.QuizQuestionDto;
import co.suo.autoschool.dto.creatingdto.CreateQuizQuestionDto;
import co.suo.autoschool.model.QuizQuestion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.util.*;

@Mapper(componentModel = "spring")
public interface QuizQuestionMapper {
	QuizQuestionMapper INSTANCE = Mappers.getMapper(QuizQuestionMapper.class);

	@Mapping(target = "jsonQuestion", expression = "java(convertToJson(quizQuestion, objectMapper))")
	QuizQuestionDto toDto(QuizQuestion quizQuestion, ObjectMapper objectMapper) throws JsonProcessingException;

	@Mapping(target = "photo", ignore = true)
	QuizQuestion toEntity(CreateQuizQuestionDto createQuizQuestionDto);

	default String convertToJson(QuizQuestion quizQuestion, ObjectMapper objectMapper) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<>();
		map.put("text", quizQuestion.getText());
		map.put("correctAnswer", quizQuestion.getCorrectAnswer());
		map.put("answers", quizQuestion.getAnswers());
		map.put("photo", quizQuestion.getPhoto());
		return objectMapper.writeValueAsString(map);
	}

	default List<QuizQuestionDto> toDtoList(List<QuizQuestion> quizQuestions, ObjectMapper objectMapper) throws JsonProcessingException {
		List<QuizQuestionDto> quizQuestionDtos = new ArrayList<>();
		for (QuizQuestion quizQuestion : quizQuestions) {
			quizQuestionDtos.add(toDto(quizQuestion, objectMapper));
		}
		return quizQuestionDtos;
	}
}

