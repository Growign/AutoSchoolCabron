package co.suo.autoschool.mapper;

import co.suo.autoschool.dto.GroupDto;
import co.suo.autoschool.dto.creatingdto.GroupCreatingDto;
import co.suo.autoschool.model.*;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface GroupMapper {
    @Mapping(source = "theoryTeacher.name", target = "theoryTeacherName")
    @Mapping(source = "theoryTeacher.surname", target = "theoryTeacherSurname")
    GroupDto groupModelToGroupDto(GroupModel groupModel);

    @Mapping(source = "theoryTeacherId", target = "theoryTeacher.id")
    GroupModel groupCreatingDtoToGroupModel(GroupCreatingDto groupCreatingDto);
}
