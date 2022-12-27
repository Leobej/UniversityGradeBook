package com.can.springbootmssql.services;


import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.repositories.GroupTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupTypeServiceImpl implements GroupTypeService {

    private final GroupTypeRepository groupTypeRepository;

    @Override
    public List<GroupType> getAllGroupTypes() {
        return groupTypeRepository.findAll();
    }
}
