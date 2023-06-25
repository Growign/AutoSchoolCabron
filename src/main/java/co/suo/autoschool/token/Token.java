package co.suo.autoschool.token;

import co.suo.autoschool.model.baseentity.BaseEntity;
import co.suo.autoschool.user.User;

import lombok.*;

import javax.persistence.*;

//@Data
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token extends BaseEntity {


  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;


  @ManyToOne
  @JoinColumn(name = "user_id")
  public User user;
}
