package com.springbootmssql.repositories;


import com.springbootmssql.models.GroupTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<GroupTable, Integer> {
    @Procedure(procedureName = "spSelectGroupsActive")
    List<GroupTable> getGroupsActive();
}
