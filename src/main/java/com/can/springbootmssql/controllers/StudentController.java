package com.can.springbootmssql.controllers;

import com.can.springbootmssql.dtos.ProfessorDTO;
import com.can.springbootmssql.dtos.StudentDTO;
import com.can.springbootmssql.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("")
    public ResponseEntity<Object> getAllStudents() {
         List<StudentDTO>studentDTOS= studentService.getAllStudents();
         return ResponseEntity.ok().body(studentDTOS);
    }

    @GetMapping("/active")
    public ResponseEntity<Object> getAllActiveStudents() {
          List<StudentDTO>studentDTOS= studentService.getAllActiveStudents();
          return ResponseEntity.ok().body(studentDTOS);
    }

    @PostMapping("")
    public ResponseEntity<Object> addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.saveStudent(studentDTO);
        return ResponseEntity.created(URI.create("")).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Object> updateStudent(int studentId, @RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(studentId, studentDTO);
        return ResponseEntity.ok().body(studentDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<Object>  deleteStudent(int studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().body(null);
    };

}
