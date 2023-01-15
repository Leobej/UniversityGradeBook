package com.springbootmssql.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class ProfessorDTO {
    private int professorId;
    private String firstName;
    private String lastName;
    private Date employmentYear;
    private Boolean active;
    private String cnp;
}
