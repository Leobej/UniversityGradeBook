package com.can.springbootmssql.interfaces;




import com.can.springbootmssql.models.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
}
