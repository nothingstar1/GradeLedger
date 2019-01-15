package com.example.demouser.gradeledger.Model;

import java.util.LinkedList;
import java.util.List;

public class AssignmentGroup {

    String name;
    double weight;
    List<Assignment> assignmentList;

    public AssignmentGroup(String name, double weight) {
        this.name = name;
        this.weight = weight;
        assignmentList = new LinkedList<>();
    }

    public void addAssignment(Assignment assignment) {
        assignmentList.add(assignment);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void deleteAssignment(Assignment assignment) {
        assignmentList.remove(assignment);
    }
}
