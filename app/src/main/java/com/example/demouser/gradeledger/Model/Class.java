package com.example.demouser.gradeledger.Model;

import java.util.LinkedList;
import java.util.List;

public class Class {

    private String name;
    List<AssignmentGroup> breakdown;

    public Class() {
        breakdown = new LinkedList<>();
    }

    public AssignmentGroup addGroup(String name, double weight) {
        AssignmentGroup newGroup = new AssignmentGroup(name, weight);
        breakdown.add(newGroup);
        return newGroup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<AssignmentGroup> getBreakdown() {
        return  breakdown;
    }

    public void deleteAssignmentGroup(AssignmentGroup group) {
        breakdown.remove(group);
    }
}
