package com.example.demouser.gradeledger.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CourseDao {

    @Insert
    void insert(Course course);

    @Query("DELETE FROM course_table")
    void delete(Course course);

    @Query("SELECT * from course_table")
    LiveData<List<Course>> getAllCourses();
}
