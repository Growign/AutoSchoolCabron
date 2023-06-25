package co.suo.autoschool.services.serviceImpl;

import co.suo.autoschool.dto.CarDto;
import co.suo.autoschool.dto.creatingdto.CarCreatingDto;
import co.suo.autoschool.mapper.CarMapper;
import co.suo.autoschool.model.CarModel;
import co.suo.autoschool.repositoryInterface.CarRepository;
import co.suo.autoschool.repositoryInterface.CategoryRepository;
import co.suo.autoschool.services.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import org.springframework.data.domain.Pageable;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    private CarMapper carMapper;
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public CarDto saveCar(CarCreatingDto carCreatingDto) {
        log.info("Car saved");

        CarModel carModel = new CarModel();

            carModel.setBrand(carCreatingDto.brand());
            carModel.setModel(carCreatingDto.model());
            carModel.setGearbox(carCreatingDto.gearbox());
            carModel.setCategory(categoryRepository.findById(carCreatingDto.categoryId()).orElseThrow(() -> {throw new NoSuchElementException("Category not present by this id!!!");}));


        return carMapper.carModelToCarDto(carRepository.save(carModel));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CarDto> getAllCars(Pageable pageable) {
        log.info("Getting all cars");
        return carRepository.findAll(pageable).map(carMapper::carModelToCarDto);
    }

    @Override
    @Transactional(readOnly = true)
    public CarDto getCarById(Long id) {
        log.info("Getting car by id: " + id);
        return carMapper.carModelToCarDto(carRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Course not found by id: "+ id)));
    }

    @Override
    @Transactional
    public CarDto updateCarData(CarCreatingDto carCreatingDto, Long id) {
        log.info("Car data update");

        Optional<CarModel> tempCar = carRepository.findById(id);

        if (tempCar.isPresent()) {
            CarModel carModel = tempCar.get();

            return carMapper.carModelToCarDto(carRepository.save(updateCarFromCarCreatingDto(carCreatingDto, carModel)));
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    @Transactional
    public void deleteCarById(Long id) {
        log.info("Car deleted, id:" + id);
        carRepository.deleteById(id);
    }

    private CarModel updateCarFromCarCreatingDto(CarCreatingDto carCreatingDto, CarModel carModel) {
        if (carCreatingDto == null) {
            return carModel;
        }

        if (carCreatingDto.brand() != null) {
            carModel.setBrand(carCreatingDto.brand());
        }
        if (carCreatingDto.model() != null) {
            carModel.setModel(carCreatingDto.model());
        }
        if (carCreatingDto.gearbox() != null) {
            carModel.setGearbox(carCreatingDto.gearbox());
        }
        if (carCreatingDto.categoryId() != 0) {
            carModel.setCategory(categoryRepository.findByIdAndActive(carCreatingDto.categoryId(), true).orElseThrow(() -> {throw new NoSuchElementException("Category not present by this id!!!");}));
        }

        return carModel;
    }
}
