package com.example.demouser.gradeledger;

import com.example.demouser.gradeledger.Model.Assignment;
import com.example.demouser.gradeledger.Model.AssignmentGroup;
import com.example.demouser.gradeledger.Model.Class;

import org.w3c.dom.Document;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DataManager {

    private static List<Class> classes;

    private static Class currentClass;

    private static AssignmentGroup currentAssignmentGroup;

    private static Assignment currentAssignment;

    public static void loadModel() {
        // if there is no file, start empty
        classes = new LinkedList<>();
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

    public static List<Class> getClasses() {
        return classes;
    }

    public static Class getCurrentClass() {
        return currentClass;
    }

    public static AssignmentGroup getCurrentAssignmentGroup() {
        return currentAssignmentGroup;
    }

    public static Assignment getCurrentAssignment() {
        return currentAssignment;
    }

    public static void reportClick(Class touchedClass) {
        currentClass = touchedClass;
    }

    public static void reportClick(Assignment touchedAssignment) {
        currentAssignment = touchedAssignment;
    }

    public static void reportClick(AssignmentGroup touchedGroup) {
        currentAssignmentGroup = touchedGroup;
    }
}
