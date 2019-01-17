package com.example.demouser.gradeledger;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.demouser.gradeledger.Model.Assignment;
import com.example.demouser.gradeledger.Model.AssignmentGroup;
import com.example.demouser.gradeledger.Model.Course;
import com.example.demouser.gradeledger.Model.GradeDao;
import com.example.demouser.gradeledger.Model.GradeRepository;
import com.example.demouser.gradeledger.Model.GradeRoomDatabase;

import java.util.LinkedList;
import java.util.List;

public class DataManager {


    private static Course currentCourse;

    private static AssignmentGroup currentAssignmentGroup;

    private static Assignment currentAssignment;

    private static boolean isNewAssignment;
    private static boolean isNewClass;

    private static GradeRepository repository;

    public static void loadModel(Application application) {
        isNewAssignment = false;
        isNewClass = false;

        repository = new GradeRepository(application);
        repository.deleteAll();
    }

    public static void saveModel() {

    }

    public static LiveData<List<Course>> getCourses() {
        return repository.getAllCourses();
    }

    public static Course getCurrentCourse() {
        return currentCourse;
    }

    public static AssignmentGroup getCurrentAssignmentGroup() {
        return currentAssignmentGroup;
    }

    public static Assignment getCurrentAssignment() {
        return currentAssignment;
    }

    public static void reportClick(Course touchedCourse) {
        currentCourse = touchedCourse;
        isNewClass = false;
    }

    public static void reportClick(Assignment touchedAssignment) {
        currentAssignment = touchedAssignment;
        isNewAssignment = false;
    }

    public static void reportClick(AssignmentGroup touchedGroup) {
        currentAssignmentGroup = touchedGroup;
    }

    public static void reportSavedCourse() { isNewClass = false; }
    public static void reportSavedAssignment() { isNewAssignment = false; }

    public static void newClass() {
        currentCourse = new Course();
        isNewClass = true;
        repository.insert(currentCourse);
    }

    public static void newAssignment() {
        currentAssignment = new Assignment();
        currentAssignmentGroup.addAssignment(currentAssignment);
        isNewAssignment = true;
    }

    public static boolean isNewClass() { return isNewClass; }
    public static boolean isIsNewAssignment() { return isNewAssignment; }

    public static void deleteCurrentClass() {
        currentCourse = null;
        currentAssignment = null;
        currentAssignmentGroup = null;
        // delete course from repository
    }

    public static void deleteCurrentAssignment() {
        currentAssignmentGroup.deleteAssignment(currentAssignment);
        currentAssignment = null;
    }
}
