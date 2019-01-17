package com.example.demouser.gradeledger.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

@Entity(tableName = "course_table")
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int node_id;

    @ColumnInfo
    private String name;

    @Ignore
    private List<AssignmentGroup> breakdown;

    public Course() {
        breakdown = new LinkedList<>();
        name = "o";
    }

    public AssignmentGroup addGroup(String name, double weight) {
        AssignmentGroup newGroup = new AssignmentGroup(name, weight);
        breakdown.add(newGroup);
        return newGroup;
    }

    public void addGroup(AssignmentGroup group) {
        breakdown.add(group) ;
    }

    public void removeGroup(AssignmentGroup group) { breakdown.remove(group); }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<AssignmentGroup> getBreakdown() {
        return  breakdown;
    }

    public void setBreakdown(List<AssignmentGroup> groups) { breakdown = groups; }

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
        return earnedPoints/totalPoints * 100;
    }

    public int getNode_id() {
        return node_id;
    }

    protected void setNode_id(int id) {
        node_id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
