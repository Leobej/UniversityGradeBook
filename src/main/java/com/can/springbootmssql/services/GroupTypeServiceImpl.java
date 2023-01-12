package com.can.springbootmssql.services;


import com.can.springbootmssql.dtos.GroupTypeDTO;
import com.can.springbootmssql.exceptions.ApiException;
import com.can.springbootmssql.interfaces.GroupTypeService;
import com.can.springbootmssql.mappers.Mapper;
import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.repositories.GroupTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        List<GroupType> groupTypes = groupTypeRepository.findAll();
        return groupTypes.stream().map(groupType -> mapper.convertToType(groupType, GroupTypeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GroupTypeDTO saveGroupType(GroupTypeDTO groupTypeDTO) {
        GroupType groupType = mapper.convertToType(groupTypeDTO, GroupType.class);
        groupTypeRepository.save(groupType);
        return groupTypeDTO;
    }

    @Override
    public GroupTypeDTO updateGroupType(GroupTypeDTO groupTypeDTO) {
        GroupType group = mapper.convertToType(groupTypeDTO, GroupType.class);
        groupTypeRepository.save(group);
        return groupTypeDTO;
    }

    @Override
    public Boolean deleteGroup(int groupTypeId) throws ApiException {
        GroupType groupType = groupTypeRepository.findById(groupTypeId)
                .orElseThrow(() -> new ApiException("Student Id not found", HttpStatus.NOT_FOUND));
        groupType.setActive(false);
        groupTypeRepository.save(groupType);
        return true;
    }
}
