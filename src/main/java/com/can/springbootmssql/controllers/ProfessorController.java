package com.can.springbootmssql.controllers;

import com.can.springbootmssql.interfaces.GroupTypeService;
import com.can.springbootmssql.interfaces.ProfessorService;
import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.models.Professor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("")
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }
}
