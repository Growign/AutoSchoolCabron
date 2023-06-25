package co.suo.autoschool.mapper;

import co.suo.autoschool.dto.CourseDto;
import co.suo.autoschool.dto.creatingdto.CourseCreatingDto;
import co.suo.autoschool.model.*;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(source = "studyingCategory.category", target = "studyingCategoryCategory")
    @Mapping(source = "practicalTeacher.name", target = "practicalTeacherName")
    @Mapping(source = "practicalTeacher.surname", target = "practicalTeacherSurname")
    CourseDto courseToCourseDto(Course course);

    @Mapping(source = "studyingCategoryId", target = "studyingCategory.id")
    @Mapping(source = "practicalTeacherId", target = "practicalTeacher.id")
    @Mapping(source = "groupId", target = "group.id")
    Course courseCreatingDtoToCourse(CourseCreatingDto courseCreatingDto);
}
