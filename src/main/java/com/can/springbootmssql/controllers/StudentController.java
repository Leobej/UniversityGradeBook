package com.can.springbootmssql.controllers;

import com.can.springbootmssql.interfaces.ProfessorService;
import com.can.springbootmssql.interfaces.StudentService;
import com.can.springbootmssql.models.Professor;
import com.can.springbootmssql.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("")
    public List<Student> getAllGroupTypes() {
        return studentService.getAllStudents();
    }
}
