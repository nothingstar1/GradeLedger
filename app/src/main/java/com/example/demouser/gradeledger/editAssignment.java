package com.example.demouser.gradeledger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demouser.gradeledger.Model.Assignment;

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
        percent = findViewById(R.id.gradePercent);
        date = findViewById(R.id.assigDate);
        detail = findViewById(R.id.assigDetail);

        name.setText(currentAssignment.getName(), TextView.BufferType.EDITABLE);
        point1.setText((int)currentAssignment.getGradePoints(), TextView.BufferType.EDITABLE);
        point2.setText((int)currentAssignment.getGradePointsTotal(), TextView.BufferType.EDITABLE);
        percent.setText((int) currentAssignment.getGrade(), TextView.BufferType.EDITABLE);
        date.setText(currentAssignment.getDueDate(), TextView.BufferType.EDITABLE);
        detail.setText(currentAssignment.getDetails(), TextView.BufferType.EDITABLE);
    }

    /**
     * When the user presses the back button, record all the data from the editText boxes.
     */
    protected void onDestroy(){
        super.onDestroy();

        currentAssignment.setName(name.getText().toString());
        currentAssignment.setGradePoints(Double.parseDouble(point1.getText().toString()), Double.parseDouble(point2.getText().toString()));
        currentAssignment.setGrade(Double.parseDouble(percent.getText().toString()));
        currentAssignment.setdueDate(Integer.parseInt(date.getText().toString()));
        currentAssignment.setDetails(detail.getText().toString());
    }
}