package com.example.demouser.gradeledger.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "assignment_table", foreignKeys = @ForeignKey(entity = AssignmentGroup.class, parentColumns = "node_id",
childColumns = "group_id", onDelete=CASCADE))
public class Assignment {

    @PrimaryKey(autoGenerate = true)
    private int node_id;

    @ColumnInfo
    private int group_id;

    @ColumnInfo
    private String name;
    @ColumnInfo
    private double grade;
    @ColumnInfo
    private double gradePoints;
    @ColumnInfo
    private double gradePointsTotal;
    @ColumnInfo
    private String details;
    @ColumnInfo
    private String dueDate = "dd-MM-YYYY";

    public Assignment() {
        name = "New Assignment";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setGradePoints(double grade, double total) {
        gradePoints = grade;
        gradePointsTotal = total;
        this.grade = grade/total * 100;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setdueDate(String date) {
        this.dueDate = date;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public String getDueDate() {
        return dueDate;
    }

    public double getGradePoints() {
        return gradePoints;
    }

    public double getGradePointsTotal() {
        return gradePointsTotal;
    }

    public String getDetails() { return details; }
}
