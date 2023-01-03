package com.can.springbootmssql.services;


import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.GroupTypeDTO;
import com.can.springbootmssql.interfaces.GroupTypeService;
import com.can.springbootmssql.mappers.Mapper;
import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.repositories.GroupTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupTypeServiceImpl implements GroupTypeService {
    private final Mapper mapper;
    private final GroupTypeRepository groupTypeRepository;

    @Override
    public List<GroupTypeDTO> getAllGroupTypes() {
        List<GroupType> groupTypes= groupTypeRepository.findAll();
        return groupTypes.stream().map(groupType -> mapper.convertToType(groupType, GroupTypeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GroupTypeDTO saveGroupType(GroupTypeDTO groupTypeDTO) {
        return null;
    }

    @Override
    public GroupTypeDTO updateGroupType(int groupTypeId, GroupTypeDTO groupTypeDTO) {
        return null;
    }

    @Override
    public Boolean deleteGroup(int groupTypeId) {
        return null;
    }
}
