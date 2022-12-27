package com.can.springbootmssql.services;

import com.can.springbootmssql.interfaces.GradeService;
import com.can.springbootmssql.models.Grade;
import com.can.springbootmssql.repositories.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }
}
