package com.can.springbootmssql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class SubjectType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SubjectTypeId", nullable = false)
    private int subjectTypeId;
    @Basic
    @Column(name = "Active", nullable = true)
    private Boolean active;
    @OneToMany(mappedBy = "subjectTypeBySubjectTypeId")
    private Collection<Subject> subjectsBySubjectTypeId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectType that = (SubjectType) o;

        if (subjectTypeId != that.subjectTypeId) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subjectTypeId;
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }
@JsonIgnore
    public Collection<Subject> getSubjectsBySubjectTypeId() {
        return subjectsBySubjectTypeId;
    }

    public void setSubjectsBySubjectTypeId(Collection<Subject> subjectsBySubjectTypeId) {
        this.subjectsBySubjectTypeId = subjectsBySubjectTypeId;
    }
}
