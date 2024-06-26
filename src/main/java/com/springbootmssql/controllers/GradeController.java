package com.springbootmssql.controllers;


import com.springbootmssql.dtos.GradeDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.GradeService;
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
    public ResponseEntity<Object> updateGrade(@RequestBody GradeDTO gradeDTO) throws ApiException {
        gradeService.updateGrade(gradeDTO);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{gradeId}")
    public ResponseEntity<Object> deleteGrade(@PathVariable int gradeId) throws ApiException {
        gradeService.deleteGrade(gradeId);
        return ResponseEntity.ok().body(null);

    }
}
