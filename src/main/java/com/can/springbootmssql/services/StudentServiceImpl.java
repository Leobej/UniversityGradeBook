package com.can.springbootmssql.services;

import com.can.springbootmssql.interfaces.StudentService;
import com.can.springbootmssql.models.Student;
import com.can.springbootmssql.repositories.ProfessorRepository;
import com.can.springbootmssql.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
