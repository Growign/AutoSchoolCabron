package co.suo.autoschool.services;

import co.suo.autoschool.dto.CarDto;
import co.suo.autoschool.dto.creatingdto.CarCreatingDto;
import co.suo.autoschool.model.CarModel;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

@Service
public interface CarService {

    CarDto saveCar(CarCreatingDto carCreatingDto);

    Page<CarDto> getAllCars(Pageable pageable);

    CarDto getCarById(Long id);

    CarDto updateCarData(CarCreatingDto carCreatingDto, Long id);

    void deleteCarById(Long id);

}
