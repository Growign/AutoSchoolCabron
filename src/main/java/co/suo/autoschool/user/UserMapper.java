package co.suo.autoschool.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserDto toDto(User user);

	User toEntity(UserDto userDto);
}
