package com.example.demouser.gradeledger;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demouser.gradeledger.Model.Assignment;
import com.example.demouser.gradeledger.Model.AssignmentGroup;

import java.util.List;

public class AssignmentGroupView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        final Intent newAssignment = new Intent(this, singleAssignment.class);

        FloatingActionButton button = findViewById(R.id.addAssignmentButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataManager.newAssignment(); // makes new Assignment, adds to current class
                startActivity(newAssignment);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        LinearLayout container = findViewById(R.id.AssignmentContainer);

        AssignmentGroup currentGroup = DataManager.getCurrentAssignmentGroup();

        TextView title = findViewById(R.id.GroupName); // set group title
        title.setText(currentGroup.getName());

        List<Assignment> assignments = currentGroup.getAssignments();
        final Intent intent = new Intent(this, singleAssignment.class);
        // make assignment buttons
        for(Assignment a: assignments) {
            Button button = new Button(this);
            button.setText(a.getName());
            final Assignment b = a;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataManager.reportClick(b);
                    startActivity(intent);
                }
            });
            container.addView(button);
        }
    }
}
