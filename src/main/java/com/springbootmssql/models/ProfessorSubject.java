package com.springbootmssql.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Professor_Subject")
public class ProfessorSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "ProfessorId", nullable = true, insertable = false, updatable = false)
    private Integer professorId;
    @Basic
    @Column(name = "SubjectId", nullable = true, insertable = false, updatable = false)
    private Integer subjectId;
    @ManyToOne
    @JoinColumn(name = "ProfessorId", referencedColumnName = "ProfessorId")
    private Professor professorByProfessorId;
    @ManyToOne
    @JoinColumn(name = "SubjectId", referencedColumnName = "SubjectId")
    private Subject subjectBySubjectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfessorSubject that = (ProfessorSubject) o;

        if (!Objects.equals(professorId, that.professorId)) return false;
        return Objects.equals(subjectId, that.subjectId);
    }

    @Override
    public int hashCode() {
        int result = professorId != null ? professorId.hashCode() : 0;
        result = 31 * result + (subjectId != null ? subjectId.hashCode() : 0);
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
}
