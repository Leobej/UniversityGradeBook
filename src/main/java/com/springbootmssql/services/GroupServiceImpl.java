package com.springbootmssql.services;


import com.springbootmssql.dtos.GroupDTO;
import com.springbootmssql.ApiException;
import com.springbootmssql.interfaces.GroupService;
import com.springbootmssql.mappers.Mapper;
import com.springbootmssql.models.GroupTable;
import com.springbootmssql.models.GroupType;
import com.springbootmssql.repositories.GroupRepository;
import com.springbootmssql.repositories.GroupTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final Mapper mapper;
    private final GroupRepository groupRepository;
    private final GroupTypeRepository groupTypeRepository;

    @Override
    public List<GroupDTO> getAllGroups() {
        List<GroupTable> groups = groupRepository.findAll();
        return groups.stream().map(group -> mapper.convertToType(group, GroupDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GroupDTO saveGroup(GroupDTO groupDto) {
        GroupTable groupTable = mapper.convertToType(groupDto, GroupTable.class);
        groupRepository.save(groupTable);
        return groupDto;
    }

    @Override
    public GroupDTO updateGroup(GroupDTO groupDTO) throws ApiException {
        if (!groupRepository.existsById(groupDTO.getGroupId())) {
            throw new ApiException("Group id not found", HttpStatus.NOT_FOUND);
        }
        GroupTable group = mapper.convertToType(groupDTO, GroupTable.class);
        GroupType groupType = groupTypeRepository.findById(groupDTO.getGroupTypeId()).get();
        group.setGroupTypeByGroupTypeId(groupType);
        System.out.println(group);
        groupRepository.save(group);
        return groupDTO;
    }

    @Override
    public Boolean deleteGroup(int groupId) throws ApiException {
        GroupTable groupTable = groupRepository.findById(groupId)
                .orElseThrow(() -> new ApiException("Student Id not found", HttpStatus.NOT_FOUND));
        groupTable.setActive(false);
        groupRepository.save(groupTable);
        return true;
    }
}
