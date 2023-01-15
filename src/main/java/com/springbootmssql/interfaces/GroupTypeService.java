package com.springbootmssql.interfaces;

import com.springbootmssql.dtos.GroupTypeDTO;
import com.springbootmssql.ApiException;

import java.util.List;

public interface GroupTypeService {
    List<GroupTypeDTO> getAllGroupTypes();

    GroupTypeDTO saveGroupType(GroupTypeDTO groupTypeDTO);

    GroupTypeDTO updateGroupType(GroupTypeDTO groupTypeDTO) throws ApiException;

    Boolean deleteGroup(int groupTypeId) throws ApiException;

}
