package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.SubjectDTO;
import com.can.springbootmssql.dtos.SubjectTypeDTO;
import com.can.springbootmssql.exceptions.ApiException;

import java.util.List;

public interface SubjectTypeService {
    List<SubjectTypeDTO> getAllSubjectTypes();

    SubjectTypeDTO saveSubjectType(SubjectTypeDTO subjectTypeDTO);

    SubjectTypeDTO updateSubjectType( SubjectTypeDTO subjectTypeDTO);

    Boolean deleteSubjectType(int subjectTypeId) throws ApiException;
}
