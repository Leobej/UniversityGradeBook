package com.can.springbootmssql.repositories;

import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
