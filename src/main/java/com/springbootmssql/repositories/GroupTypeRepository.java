package com.springbootmssql.repositories;


import com.springbootmssql.models.GroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupTypeRepository extends JpaRepository<GroupType, Integer> {
    @Procedure(procedureName = "spSelectGroupTypesActive")
    List<GroupType> getGroupTypesActive();
}
