package com.springbootmssql.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GroupDTO {

    private int groupId;
    private int groupTypeId;
    private String fullname;
    private boolean active;
}
