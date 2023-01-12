package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.StudentDTO;
import com.can.springbootmssql.dtos.SubjectDTO;
import com.can.springbootmssql.exceptions.ApiException;

import java.util.List;

public interface SubjectService {
    List<SubjectDTO> getAllSubjects();
    SubjectDTO saveSubject(SubjectDTO subjectDTO);

    SubjectDTO updateSubject( SubjectDTO subjectDTO);

    Boolean deleteSubject(int subjectId) throws ApiException;
}
