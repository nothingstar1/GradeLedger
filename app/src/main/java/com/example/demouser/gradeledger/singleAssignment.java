package com.example.demouser.gradeledger;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.demouser.gradeledger.Model.Assignment;

public class singleAssignment extends AppCompatActivity {

    private TextView name;
    private TextView date;
    private TextView grade;
    private TextView description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_assignment);

        name = findViewById(R.id.assigName);
//        date = findViewById(R.id.dueDate);
//        grade = findViewById(R.id.grade);
//        description = findViewById(R.id.assigDetails);
        final Intent editAssignment = new Intent(this, editAssignment.class);
        FloatingActionButton button = findViewById(R.id.editAssignmentButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(editAssignment);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Intent editAssignment = new Intent(this, editAssignment.class);
        Assignment currentAssignment = DataManager.getCurrentAssignment();
        if(DataManager.isIsNewAssignment()) {
            startActivity(editAssignment);
        }
        else {
            name.setText(currentAssignment.getName());
//            date.setText(currentAssignment.getDueDate());
//            description.setText(currentAssignment.getDetails());
//            grade.setText("" + currentAssignment.getGrade());
        }
    }
}
