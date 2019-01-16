package com.example.demouser.gradeledger.Model;

import android.util.Log;

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
        double totalPoints = 0, earnedPoints = 0;
        for(AssignmentGroup g: breakdown) {
            totalPoints += g.getWeight();
            Log.i("Jelly", "Section:" + g.getName() + " Grade: " + g.getGrade());
            if(g.getGrade() != -1) {
                earnedPoints += (g.getGrade() / 100 * g.getWeight());
            }
            else
                earnedPoints += g.getWeight();
        }
        Log.i("Jelly", "Total Points: " + totalPoints + " Earned Points: " + earnedPoints);
        return earnedPoints/totalPoints;
    }
}
