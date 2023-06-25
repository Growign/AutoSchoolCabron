package co.suo.autoschool.mapper;

import co.suo.autoschool.dto.StudentDto;
import co.suo.autoschool.dto.creatingdto.StudentCreatingDto;
import co.suo.autoschool.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CourseMapper.class, CategoryMapper.class})
public interface StudentMapper {
    StudentDto studentToStudentDto(Student student);

    Student studentCreatingDtoToStudent(StudentCreatingDto studentCreatingDto);
}
