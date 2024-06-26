package com.springbootmssql.repositories;

import com.springbootmssql.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
    @Modifying
    @Procedure(procedureName = "spInsertGradeIfStudentIsActive")
    void saveGrade(@RequestBody Grade grade);

    @Procedure(procedureName = "spSelectGradesActive")
    List<Grade> getGradesActive();

    @Procedure(procedureName = "spSelectGradesAboveFive")
    List<Grade> getGradesAboveFive();

}
