package co.suo.autoschool.model;

import co.suo.autoschool.model.baseentity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class QuizQuestion extends BaseEntity {
	@Column(nullable = false)
	private String text;
	@Column(nullable = false)
	private String correctAnswer;
	@Column(nullable = false)
	@ElementCollection
	private List<String> answers;
	@Column
	private String photo;
}
