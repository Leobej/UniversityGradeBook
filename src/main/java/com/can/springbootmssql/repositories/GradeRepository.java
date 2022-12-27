package com.can.springbootmssql.repositories;

import com.can.springbootmssql.models.Grade;
import com.can.springbootmssql.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
