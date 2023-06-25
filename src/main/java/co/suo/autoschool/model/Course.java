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
@Table(name = "courses")
public class Course extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studying_category_id", nullable = false)
    private Category studyingCategory;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "practical_teacher_id", nullable = false)
    private PracticalTeacherModel practicalTeacher;

    @Column(name = "education_form", nullable = false)
    private String educationForm;

    @Column(name = "payment", nullable = false)
    private Integer payment;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "gearbox", nullable = false)
    private String gearbox;

    @Column(name = "experience", nullable = false)
    private Integer experience;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private GroupModel group;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}