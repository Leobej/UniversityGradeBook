package com.springbootmssql.services;

import com.springbootmssql.dtos.GradeDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.GradeService;
import com.springbootmssql.mappers.Mapper;
import com.springbootmssql.models.Grade;
import com.springbootmssql.models.Professor;
import com.springbootmssql.models.Student;
import com.springbootmssql.models.Subject;
import com.springbootmssql.repositories.*;
import com.springbootmssql.repositories.GradeRepository;
import com.springbootmssql.repositories.ProfessorRepository;
import com.springbootmssql.repositories.StudentRepository;
import com.springbootmssql.repositories.SubjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class GradeServiceImpl implements GradeService {
    private final Mapper mapper;
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;


    public GradeServiceImpl(Mapper mapper, GradeRepository gradeRepository
            , StudentRepository studentRepository
            , SubjectRepository subjectRepository
            , ProfessorRepository professorRepository
            ) {
        this.mapper = mapper;
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;

    }

    @Transactional
    @Override
    public List<GradeDTO> getAllGrades() {
        List<Grade> grades = gradeRepository.getGradesActive();
        return grades.stream().map(grade -> mapper.convertToType(grade, GradeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GradeDTO addGrade(@RequestBody GradeDTO gradeDTO) {
        return modifyGrade(gradeDTO);
    }

    @Override
    public GradeDTO updateGrade(GradeDTO gradeDTO) throws ApiException {
        if (!gradeRepository.existsById(gradeDTO.getGradeId()))
            throw new ApiException("Grade Id not found", HttpStatus.NOT_FOUND);
        return modifyGrade(gradeDTO);
    }

    @Override
    public Boolean deleteGrade(int gradeId) throws ApiException {
        Grade grade = gradeRepository.findById(gradeId).orElseThrow(
                () -> new ApiException("Grade id not found", HttpStatus.NOT_FOUND));
        grade.setActive(false);
        gradeRepository.save(grade);
        return true;
    }

    private GradeDTO modifyGrade(GradeDTO gradeDTO) {
        Grade grade = mapper.convertToType(gradeDTO, Grade.class);
        Student student = studentRepository.findById(gradeDTO.getStudentId()).get();
        Subject subject = subjectRepository.findById(gradeDTO.getSubjectId()).get();
        Professor professor = professorRepository.findById(gradeDTO.getSubjectId()).get();
        grade.setStudentByStudentId(student);
        grade.setProfessorByProfessorId(professor);
        grade.setSubjectBySubjectId(subject);
        gradeRepository.save(grade);
        return gradeDTO;
    }
}
