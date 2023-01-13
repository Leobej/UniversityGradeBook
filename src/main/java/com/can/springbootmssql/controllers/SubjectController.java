package com.can.springbootmssql.controllers;

import com.can.springbootmssql.dtos.SubjectDTO;
import com.can.springbootmssql.exceptions.ApiException;
import com.can.springbootmssql.interfaces.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {


    private final SubjectService subjectService;

    @GetMapping("")
    public ResponseEntity<Object> getAllSubjects() {
        List<SubjectDTO> subjectDTOs = subjectService.getAllSubjects();
        return ResponseEntity.ok().body(subjectDTOs);
    }

    @PostMapping("")
    public ResponseEntity<Object> addSubject(@RequestBody SubjectDTO subjectDTO) {
        subjectService.saveSubject(subjectDTO);
        return ResponseEntity.created(URI.create("")).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Object> updateSubject(@RequestBody SubjectDTO subjectDTO) throws ApiException {
        subjectService.updateSubject(subjectDTO);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Object> deleteSubject(@PathVariable int subjectId) throws ApiException {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok().body(null);
    }


}
