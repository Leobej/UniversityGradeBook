package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.ProfessorDTO;
import com.can.springbootmssql.dtos.StudentDTO;
import com.can.springbootmssql.exceptions.ApiException;


import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    List<StudentDTO> getAllActiveStudents();

    StudentDTO saveStudent(StudentDTO studentDTO);

    StudentDTO updateStudent( StudentDTO studentDTO);

    Boolean deleteStudent(int studentId) throws ApiException;

}
