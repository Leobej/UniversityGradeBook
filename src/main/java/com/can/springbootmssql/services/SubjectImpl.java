package com.can.springbootmssql.services;

import com.can.springbootmssql.dtos.SubjectDTO;
import com.can.springbootmssql.exceptions.ApiException;
import com.can.springbootmssql.interfaces.SubjectService;
import com.can.springbootmssql.mappers.Mapper;
import com.can.springbootmssql.models.Student;
import com.can.springbootmssql.models.Subject;
import com.can.springbootmssql.models.SubjectType;
import com.can.springbootmssql.repositories.ProfessorSubjectRepository;
import com.can.springbootmssql.repositories.SubjectRepository;
import com.can.springbootmssql.repositories.SubjectTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectImpl implements SubjectService {
    private final Mapper mapper;
    private final SubjectRepository subjectRepository;
    private final SubjectTypeRepository subjectTypeRepository;

    private final ProfessorSubjectRepository professorSubjectRepository;

    @Override
    public List<SubjectDTO> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map(subject -> mapper.convertToType(subject, SubjectDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
        Subject subject = mapper.convertToType(subjectDTO, Subject.class);
        subject.setSubjectTypeBySubjectTypeId(subjectTypeRepository.findById(subject.getSubjectTypeId()).get());
        subjectRepository.save(subject);
        return subjectDTO;
    }

    @Override
    public SubjectDTO updateSubject(SubjectDTO subjectDTO) {
        Subject subject = mapper.convertToType(subjectDTO, Subject.class);
        subject.setSubjectTypeBySubjectTypeId(subjectTypeRepository.findById(subjectDTO.getSubjectTypeId()).get());
        subjectRepository.save(subject);
        return subjectDTO;
    }

    @Override
    public Boolean deleteSubject(int subjectId) throws ApiException {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ApiException("Subject Type Id not found", HttpStatus.NOT_FOUND));
        subject.setActive(false);
        subjectRepository.save(subject);
        return true;
    }
}
