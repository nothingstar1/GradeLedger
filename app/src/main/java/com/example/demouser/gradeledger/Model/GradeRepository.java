package com.example.demouser.gradeledger.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class GradeRepository {

    private CourseDao mcourseDao;
    private AssignmentGroupDao massignmentGroupDao;
    private AssignmentDao massignmentDao;
    private LiveData<List<Course>> mAllCourses;
    private LiveData<List<AssignmentGroup>> mAllAssignmentGroups;
    private LiveData<List<Assignment>> mAllAssignments;

    GradeRepository(Application application) {
        GradeRoomDatabase db = GradeRoomDatabase.getDatabase(application);
        mcourseDao = db.courseDao();
        massignmentDao = db.assignmentDao();
        massignmentGroupDao = db.assignmentGroupDao();
        mAllCourses = mcourseDao.getAllCourses();
        mAllAssignmentGroups = massignmentGroupDao.getAllAssignmentGroups();
        mAllAssignments = massignmentDao.getAllAssignments();
    }

    LiveData<List<Course>> getAllCourses() {
        return mAllCourses;
    }

    LiveData<List<Assignment>> getAllAssignments() {
        return mAllAssignments;
    }

    LiveData<List<AssignmentGroup>> getAllAssignmentGroups() {
        return mAllAssignmentGroups;
    }

    public void insertCourse (Course course) {
        new insertAsyncTask1(mcourseDao).execute(course);
    }

    private static class insertAsyncTask1 extends AsyncTask<Course, Void, Void> {

        private CourseDao mAsyncTaskDao;

        insertAsyncTask1(CourseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Course... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public void insertAssignment (Assignment assignment) {
        new insertAsyncTask2(massignmentDao).execute(assignment);
    }

    private static class insertAsyncTask2 extends AsyncTask<Assignment, Void, Void> {

        private AssignmentDao mAsyncTaskDao;

        insertAsyncTask2(AssignmentDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Assignment... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
