package com.can.springbootmssql.controllers;


import com.can.springbootmssql.models.Grade;
import com.can.springbootmssql.interfaces.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @GetMapping("")
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

}
