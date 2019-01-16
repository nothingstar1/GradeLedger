package com.example.demouser.gradeledger.Model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Course.class, AssignmentGroup.class, Assignment.class}, version = 1)
public abstract class GradeRoomDatabase extends RoomDatabase {

    public abstract AssignmentDao assignmentDao();
    public abstract AssignmentGroupDao assignmentGroupDao();
    public abstract CourseDao courseDao();

    private static volatile GradeRoomDatabase INSTANCE;

    public static GradeRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (GradeRoomDatabase.class) {
                if(INSTANCE == null) {
                    // create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GradeRoomDatabase.class, "grade_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
