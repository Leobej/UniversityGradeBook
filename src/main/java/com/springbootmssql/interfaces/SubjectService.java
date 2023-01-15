package com.springbootmssql.interfaces;

import com.springbootmssql.dtos.SubjectDTO;
import com.springbootmssql.ApiException;

import java.util.List;

public interface SubjectService {
    List<SubjectDTO> getAllSubjects();

    SubjectDTO saveSubject(SubjectDTO subjectDTO);

    SubjectDTO updateSubject(SubjectDTO subjectDTO) throws ApiException;

    Boolean deleteSubject(int subjectId) throws ApiException;
}
