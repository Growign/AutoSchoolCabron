package co.suo.autoschool.repositoryInterface;

import co.suo.autoschool.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CarRepository extends BaseRepository<CarModel, Long> {
    List<CarModel> findByBrand(String name);
}
