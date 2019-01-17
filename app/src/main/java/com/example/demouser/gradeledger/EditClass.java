package com.example.demouser.gradeledger;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
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
            groupName.setText(g.getName(), TextView.BufferType.EDITABLE);

            EditText weight = new EditText(this);
            weight.setId(g.getID()+1);
            weight.setText(""+g.getWeight(), TextView.BufferType.EDITABLE);

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
                groupName.setText("Name of the Assignment");
                groupName.setId(group.getID());

                EditText weight = new EditText(context);
                weight.setText("0");
                weight.setInputType(InputType.TYPE_CLASS_NUMBER);
                weight.setId(group.getID()+1);



                groupInput.addView(groupName);
                groupInput.addView(weight);

                container.addView(groupInput);
            }
        });

        FloatingActionButton deleteButton = findViewById(R.id.DeleteClassButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCourse();
            }
        });

        DataManager.reportSavedCourse();
    }

    protected void deleteCourse() {
        DataManager.deleteCurrentClass();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Course current = DataManager.getCurrentCourse();
        if(current == null)
            return;
        // set name
        EditText className = findViewById(R.id.ClassName);
        current.setName(className.getText().toString());
        // set groups
        List<AssignmentGroup> groups = current.getBreakdown();
        List<AssignmentGroup> unweighted = new LinkedList<>();
        double totalWeight = 100;
        for(int i = 0; i < groups.size(); i++) {
            AssignmentGroup g = groups.get(i);
            //name
            EditText name = findViewById(g.getID());
            g.setName(name.getText().toString());
            //weight
            EditText weight = findViewById(g.getID()+1);
            if(weight.getText().toString().length() > 0) {
                g.setWeight(Double.parseDouble(weight.getText().toString()));
                totalWeight -= Double.parseDouble(weight.getText().toString());
            }
            else
                unweighted.add(g); // distribute unused weight later
        }
        // distribute remaining weight among unweighted sections, or set to 0 if no weight left
        if(unweighted.size() > 0) {
            if(totalWeight < 0)
                totalWeight = 0;
            for(int i = 0; i < unweighted.size(); i++) {
                unweighted.get(i).setWeight(totalWeight/unweighted.size());
            }
        }
    }


}
