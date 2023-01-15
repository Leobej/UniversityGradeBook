package com.springbootmssql.repositories;

import com.springbootmssql.models.Subject;
import com.springbootmssql.models.SubjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectTypeRepository extends JpaRepository<SubjectType, Integer> {

    @Procedure(procedureName = "spSelectSubjectTypesActive")
    List<Subject> getSubjectsTypeActive();
}
