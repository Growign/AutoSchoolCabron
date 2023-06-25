package co.suo.autoschool.repositoryInterface;

import co.suo.autoschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends BaseRepository<Student, Long> {

    List<Student> findByName(String name);

    Student findByUserId(Long id);
}
