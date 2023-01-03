package com.can.springbootmssql.services;

import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.StudentDTO;
import com.can.springbootmssql.interfaces.StudentService;
import com.can.springbootmssql.mappers.Mapper;
import com.can.springbootmssql.models.Student;
import com.can.springbootmssql.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final Mapper mapper;
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student>students= studentRepository.findAll();
        return students.stream().map(student -> mapper.convertToType(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<StudentDTO> getAllActiveStudents() {
        List<Student> students= studentRepository.getAllActiveStudents();
        return students.stream().map(student -> mapper.convertToType(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO updateStudent(int studentId, StudentDTO studentDTO) {
        return null;
    }

    @Override
    public Boolean deleteStudent(int studentId) {
        return null;
    }
}
