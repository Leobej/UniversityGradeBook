package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.SubjectDTO;
import com.can.springbootmssql.dtos.SubjectTypeDTO;

import java.util.List;

public interface SubjectTypeService {
    List<SubjectTypeDTO> getAllSubjectTypes();

    SubjectTypeDTO saveSubjectType(SubjectTypeDTO subjectTypeDTO);

    SubjectTypeDTO updateSubjectType(int subjectTypeId, SubjectTypeDTO subjectTypeDTO);

    Boolean deleteSubjectType(int subjectTypeId);
}
