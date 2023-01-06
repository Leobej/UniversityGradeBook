package com.can.springbootmssql.controllers;


import com.can.springbootmssql.dtos.GradeDTO;
import com.can.springbootmssql.interfaces.GradeService;
import com.can.springbootmssql.models.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @GetMapping("")
    public ResponseEntity<Object> getAllGrades() {
        List<GradeDTO> gradeDTOS = gradeService.getAllGrades();
        return ResponseEntity.ok().body(gradeDTOS);
    }

    @PostMapping("")
    public ResponseEntity<Object> addGrade(@RequestBody GradeDTO gradeDTO) {
        gradeService.addGrade(gradeDTO);
        return ResponseEntity.created(URI.create("")).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Object> updateGrade(int gradeId, @RequestBody GradeDTO gradeDTO) {
        gradeService.updateGrade(gradeId, gradeDTO);
        return ResponseEntity.ok().body(gradeDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteGrade(int gradeId) {
        gradeService.deleteGrade(gradeId);
        return ResponseEntity.ok().body(null);
    }

    ;


}
