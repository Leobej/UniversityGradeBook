package com.springbootmssql.services;

import com.springbootmssql.dtos.SubjectTypeDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.SubjectTypeService;
import com.springbootmssql.mappers.Mapper;
import com.springbootmssql.models.SubjectType;
import com.springbootmssql.repositories.SubjectTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        List<SubjectType> subjectTypes = subjectTypeRepository.findAll();
        return subjectTypes.stream().map(subjectType -> mapper.convertToType(subjectType, SubjectTypeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SubjectTypeDTO saveSubjectType(SubjectTypeDTO subjectTypeDTO) {
        SubjectType subjectType = mapper.convertToType(subjectTypeDTO, SubjectType.class);
        subjectTypeRepository.save(subjectType);
        return subjectTypeDTO;
    }

    @Override
    public SubjectTypeDTO updateSubjectType(SubjectTypeDTO subjectTypeDTO) throws ApiException {
        if (!subjectTypeRepository.existsById(subjectTypeDTO.getSubjectTypeId())) {
            throw new ApiException("Professor id not found", HttpStatus.NOT_FOUND);
        }
        SubjectType subjectType = mapper.convertToType(subjectTypeDTO, SubjectType.class);
        subjectTypeRepository.save(subjectType);
        return subjectTypeDTO;
    }

    @Override
    public Boolean deleteSubjectType(int subjectTypeId) throws ApiException {
        SubjectType subjectType = subjectTypeRepository.findById(subjectTypeId)
                .orElseThrow(() -> new ApiException("Subject Type Id not found", HttpStatus.NOT_FOUND));
        subjectType.setActive(false);
        subjectTypeRepository.save(subjectType);
        return true;
    }
}
