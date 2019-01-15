package com.example.demouser.gradeledger.Model;

public class Assignment {

    private String name;
    private double grade;
    private double gradePoints;
    private double gradePointsTotal;
    private String details;
    private int dueDate;

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

    public void setdueDate(int date) {
        this.dueDate = date;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public int getDueDate() {
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
