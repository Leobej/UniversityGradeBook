package com.can.springbootmssql.interfaces;


import com.can.springbootmssql.dtos.GradeDTO;
import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.exceptions.ApiException;

import java.util.List;

public interface GroupService {
    List<GroupDTO> getAllGroups();

    GroupDTO saveGroup(GroupDTO groupDto);

    GroupDTO updateGroup( GroupDTO groupDTO);

    Boolean deleteGroup(int groupId) throws ApiException;
}
