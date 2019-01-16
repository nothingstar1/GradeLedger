package com.example.demouser.gradeledger.Model;

import java.util.LinkedList;
import java.util.List;

public class Course {

    private String name;
    List<AssignmentGroup> breakdown;

    public Course() {
        breakdown = new LinkedList<>();
    }

    public AssignmentGroup addGroup(String name, double weight) {
        AssignmentGroup newGroup = new AssignmentGroup(name, weight);
        breakdown.add(newGroup);
        return newGroup;
    }

    public void addGroup(AssignmentGroup group) {
        breakdown.add(group) ;
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

    public double getGrade() {
        // calc grade from assignments
        // either points or percent based
        return 0;
    }
}