package com.can.springbootmssql.services;

import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.SubjectDTO;
import com.can.springbootmssql.interfaces.SubjectService;
import com.can.springbootmssql.mappers.Mapper;
import com.can.springbootmssql.models.Subject;
import com.can.springbootmssql.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectImpl implements SubjectService {
    private final Mapper mapper;
    private final SubjectRepository subjectRepository;
    @Override
    public List<SubjectDTO> getAllSubjects() {
        List<Subject> subjects= subjectRepository.findAll();
        return subjects.stream().map(subject -> mapper.convertToType(subject, SubjectDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
        return null;
    }

    @Override
    public SubjectDTO updateSubject(int subjectId, SubjectDTO subjectDTO) {
        return null;
    }

    @Override
    public Boolean deleteSubject(int subjectId) {
        return null;
    }
}
