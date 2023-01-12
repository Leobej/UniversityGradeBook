package com.can.springbootmssql.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SubjectDTO {
    private int subjectId;
    private String subjectDescription;
    private int subjectTypeId;
    private Boolean active;
    private String shortSubjectName;
}
