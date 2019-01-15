package com.example.demouser.gradeledger;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.demouser.gradeledger.Model.Course;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addClass = findViewById(R.id.AddClassButton);
        final Intent CLASS = new Intent(this, ClassView.class);
        addClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataManager.newClass();
                startActivity(CLASS);
            }
        });

        // read data from XML file and create entire model hierarchy
        // or start an empty model
        if(!loaded) {
            DataManager.loadModel();
            loaded = true;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        final Intent intent = new Intent(this, ClassView.class);

        LinearLayout container = findViewById(R.id.ClassContainer);
        container.removeAllViews();
        List<Course> courses = DataManager.getCourses();
        for(Course c: courses) {
            // make a button
            Button button = new Button(this);
            button.setText(c.getName());
            final Course specialCourse = c;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataManager.reportClick(specialCourse);
                    startActivity(intent);
                }
            });
            container.addView(button);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // save entire model to XML file
    }


}
