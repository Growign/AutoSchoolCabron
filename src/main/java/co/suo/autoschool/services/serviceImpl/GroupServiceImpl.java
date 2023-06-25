package co.suo.autoschool.services.serviceImpl;

import co.suo.autoschool.dto.GroupDto;
import co.suo.autoschool.dto.creatingdto.GroupCreatingDto;
import co.suo.autoschool.mapper.GroupMapper;
import co.suo.autoschool.model.Course;
import co.suo.autoschool.model.GroupModel;
import co.suo.autoschool.repositoryInterface.CourseRepository;
import co.suo.autoschool.repositoryInterface.GroupRepository;
import co.suo.autoschool.repositoryInterface.TheoryTeacherRepo;
import co.suo.autoschool.services.GroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;

import javax.persistence.EntityNotFoundException;
import org.springframework.data.domain.Pageable;
import java.util.*;

@AllArgsConstructor
@Slf4j
@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;
    private GroupMapper groupMapper;
    private TheoryTeacherRepo theoryTeacherRepo;

    @Override
    @Transactional
    public GroupDto saveGroup(GroupCreatingDto groupCreatingDto) {
        GroupModel groupModel = new GroupModel();

            groupModel.setName(groupCreatingDto.name());
            groupModel.setTheoryTeacher(theoryTeacherRepo.findByIdAndActive(groupCreatingDto.theoryTeacherId(), true).orElseThrow(() -> {throw new NoSuchElementException("Theory teacher not present by this id!!!");}));
            Set<Course> courses = new HashSet<>();


        return groupMapper.groupModelToGroupDto(groupRepository.save(groupModel));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GroupDto> getAllGroups(Pageable pageable) {
        return groupRepository.findAll(pageable).map(groupMapper::groupModelToGroupDto);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupDto getGroupById(Long id) {
        return groupMapper.groupModelToGroupDto(groupRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Group not found by id: "+ id)));
    }

    @Override
    @Transactional
    public GroupDto updateGroupData(GroupCreatingDto groupCreatingDto, Long id) {
        Optional<GroupModel> tempGroup = groupRepository.findById(id);

        if (tempGroup.isPresent()) {
            GroupModel group = tempGroup.get();

            return groupMapper.groupModelToGroupDto(groupRepository.save(updateGroupFromGroupCreatingDto(groupCreatingDto, group)));
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    @Transactional
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);
    }


    private GroupModel updateGroupFromGroupCreatingDto(GroupCreatingDto groupCreatingDto, GroupModel groupModel) {
        if (groupCreatingDto == null) {
            return groupModel;
        }

        if (groupCreatingDto.name() != null) {
            groupModel.setName(groupCreatingDto.name());
        }
        if (groupCreatingDto.theoryTeacherId() != null) {
            groupModel.setTheoryTeacher(theoryTeacherRepo.findByIdAndActive(groupCreatingDto.theoryTeacherId(), true).orElseThrow(() -> {throw new NoSuchElementException("Theory teacher not present by this id!!!");}));
        }

        return groupModel;
    }
}
