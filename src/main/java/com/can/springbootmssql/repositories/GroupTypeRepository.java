package com.can.springbootmssql.repositories;



import com.can.springbootmssql.models.GroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTypeRepository extends JpaRepository<GroupType,Integer> {
}
