package com.can.springbootmssql.repositories;

import com.can.springbootmssql.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Procedure(procedureName = "spSelectProfessorsActive")
    List<Professor> getProfessorsActive();
}
