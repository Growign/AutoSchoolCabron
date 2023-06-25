package co.suo.autoschool.services.serviceImpl;

import co.suo.autoschool.dto.CourseDto;
import co.suo.autoschool.dto.creatingdto.CourseCreatingDto;
import co.suo.autoschool.mapper.CourseMapper;
import co.suo.autoschool.model.Course;
import co.suo.autoschool.repositoryInterface.CategoryRepository;
import co.suo.autoschool.repositoryInterface.CourseRepository;
import co.suo.autoschool.repositoryInterface.GroupRepository;
import co.suo.autoschool.repositoryInterface.PracticalTeacherRepository;
import co.suo.autoschool.services.CourseService;
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
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private CourseMapper courseMapper;
    private CategoryRepository categoryRepository;
    private PracticalTeacherRepository practicalTeacherRepository;
    private GroupRepository groupRepository;

    @Override
    @Transactional
    public CourseDto saveCourse(CourseCreatingDto courseCreatingDto) {
        log.info("Course saved");
        Course course = new Course();

        course.setStudyingCategory(categoryRepository.findByIdAndActive(courseCreatingDto.studyingCategoryId(), true).orElseThrow(() -> {throw new NoSuchElementException("Category not present by this id!!!");}));
        course.setPracticalTeacher(practicalTeacherRepository.findByIdAndActive(courseCreatingDto.practicalTeacherId(), true).orElseThrow(() -> {throw new NoSuchElementException("Practical teacher not present by this id!!!");}));
        course.setEducationForm(courseCreatingDto.educationForm());
        course.setPayment(courseCreatingDto.payment());
        course.setCategory(courseCreatingDto.category());
        course.setExperience(courseCreatingDto.experience());
        course.setGearbox(courseCreatingDto.gearbox());
        course.setGroup(groupRepository.findByIdAndActive(courseCreatingDto.groupId(), true).orElseThrow(() -> {throw new NoSuchElementException("Group not present by this id!!!");}));

        return courseMapper.courseToCourseDto(courseRepository.save(course));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CourseDto> getAllCourses(Pageable pageable) {
        log.info("Getting all course");
        return courseRepository.findAll(pageable).map(courseMapper::courseToCourseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseDto getCourseById(Long id) {
        log.info("Getting course by id:" + id);
        return courseMapper.courseToCourseDto(courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found by id: " + id)));
    }

    @Override
    @Transactional
    public CourseDto updateCourseData(CourseCreatingDto courseCreatingDto, Long id) {
        log.info("Course data update");
        Optional<Course> tempCourse = courseRepository.findById(id);

        if (tempCourse.isPresent()) {
            Course course = tempCourse.get();

            return courseMapper.courseToCourseDto(courseRepository.save(updateCourseFromCourseCreatingDto(courseCreatingDto, course)));
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    @Transactional
    public void deleteCourseById(Long id) {
        log.info("Course deleted, id:" + id);
        courseRepository.deleteById(id);
    }

    private Course updateCourseFromCourseCreatingDto(CourseCreatingDto courseCreatingDto, Course course) {
        if (courseCreatingDto == null) {
            return course;
        }

        if (courseCreatingDto.studyingCategoryId() != null) {
            course.setStudyingCategory(categoryRepository.findByIdAndActive(courseCreatingDto.studyingCategoryId(), true).orElseThrow(() -> {throw new NoSuchElementException("Category not present by this id!!!");}));
        }
        if (courseCreatingDto.practicalTeacherId() != null) {
            course.setPracticalTeacher(practicalTeacherRepository.findByIdAndActive(courseCreatingDto.practicalTeacherId(),true).orElseThrow(() -> {throw new NoSuchElementException("Practical teacher not present by this id!!!");}));
        }
        if (courseCreatingDto.educationForm() != null) {
            course.setEducationForm(courseCreatingDto.educationForm());
        }
        if (courseCreatingDto.payment() != null) {
            course.setPayment(courseCreatingDto.payment());
        }
        if (courseCreatingDto.category() != null) {
            course.setCategory(courseCreatingDto.category());
        }
        if (courseCreatingDto.experience() != null) {
            course.setExperience(courseCreatingDto.experience());
        }
        if (courseCreatingDto.gearbox() != null) {
            course.setGearbox(courseCreatingDto.gearbox());
        }
        if (courseCreatingDto.groupId() != null) {
            course.setGroup(groupRepository.findByIdAndActive(courseCreatingDto.groupId(), true).orElseThrow(() -> {throw new NoSuchElementException("Group not present by this id!!!");}));
        }

        return course;
    }
}
