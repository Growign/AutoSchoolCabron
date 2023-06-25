package co.suo.autoschool.token;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Long> {

  @Modifying
  @Query(value = "update Token t set t.token = :newToken where t.user.id = :id")
  void updateTokenById(Long id, String newToken);

  Optional<Token> findByToken(String token);
}
