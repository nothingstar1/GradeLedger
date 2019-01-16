package com.example.demouser.gradeledger;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.demouser.gradeledger.Model.AssignmentGroup;
import com.example.demouser.gradeledger.Model.Course;

import java.util.List;

public class ClassView extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        final Intent intent = new Intent(this, EditClass.class);

        FloatingActionButton button = findViewById(R.id.EditClassButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Intent intent = new Intent(this, EditClass.class);

        Course currentCourse = DataManager.getCurrentCourse();
        if(DataManager.isNewClass()) {
            startActivity(intent);
        } else {
            final Intent groupView = new Intent(this, AssignmentGroupView.class);
            LinearLayout container = findViewById(R.id.GroupContainer);
            List<AssignmentGroup> breakdown = currentCourse.getBreakdown();
            for(AssignmentGroup b: breakdown) { // for all assignment groups
                Button button = new Button(this);
                button.setText(b.getName());
                final AssignmentGroup c = b;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DataManager.reportClick(c);
                        startActivity(groupView);
                    }
                });
                container.addView(button);
            }
        }
    }
}
