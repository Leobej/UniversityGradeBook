package com.can.springbootmssql.interfaces;


import com.can.springbootmssql.dtos.GradeDTO;
import com.can.springbootmssql.dtos.GroupDTO;

import java.util.List;

public interface GroupService {
    List<GroupDTO> getAllGroups();

    GroupDTO saveGroup(GroupDTO groupDto);

    GroupDTO updateGroup(int groupId, GroupDTO groupDTO);

    Boolean deleteGroup(int groupId);
}
