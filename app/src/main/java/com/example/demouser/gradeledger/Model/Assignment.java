package com.example.demouser.gradeledger.Model;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Assignment {

    private String name;
    private double grade;
    private double gradePoints;
    private double gradePointsTotal;
    private String details;
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
        grade = grade/total;
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
