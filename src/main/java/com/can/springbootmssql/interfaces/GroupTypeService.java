package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.GroupDTO;
import com.can.springbootmssql.dtos.GroupTypeDTO;
import com.can.springbootmssql.models.GroupType;

import java.util.List;

public interface GroupTypeService {
    List<GroupTypeDTO> getAllGroupTypes();

    GroupTypeDTO saveGroupType(GroupTypeDTO groupTypeDTO);

    GroupTypeDTO updateGroupType(int groupTypeId, GroupTypeDTO groupTypeDTO);

    Boolean deleteGroup(int groupTypeId);

}
