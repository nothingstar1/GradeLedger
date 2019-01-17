package com.example.demouser.gradeledger;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.demouser.gradeledger.Model.Course;
import com.example.demouser.gradeledger.Model.CourseAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static boolean loaded = false;
    private CourseAdapter adapter = new CourseAdapter();

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
            DataManager.loadModel(this.getApplication());
            loaded = true;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        final Intent intent = new Intent(this, ClassView.class);

//        LinearLayout container = findViewById(R.id.ClassContainer);
//        container.removeAllViews();
        final Context context = this;

        // Set up RecyclerView to display all songs.
        RecyclerView recyclerView = findViewById(R.id.view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        DataManager.getCourses().observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(@Nullable List<Course> courses) {
                Toast.makeText(context, courses.toString(), Toast.LENGTH_SHORT).show();
                adapter.setCourses(courses);
            }
        });


//        for(Course c: courses) {
//            // make a button
//            Button button = new Button(this);
//            button.setText(c.getName());
//            final Course specialCourse = c;
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    DataManager.reportClick(specialCourse);
//                    startActivity(intent);
//                }
//            });
//            container.addView(button);
//        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DataManager.saveModel();
        // save entire model to XML file
    }


}
