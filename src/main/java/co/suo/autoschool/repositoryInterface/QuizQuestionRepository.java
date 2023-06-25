package co.suo.autoschool.repositoryInterface;

import co.suo.autoschool.model.QuizQuestion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface QuizQuestionRepository extends BaseRepository<QuizQuestion, Long> {
	@Query(value = "SELECT * FROM quiz_question ORDER BY RANDOM() LIMIT 20", nativeQuery = true)
	List<QuizQuestion> findRandomQuestions();
}
