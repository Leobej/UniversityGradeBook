package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.ProfessorDTO;
import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.models.Professor;

import java.util.List;

public interface ProfessorService {
    List<ProfessorDTO> getAllProfessors();
}
