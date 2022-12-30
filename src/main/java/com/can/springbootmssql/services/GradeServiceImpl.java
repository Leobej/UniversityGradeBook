package com.can.springbootmssql.services;

import com.can.springbootmssql.dtos.GradeDTO;
import com.can.springbootmssql.interfaces.GradeService;
import com.can.springbootmssql.mappers.Mapper;
import com.can.springbootmssql.models.Grade;
import com.can.springbootmssql.repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class GradeServiceImpl implements GradeService {
    private final Mapper mapper;
    private final GradeRepository gradeRepository;

    public GradeServiceImpl(Mapper mapper, GradeRepository gradeRepository) {
        this.mapper = mapper;
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<GradeDTO> getAllGrades() {
        List<Grade> grades = gradeRepository.findAll();
        return grades.stream().map(grade -> mapper.convertToType(grade, GradeDTO.class))
                .collect(Collectors.toList());
    }
}
