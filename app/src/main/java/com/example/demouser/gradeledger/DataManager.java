package com.example.demouser.gradeledger;

import com.example.demouser.gradeledger.Model.Assignment;
import com.example.demouser.gradeledger.Model.AssignmentGroup;
import com.example.demouser.gradeledger.Model.Course;

import java.util.LinkedList;
import java.util.List;

public class DataManager {

    private static List<Course> courses;

    private static Course currentCourse;

    private static AssignmentGroup currentAssignmentGroup;

    private static Assignment currentAssignment;

    private static boolean isNewAssignment;
    private static boolean isNewClass;

    public static void loadModel() {
        isNewAssignment = false;
        isNewClass = false;
        // if there is no file, start empty
        courses = new LinkedList<>();
        // Read XML and create data model
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document document = db.parse(new File(""));
    }

    public static void saveModel() {
        // save data model to XML file
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Course> getCourses() {
        return courses;
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
        courses.add(currentCourse);
        isNewClass = true;
    }

    public static void newAssignment() {
        currentAssignment = new Assignment();
        currentAssignmentGroup.addAssignment(currentAssignment);
        isNewAssignment = true;
    }

    public static boolean isNewClass() { return isNewClass; }
    public static boolean isIsNewAssignment() { return isNewAssignment; }
}
