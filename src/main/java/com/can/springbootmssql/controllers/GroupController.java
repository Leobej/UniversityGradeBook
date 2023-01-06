package com.can.springbootmssql.controllers;


import com.can.springbootmssql.dtos.GradeDTO;
import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.interfaces.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("")
    public ResponseEntity<Object> getAllGroups() {
        List<GroupDTO> groupDTOs = groupService.getAllGroups();
        return ResponseEntity.ok().body(groupDTOs);
    }

    @PostMapping("")
    public ResponseEntity<Object> addGroup(@RequestBody GroupDTO groupDTO) {
        groupService.saveGroup(groupDTO);
        return ResponseEntity.created(URI.create("")).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Object> updateGroup(int groupId, @RequestBody GroupDTO groupDTO) {
        groupService.updateGroup(groupId, groupDTO);
        return ResponseEntity.ok().body(groupDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<Object>  deleteGroup(int gradeId){
        groupService.deleteGroup(gradeId);
        return ResponseEntity.ok().body(null);
    };


}
