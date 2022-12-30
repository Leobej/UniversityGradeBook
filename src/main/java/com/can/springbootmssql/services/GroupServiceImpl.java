package com.can.springbootmssql.services;



import com.can.springbootmssql.dtos.GradeDTO;
import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.interfaces.GroupService;
import com.can.springbootmssql.mappers.Mapper;
import com.can.springbootmssql.models.Group;
import com.can.springbootmssql.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final Mapper mapper;
    private final GroupRepository groupRepository;

    @Override
    public List<GroupDTO> getAllGroups() {
        List<Group> groups =groupRepository.findAll();
        return groups.stream().map(group -> mapper.convertToType(group, GroupDTO.class))
                .collect(Collectors.toList());
    }
}
