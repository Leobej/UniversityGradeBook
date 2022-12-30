package com.can.springbootmssql.controllers;

import com.can.springbootmssql.dtos.SubjectDTO;
import com.can.springbootmssql.interfaces.StudentService;
import com.can.springbootmssql.interfaces.SubjectService;
import com.can.springbootmssql.interfaces.SubjectTypeService;
import com.can.springbootmssql.models.Student;
import com.can.springbootmssql.models.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {


    private final SubjectService subjectService;

    @GetMapping("")
    public List<SubjectDTO> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
}
