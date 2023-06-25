package co.suo.autoschool.mapper;

import co.suo.autoschool.dto.PracticalTeacherDto;
import co.suo.autoschool.dto.creatingdto.PracticalTeacherCreatingDto;
import co.suo.autoschool.model.CarModel;
import co.suo.autoschool.model.Category;
import co.suo.autoschool.model.Course;
import co.suo.autoschool.model.PracticalTeacherModel;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, CarMapper.class})
public interface PracticalTeacherMapper {
    PracticalTeacherDto practicalTeacherModelToPracticalTeacherDto(PracticalTeacherModel practicalTeacherModel);

    PracticalTeacherModel practicalTeacherCreatingDtoToPracticalTeacherModel(PracticalTeacherCreatingDto practicalTeacherCreatingDto);
}
