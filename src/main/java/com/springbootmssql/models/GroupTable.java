package com.springbootmssql.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class GroupTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GroupId", nullable = false)
    private int groupId;
    @Basic
    @Column(name = "GroupTypeId", nullable = false)
    private int groupTypeId;
    @Basic
    @Column(name = "Fullname", nullable = false, length = 50)
    private String fullname;
    @Basic
    @Column(name = "Active", nullable = false)
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "GroupTypeId", referencedColumnName = "GroupTypeId", nullable = false, insertable = false, updatable = false)
    private GroupType groupTypeByGroupTypeId;
    @OneToMany(mappedBy = "groupTableByGroupId")
    private Collection<Student> studentsByGroupId;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupTypeId() {
        return groupTypeId;
    }

    public void setGroupTypeId(int groupTypeId) {
        this.groupTypeId = groupTypeId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

        GroupTable that = (GroupTable) o;

        if (groupId != that.groupId) return false;
        if (groupTypeId != that.groupTypeId) return false;
        if (active != that.active) return false;
        return Objects.equals(fullname, that.fullname);
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + groupTypeId;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    public GroupType getGroupTypeByGroupTypeId() {
        return groupTypeByGroupTypeId;
    }

    public void setGroupTypeByGroupTypeId(GroupType groupTypeByGroupTypeId) {
        this.groupTypeByGroupTypeId = groupTypeByGroupTypeId;
    }

    public Collection<Student> getStudentsByGroupId() {
        return studentsByGroupId;
    }

    public void setStudentsByGroupId(Collection<Student> studentsByGroupId) {
        this.studentsByGroupId = studentsByGroupId;
    }
}
