package co.suo.autoschool.services.serviceImpl;

import co.suo.autoschool.dto.QuizQuestionDto;
import co.suo.autoschool.dto.creatingdto.CreateQuizQuestionDto;
import co.suo.autoschool.mapper.QuizQuestionMapper;
import co.suo.autoschool.model.QuizQuestion;
import co.suo.autoschool.repositoryInterface.QuizQuestionRepository;
import co.suo.autoschool.services.QuizQuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@AllArgsConstructor
@Service
public class QuizQuestionServiceImpl implements QuizQuestionService {

	private final QuizQuestionRepository quizQuestionRepository;
	private final ObjectMapper objectMapper;

	private String savePhoto(MultipartFile photo) throws IOException {
		String externalDirectoryPath = "/quizPhotos";
    		File externalDirectory = new File(externalDirectoryPath);
   		if (!externalDirectory.exists()) {
        		externalDirectory.mkdirs();
    		}
	   	try {
	        	String photoOriginalName = photo.getOriginalFilename();
	        	File destinationFile = new File(externalDirectory, photoOriginalName);
	
	        	photo.transferTo(destinationFile);
	
	        	return photoOriginalName;
	    	} catch (IOException e) {
	        	return null;
	    	}
	}

	@Override
	@Transactional
	public String saveQuizQuestion(CreateQuizQuestionDto createQuizQuestionDto) throws IOException {
		QuizQuestion quizQuestion = QuizQuestionMapper.INSTANCE.toEntity(createQuizQuestionDto);
		MultipartFile photo = createQuizQuestionDto.photo();
		String photoPath = savePhoto(photo);
		quizQuestion.setPhoto(photoPath);
		quizQuestion = quizQuestionRepository.save(quizQuestion);
		QuizQuestionDto quizQuestionDto = QuizQuestionMapper.INSTANCE.toDto(quizQuestion, objectMapper);
		return objectMapper.writeValueAsString(quizQuestionDto);
	}

	@Override
	@Transactional(readOnly = true)
	public List<QuizQuestionDto> getTwentyRandomQuestion() throws JsonProcessingException {
		List<QuizQuestion> randomQuestions = quizQuestionRepository.findRandomQuestions();
		return QuizQuestionMapper.INSTANCE.toDtoList(randomQuestions, objectMapper);
	}

}

