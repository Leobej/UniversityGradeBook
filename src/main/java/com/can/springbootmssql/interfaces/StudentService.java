package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.StudentDTO;
import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.models.Student;


import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    List<StudentDTO> getAllActiveStudents();

}
