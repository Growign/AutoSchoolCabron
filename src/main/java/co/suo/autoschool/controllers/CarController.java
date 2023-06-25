package co.suo.autoschool.controllers;

import co.suo.autoschool.dto.CarDto;
import co.suo.autoschool.dto.creatingdto.CarCreatingDto;
import co.suo.autoschool.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;

@RestController
@AllArgsConstructor
@RequestMapping("/car")
public class CarController {

   private final CarService carService;

    @GetMapping
    public ResponseEntity<Page<CarDto>> getAllCars(@PageableDefault Pageable pageable){
        Page<CarDto> cars = carService.getAllCars(pageable);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id){
        CarDto car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarDto> saveCar(@Valid @RequestBody CarCreatingDto carCreatingDto){
        carService.saveCar(carCreatingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<CarDto> updateCar(@RequestBody CarCreatingDto carCreatingDto, @PathVariable Long id){
        carService.updateCarData(carCreatingDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CarDto> deleteCar(@PathVariable Long id){
        carService.deleteCarById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
