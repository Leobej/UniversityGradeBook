package com.can.springbootmssql.services;

import com.can.springbootmssql.interfaces.SubjectTypeService;
import com.can.springbootmssql.models.SubjectType;
import com.can.springbootmssql.repositories.SubjectTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectTypeImpl implements SubjectTypeService {
    private final SubjectTypeRepository subjectTypeRepository;

    @Override
    public List<SubjectType> getAllSubjectTypes() {
        return subjectTypeRepository.findAll();
    }
}
