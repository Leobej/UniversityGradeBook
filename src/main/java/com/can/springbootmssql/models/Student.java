package com.can.springbootmssql.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "StudentId", nullable = false)
    private int studentId;
    @Basic
    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;
    @Basic
    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;
    @Basic
    @Column(name = "Email", nullable = true, length = 50)
    private String email;
    @Basic
    @Column(name = "Active", nullable = false)
    private boolean active;
    @Basic
    @Column(name = "CNP", nullable = false, length = 50)
    private String cnp;
    @Basic
    @Column(name = "GroupId", nullable = false,insertable = false,updatable = false)
    private int groupId;
    @OneToMany(mappedBy = "studentByStudentId")
    private Collection<Grade> gradesByStudentId;
    @ManyToOne
    @JoinColumn(name = "GroupId", referencedColumnName = "GroupId", nullable = false)
    private GroupTable groupTableByGroupId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != student.studentId) return false;
        if (active != student.active) return false;
        if (groupId != student.groupId) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (cnp != null ? !cnp.equals(student.cnp) : student.cnp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (cnp != null ? cnp.hashCode() : 0);
        result = 31 * result + groupId;
        return result;
    }

    public Collection<Grade> getGradesByStudentId() {
        return gradesByStudentId;
    }

    public void setGradesByStudentId(Collection<Grade> gradesByStudentId) {
        this.gradesByStudentId = gradesByStudentId;
    }

    public GroupTable getGroupTableByGroupId() {
        return groupTableByGroupId;
    }

    public void setGroupTableByGroupId(GroupTable groupTableByGroupId) {
        this.groupTableByGroupId = groupTableByGroupId;
    }
}
