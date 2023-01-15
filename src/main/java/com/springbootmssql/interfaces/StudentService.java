package com.springbootmssql.interfaces;

import com.springbootmssql.dtos.StudentDTO;
import com.springbootmssql.ApiException;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    List<StudentDTO> getAllActiveStudents();

    StudentDTO saveStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(StudentDTO studentDTO) throws ApiException;

    Boolean deleteStudent(int studentId) throws ApiException;

}
