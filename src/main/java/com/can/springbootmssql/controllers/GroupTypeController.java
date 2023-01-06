package com.can.springbootmssql.controllers;

import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.GroupTypeDTO;
import com.can.springbootmssql.interfaces.GroupTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/grouptypes")
@RequiredArgsConstructor
public class GroupTypeController {
    private final GroupTypeService groupTypeService;

    @GetMapping("")
    public ResponseEntity<Object> getAllGroupTypes() {
        List<GroupTypeDTO> groupTypesDTOs = groupTypeService.getAllGroupTypes();
        return ResponseEntity.ok().body(groupTypesDTOs);
    }

    @PostMapping("")
    public ResponseEntity<Object> addGroupType(@RequestBody GroupTypeDTO groupTypeDTO) {
        groupTypeService.saveGroupType(groupTypeDTO);
        return ResponseEntity.created(URI.create("")).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Object> updateGroupType(int groupTypeId, @RequestBody GroupTypeDTO groupTypeDTO) {
        groupTypeService.updateGroupType(groupTypeId, groupTypeDTO);
        return ResponseEntity.ok().body(groupTypeDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteGroupType(int groupTypeId) {
        groupTypeService.deleteGroup(groupTypeId);

        return ResponseEntity.ok().body(null);
    }

    ;
}
