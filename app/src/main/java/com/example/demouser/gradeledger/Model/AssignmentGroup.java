package com.example.demouser.gradeledger.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.LinkedList;
import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "assignment_group", foreignKeys = @ForeignKey(entity = Course.class, parentColumns = "node_id",
        childColumns = "course_id", onDelete = CASCADE))
public class AssignmentGroup {

    @PrimaryKey(autoGenerate = true)
    private int node_id;

    @ColumnInfo
    private int course_id;

    @ColumnInfo
    String name;
    @ColumnInfo
    double weight;
    @Ignore
    List<Assignment> assignmentList;

    public AssignmentGroup() {
        name = "New Group";
        weight = 0;
        assignmentList = new LinkedList<>();
    }

    @Ignore
    public AssignmentGroup(String name, double weight) {
        this.name = name;
        this.weight = weight;
        assignmentList = new LinkedList<>();
    }

    public void addAssignment(Assignment assignment) {
        assignmentList.add(assignment);
    }

    public void setAssignmentList(List<Assignment> assignments) { this.assignmentList = assignments; }

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
        return node_id;
    }

    public double getGrade() {
        double total = 0;
        for(Assignment a: assignmentList) {
            total += a.getGrade();
        }
        if(assignmentList.size() <= 0)
            return -1;
        return total/assignmentList.size();
    }

    public void setCourse_id(int id) {
        course_id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getNode_id() {
        return node_id;
    }

    protected void setNode_id(int id) {
        node_id = id;
    }
}
