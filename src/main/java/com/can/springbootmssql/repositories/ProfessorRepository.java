package com.can.springbootmssql.repositories;

import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}
