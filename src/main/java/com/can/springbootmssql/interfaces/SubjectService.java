package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.SubjectDTO;
import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.models.Subject;

import java.util.List;

public interface SubjectService {
    List<SubjectDTO> getAllSubjects();
}
