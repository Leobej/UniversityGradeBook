package com.can.springbootmssql.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Grade {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "GradeId", nullable = false)
    private int gradeId;
    @Basic
    @Column(name = "Grade", nullable = false)
    private int grade;
    @Basic
    @Column(name = "ExamDate", nullable = true)
    private Date examDate;
    @Basic
    @Column(name = "ProfessorId", nullable = false, insertable = false, updatable = false)
    private int professorId;
    @Basic
    @Column(name = "SubjectId", nullable = false, insertable = false, updatable = false)
    private int subjectId;
    @Basic
    @Column(name = "StudentId", nullable = false, insertable = false, updatable = false)
    private int studentId;
    @Basic
    @Column(name = "Active", nullable = false)
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "ProfessorId", referencedColumnName = "ProfessorId", nullable = true)
    private Professor professorByProfessorId;
    @ManyToOne
    @JoinColumn(name = "SubjectId", referencedColumnName = "SubjectId", nullable = true)
    private Subject subjectBySubjectId;
    @ManyToOne
    @JoinColumn(name = "StudentId", referencedColumnName = "StudentId", nullable = true)
    private Student studentByStudentId;

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade1 = (Grade) o;

        if (gradeId != grade1.gradeId) return false;
        if (grade != grade1.grade) return false;
        if (professorId != grade1.professorId) return false;
        if (subjectId != grade1.subjectId) return false;
        if (studentId != grade1.studentId) return false;
        if (active != grade1.active) return false;
        return Objects.equals(examDate, grade1.examDate);
    }

    @Override
    public int hashCode() {
        int result = gradeId;
        result = 31 * result + grade;
        result = 31 * result + (examDate != null ? examDate.hashCode() : 0);
        result = 31 * result + professorId;
        result = 31 * result + subjectId;
        result = 31 * result + studentId;
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    public Professor getProfessorByProfessorId() {
        return professorByProfessorId;
    }

    public void setProfessorByProfessorId(Professor professorByProfessorId) {
        this.professorByProfessorId = professorByProfessorId;
    }

    public Subject getSubjectBySubjectId() {
        return subjectBySubjectId;
    }

    public void setSubjectBySubjectId(Subject subjectBySubjectId) {
        this.subjectBySubjectId = subjectBySubjectId;
    }

    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }
}
