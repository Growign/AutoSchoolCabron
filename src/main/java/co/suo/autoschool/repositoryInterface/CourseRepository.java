package co.suo.autoschool.repositoryInterface;

import co.suo.autoschool.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CourseRepository extends BaseRepository<Course, Long> {
}
