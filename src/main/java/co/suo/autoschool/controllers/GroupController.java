package co.suo.autoschool.controllers;

import co.suo.autoschool.dto.GroupDto;
import co.suo.autoschool.dto.creatingdto.GroupCreatingDto;
import co.suo.autoschool.services.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;
    public GroupController(GroupService groupService) {this.groupService = groupService;}

    @GetMapping
    public ResponseEntity<Page<GroupDto>> getAllGroup(@PageableDefault Pageable pageable){
        Page<GroupDto> group = groupService.getAllGroups(pageable);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<GroupDto> getGroupById(@PathVariable Long id){
        GroupDto group = groupService.getGroupById(id);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GroupDto> createGroup(@Valid @RequestBody GroupCreatingDto groupCreatingDto){
        groupService.saveGroup(groupCreatingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<GroupDto> updateGroup(@RequestBody GroupCreatingDto groupCreatingDto, @PathVariable Long id){
        groupService.updateGroupData(groupCreatingDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<GroupDto> deleteGroup(@PathVariable Long id){
        groupService.deleteGroupById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
