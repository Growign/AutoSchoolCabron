package co.suo.autoschool.model;

import co.suo.autoschool.model.baseentity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "theory_teachers")
public class TheoryTeacherModel extends BaseEntity {
    @NotBlank(message = "Cannot be blank!")
    @Column(name = "name", nullable = false)
    private String name;
    @NotBlank(message = "Cannot be blank!")
    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToMany(mappedBy = "theoryTeacher")
    private Set<GroupModel> groups = new LinkedHashSet<>();
}