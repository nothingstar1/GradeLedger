package com.example.demouser.gradeledger;

import android.content.Intent;
import android.provider.ContactsContract;
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

        Assignment currentAssignment = DataManager.getCurrentAssignment();
        if(currentAssignment == null) {
            Intent intent = new Intent(this, editAssignment.class);
            startActivity(intent);
        }
        else {
            name.setText(currentAssignment.getName());
            date.setText(currentAssignment.getDueDate());
            description.setText(currentAssignment.getDetails());
            grade.setText("" + currentAssignment.getGrade());
        }
    }
}
