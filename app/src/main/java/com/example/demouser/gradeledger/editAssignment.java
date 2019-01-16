package com.example.demouser.gradeledger;

import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demouser.gradeledger.Model.Assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class editAssignment extends AppCompatActivity {

    private static Assignment currentAssignment;
    private static EditText name, point1, point2, percent, date, detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_assignment);

        currentAssignment = DataManager.getCurrentAssignment();

        name = findViewById(R.id.assigName);
        point1 = findViewById(R.id.gradePoint1);
        point2 = findViewById(R.id.gradePoint2);
        date = findViewById(R.id.assigDate);
        detail = findViewById(R.id.assigDetail);

        name.setText(currentAssignment.getName(), TextView.BufferType.EDITABLE);
        point1.setText(""+currentAssignment.getGradePoints(), TextView.BufferType.EDITABLE);
        point2.setText(""+currentAssignment.getGradePointsTotal(), TextView.BufferType.EDITABLE);
        date.setText(""+currentAssignment.getDueDate(), TextView.BufferType.EDITABLE);

        detail.setText(currentAssignment.getDetails(), TextView.BufferType.EDITABLE);
        DataManager.reportSavedAssignment();

        FloatingActionButton deleteButton = findViewById(R.id.deleteAssignment);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAssignment();
            }
        });
    }

    protected void deleteAssignment() {
        DataManager.deleteCurrentAssignment();
        finish();
    }

    /**
     * When the user presses the back button, record all the data from the editText boxes.
     */
    protected void onPause(){
        super.onPause();

        currentAssignment.setName(name.getText().toString());
        currentAssignment.setGradePoints(Double.parseDouble(point1.getText().toString()), Double.parseDouble(point2.getText().toString()));
        currentAssignment.setdueDate(date.getText().toString());
        currentAssignment.setDetails(detail.getText().toString());
    }
}