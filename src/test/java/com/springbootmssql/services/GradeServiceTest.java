package com.springbootmssql.services;

import com.springbootmssql.dtos.GradeDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.GradeService;
import com.springbootmssql.mappers.Mapper;
import com.springbootmssql.models.Grade;
import com.springbootmssql.repositories.GradeRepository;
import com.springbootmssql.repositories.ProfessorRepository;
import com.springbootmssql.repositories.StudentRepository;
import com.springbootmssql.repositories.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GradeServiceTest {
    @Mock
    private GradeRepository gradeRepository;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private ProfessorRepository professorRepository;

    @Mock
    private GradeService gradeService;
    private Mapper mapper;

    private ModelMapper modelMapper;


    @BeforeEach
    void setupService() {
        gradeRepository = mock(gradeRepository.getClass());
        studentRepository = mock(studentRepository.getClass());
        modelMapper = new ModelMapper();
        mapper = new Mapper(modelMapper);
        professorRepository = mock(professorRepository.getClass());
        subjectRepository = mock(subjectRepository.getClass());
        gradeService = new GradeServiceImpl(mapper, gradeRepository, studentRepository, subjectRepository, professorRepository);
    }

    @Test
    void addItemTest() throws ApiException {
        GradeDTO gradeDTO = new GradeDTO(1, 8, new Date(2022, 04, 04), 1, 1, 1, true);
        Grade grade = mapper.convertToType(gradeDTO, Grade.class);
        when(gradeRepository.save(grade)).thenReturn(grade);
        assertEquals(gradeDTO, gradeService.addGrade(gradeDTO));
    }

}
