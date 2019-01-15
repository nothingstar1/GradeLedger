package com.example.demouser.gradeledger;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.demouser.gradeledger.Model.AssignmentGroup;
import com.example.demouser.gradeledger.Model.Course;

import java.util.LinkedList;
import java.util.List;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demouser.gradeledger.Model.Assignment;

public class EditClass extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_class);
        int idMaker = 0;

        final LinearLayout container = findViewById(R.id.GroupContainer);

        Course current = DataManager.getCurrentCourse();
        List<AssignmentGroup> groups = current.getBreakdown();
        for(AssignmentGroup g: groups) {
            LinearLayout groupInput = new LinearLayout(this);
            groupInput.setOrientation(LinearLayout.HORIZONTAL);
            EditText groupName = new EditText(this);
            groupName.setId(g.getID());
            EditText weight = new EditText(this);
            weight.setId(g.getID()+1);
            groupInput.addView(groupName);
            groupInput.addView(weight);
            container.addView(groupInput);
        }

        FloatingActionButton button = findViewById(R.id.AddGroupButton);
        final Context context = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AssignmentGroup group = new AssignmentGroup();
                DataManager.getCurrentCourse().addGroup(group); // add new group to course
                LinearLayout groupInput = new LinearLayout(context);
                groupInput.setOrientation(LinearLayout.HORIZONTAL);

                EditText groupName = new EditText(context);
                groupName.setId(group.getID());

                EditText weight = new EditText(context);
                weight.setId(group.getID()+1);

                groupInput.addView(groupName);
                groupInput.addView(weight);

                container.addView(groupInput);
            }
        });

        DataManager.reportSavedCourse();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Course current = DataManager.getCurrentCourse();
        List<AssignmentGroup> groups = current.getBreakdown();
        for(int i = 0; i < groups.size(); i++) {
            AssignmentGroup g = groups.get(i);
            EditText name = findViewById(g.getID());
            g.setName(name.getText().toString());
            EditText weight = findViewById(g.getID()+1);
            if(weight.getText().toString().length() > 0)
                g.setWeight(Integer.parseInt(weight.getText().toString()));
        }
    }


}
