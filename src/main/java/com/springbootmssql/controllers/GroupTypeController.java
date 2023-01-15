package com.springbootmssql.controllers;

import com.springbootmssql.dtos.GroupTypeDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.GroupTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
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
    public ResponseEntity<Object> updateGroupType(@RequestBody GroupTypeDTO groupTypeDTO) throws ApiException {

        groupTypeService.updateGroupType(groupTypeDTO);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{groupTypeId}")
    public ResponseEntity<Object> deleteGroupType(@PathVariable int groupTypeId) throws ApiException {
        groupTypeService.deleteGroup(groupTypeId);
        return ResponseEntity.ok().body(null);
    }

}
