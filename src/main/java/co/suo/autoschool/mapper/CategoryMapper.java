package co.suo.autoschool.mapper;

import co.suo.autoschool.dto.CategoryDto;
import co.suo.autoschool.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto categoryToCategoryDto(Category category);
}
