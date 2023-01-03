package com.can.springbootmssql.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class GroupType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "GroupTypeId", nullable = false)
    private int groupTypeId;
    @Basic
    @Column(name = "Fullname", nullable = false, length = 50)
    private String fullname;
    @Basic
    @Column(name = "Active", nullable = false)
    private boolean active;
    @OneToMany(mappedBy = "groupTypeByGroupTypeId")
    private Collection<GroupTable> groupTablesByGroupTypeId;

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

        GroupType groupType = (GroupType) o;

        if (groupTypeId != groupType.groupTypeId) return false;
        if (active != groupType.active) return false;
        if (fullname != null ? !fullname.equals(groupType.fullname) : groupType.fullname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupTypeId;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    public Collection<GroupTable> getGroupTablesByGroupTypeId() {
        return groupTablesByGroupTypeId;
    }

    public void setGroupTablesByGroupTypeId(Collection<GroupTable> groupTablesByGroupTypeId) {
        this.groupTablesByGroupTypeId = groupTablesByGroupTypeId;
    }
}
