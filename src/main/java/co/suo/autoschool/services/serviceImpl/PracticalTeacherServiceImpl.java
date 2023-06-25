package co.suo.autoschool.services.serviceImpl;

import co.suo.autoschool.dto.PracticalTeacherDto;
import co.suo.autoschool.dto.creatingdto.PracticalTeacherCreatingDto;
import co.suo.autoschool.mapper.PracticalTeacherMapper;
import co.suo.autoschool.model.CarModel;
import co.suo.autoschool.model.Category;
import co.suo.autoschool.model.PracticalTeacherModel;
import co.suo.autoschool.repositoryInterface.CarRepository;
import co.suo.autoschool.repositoryInterface.CategoryRepository;
import co.suo.autoschool.repositoryInterface.PracticalTeacherRepository;
import co.suo.autoschool.services.PracticalTeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;

import javax.persistence.EntityNotFoundException;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class PracticalTeacherServiceImpl implements PracticalTeacherService {

    private PracticalTeacherRepository practicalTeacherRepository;
    private PracticalTeacherMapper practicalTeacherMapper;
    private CategoryRepository categoryRepository;
    private CarRepository carRepository;

    @Override
    @Transactional
    public PracticalTeacherDto createPracticalTeacher(PracticalTeacherCreatingDto practicalTeacherCreatingDto) {
        log.info("Teacher created");
        PracticalTeacherModel practicalTeacherModel = new PracticalTeacherModel();

            practicalTeacherModel.setName(practicalTeacherCreatingDto.name());

            practicalTeacherModel.setSurname(practicalTeacherCreatingDto.surname());

            List<Category> categories = new ArrayList<>();
            practicalTeacherCreatingDto.categoryIds().forEach(id -> categories.add(categoryRepository.findByIdAndActive(id, true).orElseThrow(() -> {throw new NoSuchElementException("Category not present by this id!!!");})));
            practicalTeacherModel.setCategories(categories);

            List<CarModel> cars = new ArrayList<>();
            practicalTeacherCreatingDto.carIds().forEach(id -> cars.add(carRepository.findByIdAndActive(id, true).orElseThrow(() -> {throw new NoSuchElementException("Car not present by this id!!!");})));
            practicalTeacherModel.setCars(cars);

        return practicalTeacherMapper.practicalTeacherModelToPracticalTeacherDto(practicalTeacherRepository.save(practicalTeacherModel));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PracticalTeacherDto> getAllPracticalTeachers(Pageable pageable) {
        log.info("Getting teachers");
        return practicalTeacherRepository.findAll(pageable).map(practicalTeacherMapper::practicalTeacherModelToPracticalTeacherDto);
    }

    @Override
    @Transactional(readOnly = true)
    public PracticalTeacherDto getPracticalTeacherById(Long id) {
        log.info("Getting teacher");
        return practicalTeacherMapper.practicalTeacherModelToPracticalTeacherDto(practicalTeacherRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Teacher not found by id: "+id)));
    }

    @Override
    @Transactional
    public PracticalTeacherDto updatePracticalTeacherData(PracticalTeacherCreatingDto practicalTeacherCreatingDto, Long id) {
        log.info("Practical teacher data update");
        Optional<PracticalTeacherModel> tempPracticalTeacher = practicalTeacherRepository.findById(id);

        if (tempPracticalTeacher.isPresent()) {
            PracticalTeacherModel practicalTeacherModel = tempPracticalTeacher.get();

            return practicalTeacherMapper.practicalTeacherModelToPracticalTeacherDto(practicalTeacherRepository.save(updatePracticalTeacherFromPracticalTeacherCreatingDto(practicalTeacherCreatingDto, practicalTeacherModel)));
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    @Transactional
    public void deletePracticalTeacherById(Long id) {
        log.info("Course deleted, id:" + id);
        practicalTeacherRepository.deleteById(id);
    }

    private PracticalTeacherModel updatePracticalTeacherFromPracticalTeacherCreatingDto(PracticalTeacherCreatingDto practicalTeacherCreatingDto, PracticalTeacherModel practicalTeacherModel) {
        if (practicalTeacherCreatingDto == null) {
            return practicalTeacherModel;
        }


        if (practicalTeacherCreatingDto.name() != null) {
            practicalTeacherModel.setName(practicalTeacherCreatingDto.name());
        }
        if (practicalTeacherCreatingDto.surname() != null) {
            practicalTeacherModel.setSurname(practicalTeacherCreatingDto.surname());
        }
        if (practicalTeacherCreatingDto.categoryIds() != null) {
            List<Category> categories = new ArrayList<>();
            practicalTeacherCreatingDto.categoryIds().forEach(id -> categories.add(categoryRepository.findByIdAndActive(id, true).orElseThrow(() -> {throw new NoSuchElementException("Category not present by this id!!!");})));
            practicalTeacherModel.setCategories(categories);

        }
        if (practicalTeacherCreatingDto.carIds() != null) {
            List<CarModel> cars = new ArrayList<>();
            practicalTeacherCreatingDto.categoryIds().forEach(id -> cars.add(carRepository.findByIdAndActive(id, true).orElseThrow(() -> {throw new NoSuchElementException("Category not present by this id!!!");})));
            practicalTeacherModel.setCars(cars);
        }

        return practicalTeacherModel;
    }
}
