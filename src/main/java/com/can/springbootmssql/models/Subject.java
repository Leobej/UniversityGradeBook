package com.can.springbootmssql.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SubjectId", nullable = false)
    private int subjectId;
    @Basic
    @Column(name = "SubjectName", nullable = false, length = 10)
    private String subjectName;
    @Basic
    @Column(insertable = false,updatable = false,name = "SubjectTypeId", nullable = false)
    private int subjectTypeId;
    @Basic
    @Column(name = "Active", nullable = true)
    private Boolean active;
    @Basic
    @Column(name = "ShortSubjectName", nullable = true, length = 10)
    private String shortSubjectName;
    @OneToMany(mappedBy = "subjectBySubjectId")
    private Collection<Grade> gradesBySubjectId;
    @OneToMany(mappedBy = "subjectBySubjectId")
    private Collection<ProfessorSubject> professorSubjectsBySubjectId;
    @ManyToOne
    @JoinColumn(name = "SubjectTypeId", referencedColumnName = "SubjectTypeId", nullable = false)
    private SubjectType subjectTypeBySubjectTypeId;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(int subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getShortSubjectName() {
        return shortSubjectName;
    }

    public void setShortSubjectName(String shortSubjectName) {
        this.shortSubjectName = shortSubjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (subjectId != subject.subjectId) return false;
        if (subjectTypeId != subject.subjectTypeId) return false;
        if (subjectName != null ? !subjectName.equals(subject.subjectName) : subject.subjectName != null) return false;
        if (active != null ? !active.equals(subject.active) : subject.active != null) return false;
        if (shortSubjectName != null ? !shortSubjectName.equals(subject.shortSubjectName) : subject.shortSubjectName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subjectId;
        result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
        result = 31 * result + subjectTypeId;
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (shortSubjectName != null ? shortSubjectName.hashCode() : 0);
        return result;
    }

    public Collection<Grade> getGradesBySubjectId() {
        return gradesBySubjectId;
    }

    public void setGradesBySubjectId(Collection<Grade> gradesBySubjectId) {
        this.gradesBySubjectId = gradesBySubjectId;
    }

    public Collection<ProfessorSubject> getProfessorSubjectsBySubjectId() {
        return professorSubjectsBySubjectId;
    }

    public void setProfessorSubjectsBySubjectId(Collection<ProfessorSubject> professorSubjectsBySubjectId) {
        this.professorSubjectsBySubjectId = professorSubjectsBySubjectId;
    }

    public SubjectType getSubjectTypeBySubjectTypeId() {
        return subjectTypeBySubjectTypeId;
    }

    public void setSubjectTypeBySubjectTypeId(SubjectType subjectTypeBySubjectTypeId) {
        this.subjectTypeBySubjectTypeId = subjectTypeBySubjectTypeId;
    }
}
