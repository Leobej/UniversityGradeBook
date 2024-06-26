package com.springbootmssql.repositories;

import com.springbootmssql.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Procedure(procedureName = "sp_student_select_all_active")
    List<Student> getAllActiveStudents();

    @Procedure(procedureName = "spUpdateActiveStatus")
    void updateActiveStatus();
}
