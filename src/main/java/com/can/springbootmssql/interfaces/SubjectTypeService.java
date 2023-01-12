package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.SubjectTypeDTO;
import com.can.springbootmssql.exceptions.ApiException;

import java.util.List;

public interface SubjectTypeService {
    List<SubjectTypeDTO> getAllSubjectTypes();

    SubjectTypeDTO saveSubjectType(SubjectTypeDTO subjectTypeDTO);

    SubjectTypeDTO updateSubjectType(SubjectTypeDTO subjectTypeDTO) throws ApiException;

    Boolean deleteSubjectType(int subjectTypeId) throws ApiException;
}
