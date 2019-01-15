package com.example.demouser.gradeledger.Model;

import java.util.LinkedList;
import java.util.List;

public class AssignmentGroup {

    private static int idMaker = 0;
    private int id; // Each group gets two ids -- id is for name field and id+1 for weight

    String name;
    double weight;
    List<Assignment> assignmentList;

    public AssignmentGroup() {
        name = "New Group";
        weight = 0;
        assignmentList = new LinkedList<>();
        id = idMaker;
        idMaker+=2;
    }

    public AssignmentGroup(String name, double weight) {
        this.name = name;
        this.weight = weight;
        assignmentList = new LinkedList<>();
        id = idMaker;
        idMaker+=2;
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

    public List<Assignment> getAssignments() {
        return assignmentList;
    }

    public int getID() {
        return id;
    }
}
