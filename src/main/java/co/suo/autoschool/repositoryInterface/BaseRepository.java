package co.suo.autoschool.repositoryInterface;


import co.suo.autoschool.model.baseentity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Long> extends JpaRepository<T, ID>,
        PagingAndSortingRepository<T, ID> {
    @Override
    @Query("update #{#entityName} e set e.active=false where e.id = ?1")
    @Transactional
    @Modifying
    void deleteById(Long id);

    Optional<T> findByIdAndActive(Long id, boolean active);
}
