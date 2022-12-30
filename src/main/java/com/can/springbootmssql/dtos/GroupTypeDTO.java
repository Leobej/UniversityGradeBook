package com.can.springbootmssql.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GroupTypeDTO {
    private int groupTypeId;
    private String fullname;
    private boolean active;
}
