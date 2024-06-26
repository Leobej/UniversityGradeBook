package com.springbootmssql.services;

import com.springbootmssql.dtos.ProfessorDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.ProfessorService;
import com.springbootmssql.mappers.Mapper;
import com.springbootmssql.models.Professor;
import com.springbootmssql.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        List<Professor> professors = professorRepository.findAll();
        return professors.stream().map(professor -> mapper.convertToType(professor, ProfessorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorDTO saveProfessor(ProfessorDTO professorDTO) {
        Professor professor = mapper.convertToType(professorDTO, Professor.class);
        professorRepository.save(professor);
        return professorDTO;
    }

    @Override
    public ProfessorDTO updateProfessor(ProfessorDTO professorDTO) throws ApiException {
        if (!professorRepository.existsById(professorDTO.getProfessorId())) {
            throw new ApiException("Professor id not found", HttpStatus.NOT_FOUND);
        }
        Professor professor = mapper.convertToType(professorDTO, Professor.class);
        professorRepository.save(professor);
        return professorDTO;
    }

    @Override
    public Boolean deleteProfessor(int professorId) throws ApiException {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new ApiException("Student Id not found", HttpStatus.NOT_FOUND));
        professor.setActive(false);
        professorRepository.save(professor);
        return true;
    }
}
