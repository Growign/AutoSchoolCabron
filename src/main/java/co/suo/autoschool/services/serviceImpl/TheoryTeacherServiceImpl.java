package co.suo.autoschool.services.serviceImpl;

import co.suo.autoschool.dto.TheoryTeacherDto;
import co.suo.autoschool.mapper.TheoryTeacherMapper;
import co.suo.autoschool.model.Category;
import co.suo.autoschool.model.TheoryTeacherModel;
import co.suo.autoschool.repositoryInterface.TheoryTeacherRepo;
import co.suo.autoschool.services.TheoryTeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class TheoryTeacherServiceImpl implements TheoryTeacherService {

    private TheoryTeacherRepo theoryTeacherRepo;
    private TheoryTeacherMapper theoryTeacherMapper;

    @Override
    @Transactional
    public TheoryTeacherDto saveTheoryTeacher(TheoryTeacherModel theoryTeacher) {
        log.info("Teacher saved");
        return theoryTeacherMapper.theoryTeacherModelToTheoryTeacherDto(theoryTeacherRepo.save(theoryTeacher));
    }

    @Override
    @Transactional
    public Page<TheoryTeacherDto> getAllTeachers(Pageable pageable) {
        return theoryTeacherRepo.findAll(pageable).map(theoryTeacherMapper::theoryTeacherModelToTheoryTeacherDto);
    }

    @Override
    @Transactional
    public TheoryTeacherDto getTeacherById(Long id) {
        return theoryTeacherMapper.theoryTeacherModelToTheoryTeacherDto(theoryTeacherRepo.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Teacher not found by id: "+ id)));
    }

    @Override
    @Transactional
    public TheoryTeacherDto updateTheoryTeacherData(TheoryTeacherModel theoryTeacher, Long id) {
        Optional<TheoryTeacherModel> tempTheoryTeacher = theoryTeacherRepo.findById(id);

        if (tempTheoryTeacher.isPresent()) {
            TheoryTeacherModel presentTheoryTeacher = tempTheoryTeacher.get();
            setAllFieldsForTheoryTeacher(theoryTeacher, presentTheoryTeacher);

            return theoryTeacherMapper.theoryTeacherModelToTheoryTeacherDto(theoryTeacherRepo.save(presentTheoryTeacher));
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    @Transactional
    public void deleteCourseById(Long id) {
        theoryTeacherRepo.deleteById(id);
    }

    private void setAllFieldsForTheoryTeacher(TheoryTeacherModel theoryTeacherModel, TheoryTeacherModel theoryTeacherForUpdate) {
        if (theoryTeacherModel == null) {
            return;
        }

        if (theoryTeacherModel.getName() != null) {
            theoryTeacherForUpdate.setName(theoryTeacherModel.getName());
        }
        if (theoryTeacherModel.getSurname() != null) {
            theoryTeacherForUpdate.setSurname(theoryTeacherModel.getSurname());
        }
    }
}
