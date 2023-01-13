package com.can.springbootmssql.controllers;


import com.can.springbootmssql.dtos.SubjectTypeDTO;
import com.can.springbootmssql.exceptions.ApiException;
import com.can.springbootmssql.interfaces.SubjectTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/subjecttypes")
@RequiredArgsConstructor
public class SubjectTypeController {

    private final SubjectTypeService subjectTypeService;

    @GetMapping("")
    public ResponseEntity<Object> getAllSubjectTypes() {
        List<SubjectTypeDTO> subjectTypesDTOs = subjectTypeService.getAllSubjectTypes();
        return ResponseEntity.ok().body(subjectTypesDTOs);
    }

    @PostMapping("")
    public ResponseEntity<Object> addSubjectType(@RequestBody SubjectTypeDTO subjectTypeDTO) {
        subjectTypeService.saveSubjectType(subjectTypeDTO);
        return ResponseEntity.created(URI.create("")).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Object> updateSubjectType(@RequestBody SubjectTypeDTO subjectTypeDTO) throws ApiException {
        subjectTypeService.updateSubjectType(subjectTypeDTO);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{subjectTypeId}")
    public ResponseEntity<Object> deleteSubjectType(@PathVariable int subjectTypeId) throws ApiException {
        subjectTypeService.deleteSubjectType(subjectTypeId);
        return ResponseEntity.ok().body(null);
    }
}
