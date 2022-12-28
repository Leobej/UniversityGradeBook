package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.models.Student;


import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    List<Student> getAllActiveStudents();

}
