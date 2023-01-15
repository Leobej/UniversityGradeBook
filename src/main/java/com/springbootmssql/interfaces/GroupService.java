package com.springbootmssql.interfaces;


import com.springbootmssql.dtos.GroupDTO;
import com.springbootmssql.ApiException;

import java.util.List;

public interface GroupService {
    List<GroupDTO> getAllGroups();

    GroupDTO saveGroup(GroupDTO groupDto);

    GroupDTO updateGroup(GroupDTO groupDTO) throws ApiException;

    Boolean deleteGroup(int groupId) throws ApiException;
}
