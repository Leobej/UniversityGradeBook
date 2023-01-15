package com.springbootmssql.controllers;

import com.springbootmssql.dtos.StudentDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.StudentService;
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
        List<StudentDTO> studentDTOS = studentService.getAllStudents();
        return ResponseEntity.ok().body(studentDTOS);
    }

    @GetMapping("/active")
    public ResponseEntity<Object> getAllActiveStudents() {
        List<StudentDTO> studentDTOS = studentService.getAllActiveStudents();
        return ResponseEntity.ok().body(studentDTOS);
    }

    @PostMapping("")
    public ResponseEntity<Object> addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.saveStudent(studentDTO);
        return ResponseEntity.created(URI.create("")).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Object> updateStudent(@RequestBody StudentDTO studentDTO) throws ApiException {
        studentService.updateStudent(studentDTO);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Object> deleteStudent(@PathVariable int studentId) throws ApiException {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().body(null);
    }

}
