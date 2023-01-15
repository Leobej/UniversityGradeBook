package com.springbootmssql.interfaces;

import com.springbootmssql.dtos.SubjectTypeDTO;
import com.springbootmssql.ApiException;

import java.util.List;

public interface SubjectTypeService {
    List<SubjectTypeDTO> getAllSubjectTypes();

    SubjectTypeDTO saveSubjectType(SubjectTypeDTO subjectTypeDTO);

    SubjectTypeDTO updateSubjectType(SubjectTypeDTO subjectTypeDTO) throws ApiException;

    Boolean deleteSubjectType(int subjectTypeId) throws ApiException;
}
