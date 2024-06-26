package com.springbootmssql.controllers;


import com.springbootmssql.dtos.GroupDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.GroupService;
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
    public ResponseEntity<Object> updateGroup(@RequestBody GroupDTO groupDTO) throws ApiException {
        groupService.updateGroup(groupDTO);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<Object> deleteGroup(@PathVariable int groupId) throws ApiException {
        groupService.deleteGroup(groupId);
        return ResponseEntity.ok().body(null);
    }


}
