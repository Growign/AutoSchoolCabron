package co.suo.autoschool.services;

import co.suo.autoschool.dto.PracticalTeacherDto;
import co.suo.autoschool.dto.creatingdto.PracticalTeacherCreatingDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public interface PracticalTeacherService {
    PracticalTeacherDto createPracticalTeacher(PracticalTeacherCreatingDto practicalTeacherCreatingDto);

    Page<PracticalTeacherDto> getAllPracticalTeachers(Pageable pageable);

    PracticalTeacherDto getPracticalTeacherById(Long id);

    PracticalTeacherDto updatePracticalTeacherData(PracticalTeacherCreatingDto practicalTeacherCreatingDto, Long id);

    void deletePracticalTeacherById(Long id);
}
