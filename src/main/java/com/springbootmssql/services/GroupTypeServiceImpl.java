package com.springbootmssql.services;


import com.springbootmssql.dtos.GroupTypeDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.GroupTypeService;
import com.springbootmssql.mappers.Mapper;
import com.springbootmssql.models.GroupType;
import com.springbootmssql.repositories.GroupTypeRepository;
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
    public GroupTypeDTO updateGroupType(GroupTypeDTO groupTypeDTO) throws ApiException {
        if(groupTypeRepository.existsById(groupTypeDTO.getGroupTypeId()))
            throw new ApiException("Group Type id not found",HttpStatus.NOT_FOUND);
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
