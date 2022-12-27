package com.can.springbootmssql.services;

import com.can.springbootmssql.interfaces.SubjectService;
import com.can.springbootmssql.models.Subject;
import com.can.springbootmssql.repositories.StudentRepository;
import com.can.springbootmssql.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
