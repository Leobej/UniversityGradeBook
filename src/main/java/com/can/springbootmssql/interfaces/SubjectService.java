package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.StudentDTO;
import com.can.springbootmssql.dtos.SubjectDTO;

import java.util.List;

public interface SubjectService {
    List<SubjectDTO> getAllSubjects();
    SubjectDTO saveSubject(SubjectDTO subjectDTO);

    SubjectDTO updateSubject(int subjectId, SubjectDTO subjectDTO);

    Boolean deleteSubject(int subjectId);
}
