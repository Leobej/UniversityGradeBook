package com.can.springbootmssql.services;

import com.can.springbootmssql.dtos.GroupTypeDTO;
import com.can.springbootmssql.dtos.ProfessorDTO;
import com.can.springbootmssql.interfaces.ProfessorService;
import com.can.springbootmssql.mappers.Mapper;
import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.models.Professor;
import com.can.springbootmssql.repositories.GroupTypeRepository;
import com.can.springbootmssql.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {
    private final Mapper mapper;
    private final ProfessorRepository professorRepository;

    @Override
    public List<ProfessorDTO> getAllProfessors() {
        List<Professor>professors= professorRepository.findAll();
        return professors.stream().map(professor -> mapper.convertToType(professor, ProfessorDTO.class))
                .collect(Collectors.toList());
    }
}
