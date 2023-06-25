package co.suo.autoschool.model;


import co.suo.autoschool.model.baseentity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "practical_teachers")
public class PracticalTeacherModel extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "practical_teachers_categories",
            joinColumns = @JoinColumn(name = "practical_teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "practicalTeacher")
    private Set<Course> courses = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "practical_teachers_cars",
            joinColumns = @JoinColumn(name = "practical_teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<CarModel> cars = new ArrayList<>();
}
