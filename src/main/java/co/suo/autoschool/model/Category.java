package co.suo.autoschool.model;

import co.suo.autoschool.model.baseentity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @NotBlank(message = "Cannot be blank!")
    @Column(name = "category", nullable = false)
    private String category;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CarModel> cars = new LinkedHashSet<>();

    @OneToMany(mappedBy = "studyingCategory")
    private Set<Course> courses = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Student> students = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<PracticalTeacherModel> practicalTeachers = new ArrayList<>();
}