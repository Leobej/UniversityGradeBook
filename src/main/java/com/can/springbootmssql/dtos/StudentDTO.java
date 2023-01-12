package com.can.springbootmssql.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private String cnp;
    private int groupId;
}
