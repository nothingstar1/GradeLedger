package com.example.demouser.gradeledger.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AssignmentGroupDao {

    @Insert
    void insert(AssignmentGroup assignmentGroup);

    @Query("DELETE FROM assignment_group")
    void delete(AssignmentGroup assignmentGroup);

    @Query("SELECT * FROM assignment_group")
    LiveData<List<AssignmentGroup>> getAllAssignmentGroups();
}
