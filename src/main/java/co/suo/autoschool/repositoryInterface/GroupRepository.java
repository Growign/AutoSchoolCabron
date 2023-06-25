package co.suo.autoschool.repositoryInterface;

import co.suo.autoschool.model.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GroupRepository extends BaseRepository<GroupModel, Long> {
}
