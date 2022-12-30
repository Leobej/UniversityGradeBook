package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.SubjectTypeDTO;
import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.models.SubjectType;

import java.util.List;

public interface SubjectTypeService {
    List<SubjectTypeDTO> getAllSubjectTypes();
}
