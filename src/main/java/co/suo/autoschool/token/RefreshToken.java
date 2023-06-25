package co.suo.autoschool.token;

import co.suo.autoschool.model.baseentity.BaseEntity;
import co.suo.autoschool.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RefreshToken extends BaseEntity {

    @Column(unique = true)
    private String RefreshToken;
    @Enumerated(EnumType.STRING)
    public TokenType tokenType;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
