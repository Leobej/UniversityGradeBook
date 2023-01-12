package com.can.springbootmssql.repositories;

import com.can.springbootmssql.models.ProfessorSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorSubjectRepository extends JpaRepository<ProfessorSubject,Integer> {

}
