package com.can.springbootmssql.services;

import com.can.springbootmssql.dtos.GradeDTO;
import com.can.springbootmssql.interfaces.GradeService;
import com.can.springbootmssql.mappers.Mapper;
import com.can.springbootmssql.models.Grade;
import com.can.springbootmssql.models.Professor;
import com.can.springbootmssql.models.Student;
import com.can.springbootmssql.models.Subject;
import com.can.springbootmssql.repositories.*;
import org.springframework.stereotype.Service;
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
    private final ProfessorSubjectRepository professorSubjectRepository;

    public GradeServiceImpl(Mapper mapper, GradeRepository gradeRepository
            , StudentRepository studentRepository
            , SubjectRepository subjectRepository
            , ProfessorRepository professorRepository
            , ProfessorSubjectRepository professorSubjectRepository) {
        this.mapper = mapper;
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
        this.professorSubjectRepository = professorSubjectRepository;
    }

    @Override
    public List<GradeDTO> getAllGrades() {
        List<Grade> grades = gradeRepository.findAll();
        return grades.stream().map(grade -> mapper.convertToType(grade, GradeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GradeDTO addGrade(@RequestBody GradeDTO gradeDTO) {
        Grade grade = mapper.convertToType(gradeDTO, Grade.class);
        Student student = studentRepository.findById(gradeDTO.getStudentId()).get();
        Subject subject = subjectRepository.findById(gradeDTO.getSubjectId()).get();
        Professor professor = professorRepository.findById(gradeDTO.getSubjectId()).get();

        subject.setProfessorSubjectsBySubjectId(professorSubjectRepository.findAll());
        professor.setProfessorSubjectsByProfessorId(professorSubjectRepository.findAll());
        grade.setStudentByStudentId(student);
        grade.setProfessorByProfessorId(professor);
        grade.setSubjectBySubjectId(subject);

        gradeRepository.saveGrade(grade);
        return gradeDTO;
    }

    @Override
    public GradeDTO updateGrade(int gradeId, GradeDTO gradeDTO) {
        return null;
    }

    @Override
    public Boolean deleteGrade(int gradeId) {
        return null;
    }
}
