package com.example.demouser.gradeledger.Model;

public class Assignment {

    private String name;
    private int grade;

    public Assignment() {
        name = "New Assignment";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int grade() {
        return grade;
    }
}
