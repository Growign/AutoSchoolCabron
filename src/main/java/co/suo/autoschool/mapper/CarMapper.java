package co.suo.autoschool.mapper;

import co.suo.autoschool.dto.CarDto;
import co.suo.autoschool.dto.creatingdto.CarCreatingDto;
import co.suo.autoschool.model.CarModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(source = "category.category", target = "categoryCategory")
    CarDto carModelToCarDto(CarModel carModel);

    @Mapping(source = "categoryId", target = "category.id")
    CarModel carCreatingDtoToCarModel(CarCreatingDto carCreatingDto);

    @Mapping(source = "category.id", target = "categoryId")
    CarCreatingDto carModelToCarCreatingDto(CarModel carModel);

    @Mapping(source = "categoryId", target = "category.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CarModel updateCarModelFromCarCreatingDto(CarCreatingDto carCreatingDto, @MappingTarget CarModel carModel);
}


