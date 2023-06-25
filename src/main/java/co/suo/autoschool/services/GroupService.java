package co.suo.autoschool.services;


import co.suo.autoschool.dto.GroupDto;
import co.suo.autoschool.dto.creatingdto.GroupCreatingDto;
import co.suo.autoschool.model.GroupModel;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;


public interface GroupService {

    GroupDto saveGroup(GroupCreatingDto groupCreatingDto);

    Page<GroupDto> getAllGroups(Pageable pageable);

    GroupDto getGroupById(Long id);

    GroupDto updateGroupData(GroupCreatingDto groupCreatingDto, Long id);

    void deleteGroupById(Long id);
    
}
