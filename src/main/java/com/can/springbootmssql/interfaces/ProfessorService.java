package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.GroupTypeDTO;
import com.can.springbootmssql.dtos.ProfessorDTO;

import java.util.List;

public interface ProfessorService {
    List<ProfessorDTO> getAllProfessors();

    ProfessorDTO saveProfessor(ProfessorDTO professorDTO);

    ProfessorDTO updateProfessor(int professorId, ProfessorDTO professorDTO);

    Boolean deleteProfessor(int professorId);
}
