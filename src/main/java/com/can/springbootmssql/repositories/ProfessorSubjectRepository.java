package com.can.springbootmssql.repositories;

import com.can.springbootmssql.models.ProfessorSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorSubjectRepository extends JpaRepository<ProfessorSubject, Integer> {

}
