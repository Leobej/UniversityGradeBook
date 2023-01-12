package com.can.springbootmssql.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class GradeDTO {

    private int gradeId;
    private int grade;
    private Date examDate;
    private int professorId;
    private int studentId;
    private int subjectId;
    private boolean active;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeDTO gradeDTO = (GradeDTO) o;
        return gradeId == gradeDTO.gradeId && grade == gradeDTO.grade && professorId == gradeDTO.professorId && studentId == gradeDTO.studentId && subjectId == gradeDTO.subjectId && active == gradeDTO.active && examDate.equals(gradeDTO.examDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId, grade, examDate, professorId, studentId, subjectId, active);
    }

    public GradeDTO(int gradeId, int grade, Date examDate, int professorId, int studentId, int subjectId, boolean active) {
        this.gradeId = gradeId;
        this.grade = grade;
        this.examDate = examDate;
        this.professorId = professorId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.active = active;
    }

    @Override
    public String toString() {
        return "GradeDTO{" +
                "gradeId=" + gradeId +
                ", grade=" + grade +
                ", examDate=" + examDate +
                ", professorId=" + professorId +
                ", studentId=" + studentId +
                ", subjectId=" + subjectId +
                ", active=" + active +
                '}';
    }
}
