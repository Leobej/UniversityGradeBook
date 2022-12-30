package com.can.springbootmssql.services;

import com.can.springbootmssql.dtos.SubjectDTO;
import com.can.springbootmssql.dtos.SubjectTypeDTO;
import com.can.springbootmssql.interfaces.SubjectTypeService;
import com.can.springbootmssql.mappers.Mapper;
import com.can.springbootmssql.models.SubjectType;
import com.can.springbootmssql.repositories.SubjectTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectTypeImpl implements SubjectTypeService {
    private final Mapper mapper;
    private final SubjectTypeRepository subjectTypeRepository;

    @Override
    public List<SubjectTypeDTO> getAllSubjectTypes() {
        List<SubjectType> subjectTypes= subjectTypeRepository.findAll();
        return subjectTypes.stream().map(subjectType -> mapper.convertToType(subjectType, SubjectTypeDTO.class))
                .collect(Collectors.toList());
    }
}
