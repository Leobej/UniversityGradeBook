package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.GroupTypeDTO;
import com.can.springbootmssql.exceptions.ApiException;

import java.util.List;

public interface GroupTypeService {
    List<GroupTypeDTO> getAllGroupTypes();

    GroupTypeDTO saveGroupType(GroupTypeDTO groupTypeDTO);

    GroupTypeDTO updateGroupType(GroupTypeDTO groupTypeDTO) throws ApiException;

    Boolean deleteGroup(int groupTypeId) throws ApiException;

}
