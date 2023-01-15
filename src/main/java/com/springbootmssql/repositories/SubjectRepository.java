package com.springbootmssql.repositories;

import com.springbootmssql.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Procedure(procedureName = "spSelectSubjectsActive")
    List<Subject> getSubjectsActive();
}
