package com.example.demouser.gradeledger.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AssignmentDao {

    @Insert
    void insert(Assignment assignment);

    @Query("DELETE FROM assignment_table")
    void delete(Assignment assignment);

    @Query("SELECT * FROM assignment_table")
    LiveData<List<Assignment>> getAllAssignments();

}
