package com.springbootmssql.interfaces;

import com.springbootmssql.dtos.ProfessorDTO;
import com.springbootmssql.ApiException;

import java.util.List;

public interface ProfessorService {
    List<ProfessorDTO> getAllProfessors();

    ProfessorDTO saveProfessor(ProfessorDTO professorDTO);

    ProfessorDTO updateProfessor(ProfessorDTO professorDTO) throws ApiException;

    Boolean deleteProfessor(int professorId) throws ApiException;
}
