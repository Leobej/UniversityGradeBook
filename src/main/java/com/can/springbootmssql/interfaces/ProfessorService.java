package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.ProfessorDTO;
import com.can.springbootmssql.exceptions.ApiException;

import java.util.List;

public interface ProfessorService {
    List<ProfessorDTO> getAllProfessors();

    ProfessorDTO saveProfessor(ProfessorDTO professorDTO);

    ProfessorDTO updateProfessor(ProfessorDTO professorDTO) throws ApiException;

    Boolean deleteProfessor(int professorId) throws ApiException;
}
