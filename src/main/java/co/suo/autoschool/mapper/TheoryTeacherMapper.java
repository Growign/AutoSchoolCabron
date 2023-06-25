package co.suo.autoschool.mapper;

import co.suo.autoschool.dto.TheoryTeacherDto;
import co.suo.autoschool.model.TheoryTeacherModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TheoryTeacherMapper {
    TheoryTeacherDto theoryTeacherModelToTheoryTeacherDto(TheoryTeacherModel theoryTeacherModel);
}
