package com.example.demouser.gradeledger.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface GradeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Course course);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Assignment assignment);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AssignmentGroup assignmentGroup);

    @Update
    void update(Course course);

    @Update
    void update(Assignment assignment);

    @Update
    void update(AssignmentGroup assignmentGroup);

    @Delete
    void delete(Course course);

    @Delete
    void delete(Assignment assignment);

    @Delete
    void delete(AssignmentGroup assignmentGroup);

    @Query("SELECT * FROM course_table")
    LiveData<List<Course>> getAllCourses();

    @Query("DELETE FROM course_table")
    void nukeTable();

    @Query("SELECT * FROM assignment_group WHERE course_id = :course_id")
    LiveData<List<AssignmentGroup>> getAssignmentGroups(int course_id);

    @Query("SELECT * FROM assignment_table WHERE group_id = :group_id")
    LiveData<List<Assignment>> getAssignments(int group_id);
}
