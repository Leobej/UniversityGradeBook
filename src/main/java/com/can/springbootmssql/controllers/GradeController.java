package com.can.springbootmssql.controllers;


import com.can.springbootmssql.dtos.GradeDTO;
import com.can.springbootmssql.exceptions.ApiException;
import com.can.springbootmssql.interfaces.GradeService;
import com.can.springbootmssql.models.Grade;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
    public ResponseEntity<Object> updateGrade( @RequestBody GradeDTO gradeDTO) {
        gradeService.updateGrade( gradeDTO);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{gradeId}")
    public ResponseEntity<Object> deleteGrade(@PathVariable int gradeId){
       try {
           gradeService.deleteGrade(gradeId);
       }catch (ApiException e){
           System.out.println(e);
       }
        return ResponseEntity.ok().body(null);

       }
}
