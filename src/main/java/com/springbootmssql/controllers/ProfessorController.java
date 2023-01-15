package com.springbootmssql.controllers;

import com.springbootmssql.dtos.ProfessorDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/professors")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("")
    public ResponseEntity<Object> getAllProfessors() {
        List<ProfessorDTO> professorDTOs = professorService.getAllProfessors();
        return ResponseEntity.ok().body(professorDTOs);
    }

    @PostMapping("")
    public ResponseEntity<Object> addProfessor(@RequestBody ProfessorDTO professorDTO) {
        professorService.saveProfessor(professorDTO);
        return ResponseEntity.created(URI.create("")).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Object> updateProfessor(@RequestBody ProfessorDTO professorDTO) throws ApiException {
        professorService.updateProfessor(professorDTO);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteProfessor(int professorId) throws ApiException {
        professorService.deleteProfessor(professorId);
        return ResponseEntity.ok().body(null);
    }

}
