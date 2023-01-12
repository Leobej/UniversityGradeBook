package com.can.springbootmssql.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Professor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProfessorId", nullable = false)
    private int professorId;
    @Basic
    @Column(name = "FirstName", nullable = false, length = 10)
    private String firstName;
    @Basic
    @Column(name = "LastName", nullable = false, length = 10)
    private String lastName;
    @Basic
    @Column(name = "EmploymentYear", nullable = false)
    private Date employmentYear;
    @Basic
    @Column(name = "Active", nullable = true)
    private Boolean active;
    @Basic
    @Column(name = "CNP", nullable = true, length = 10)
    private String cnp;
    @OneToMany(mappedBy = "professorByProfessorId")
    private Collection<Grade> gradesByProfessorId;
    @OneToMany(mappedBy = "professorByProfessorId")
    private Collection<ProfessorSubject> professorSubjectsByProfessorId;

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEmploymentYear() {
        return employmentYear;
    }

    public void setEmploymentYear(Date employmentYear) {
        this.employmentYear = employmentYear;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professor professor = (Professor) o;

        if (professorId != professor.professorId) return false;
        if (!Objects.equals(firstName, professor.firstName)) return false;
        if (!Objects.equals(lastName, professor.lastName)) return false;
        if (!Objects.equals(employmentYear, professor.employmentYear))
            return false;
        if (!Objects.equals(active, professor.active)) return false;
        return Objects.equals(cnp, professor.cnp);
    }

    @Override
    public int hashCode() {
        int result = professorId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (employmentYear != null ? employmentYear.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (cnp != null ? cnp.hashCode() : 0);
        return result;
    }

    public Collection<Grade> getGradesByProfessorId() {
        return gradesByProfessorId;
    }

    public void setGradesByProfessorId(Collection<Grade> gradesByProfessorId) {
        this.gradesByProfessorId = gradesByProfessorId;
    }

    public Collection<ProfessorSubject> getProfessorSubjectsByProfessorId() {
        return professorSubjectsByProfessorId;
    }

    public void setProfessorSubjectsByProfessorId(Collection<ProfessorSubject> professorSubjectsByProfessorId) {
        this.professorSubjectsByProfessorId = professorSubjectsByProfessorId;
    }
}
