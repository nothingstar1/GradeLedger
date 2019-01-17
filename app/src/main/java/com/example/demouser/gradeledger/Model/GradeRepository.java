package com.example.demouser.gradeledger.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class GradeRepository {

    private GradeDao mGradeDao;
    private LiveData<List<Course>> mAllCourses;

    public GradeRepository(Application application) {
        GradeRoomDatabase db = GradeRoomDatabase.getDatabase(application);
        mGradeDao = db.gradeDao();
        mAllCourses = mGradeDao.getAllCourses();
    }

    public LiveData<List<Course>> getAllCourses() {
        return mAllCourses;
    }

    public void insert(Course course) {
        new insertAsyncTask(mGradeDao).execute(course);
    }

    private static class insertAsyncTask extends AsyncTask<Course, Void, Void> {

        private GradeDao mAsyncTaskDao;

        insertAsyncTask(GradeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Course... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public void deleteAll() {
        new deleteAllAsyncTask(mGradeDao).execute();
    }

    private static class deleteAllAsyncTask extends AsyncTask<Void, Void, Void> {

        private GradeDao mAsyncTaskDao;

        deleteAllAsyncTask(GradeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mAsyncTaskDao.nukeTable();
            return null;
        }
    }
}
