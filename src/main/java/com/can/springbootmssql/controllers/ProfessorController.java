package com.can.springbootmssql.controllers;

import com.can.springbootmssql.dtos.GroupTypeDTO;
import com.can.springbootmssql.dtos.ProfessorDTO;
import com.can.springbootmssql.interfaces.ProfessorService;
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
    public ResponseEntity<Object>   getAllProfessors() {
        List<ProfessorDTO> professorDTOs= professorService.getAllProfessors();
        return ResponseEntity.ok().body(professorDTOs);
    }

    @PostMapping("")
    public ResponseEntity<Object> addProfessor(@RequestBody ProfessorDTO professorDTO) {
        professorService.saveProfessor(professorDTO);
        return ResponseEntity.created(URI.create("")).body(null);
    }

    @PutMapping("")
    public ResponseEntity<Object> updateProfessor(int professorId, @RequestBody ProfessorDTO professorDTO) {
        professorService.updateProfessor(professorId, professorDTO);
        return ResponseEntity.ok().body(professorDTO);
    }

    @DeleteMapping("")
    public ResponseEntity<Object>  deleteProfessor(int professorId){
        professorService.deleteProfessor(professorId);
        return ResponseEntity.ok().body(null);
    };

}
