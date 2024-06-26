package com.springbootmssql.services;

import com.springbootmssql.dtos.StudentDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.StudentService;
import com.springbootmssql.mappers.Mapper;
import com.springbootmssql.models.GroupTable;
import com.springbootmssql.models.Student;
import com.springbootmssql.repositories.GroupRepository;
import com.springbootmssql.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final Mapper mapper;
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> mapper.convertToType(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getAllActiveStudents() {
        List<Student> students = studentRepository.getAllActiveStudents();
        return students.stream().map(student -> mapper.convertToType(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = mapper.convertToType(studentDTO, Student.class);
        GroupTable groupTable = groupRepository.findById(studentDTO.getGroupId()).get();
        student.setGroupTableByGroupId(groupTable);
        studentRepository.save(student);
        return studentDTO;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) throws ApiException {
        if (!studentRepository.existsById(studentDTO.getStudentId())) {
            throw new ApiException("Professor id not found", HttpStatus.NOT_FOUND);
        }
        Student student = mapper.convertToType(studentDTO, Student.class);
        student.setGroupTableByGroupId(groupRepository.findById(studentDTO.getGroupId()).get());
        studentRepository.save(student);
        return studentDTO;
    }
    @Override
    public Boolean deleteStudent(int studentId) throws ApiException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ApiException("Student Id not found", HttpStatus.NOT_FOUND));
        student.setActive(false);
        studentRepository.save(student);
        return true;
    }
}
