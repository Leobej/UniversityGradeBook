package com.can.springbootmssql.services;

import com.can.springbootmssql.interfaces.ProfessorService;
import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.models.Professor;
import com.can.springbootmssql.repositories.GroupTypeRepository;
import com.can.springbootmssql.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }
}
