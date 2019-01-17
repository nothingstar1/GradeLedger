package com.example.demouser.gradeledger.Model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demouser.gradeledger.R;

public class CourseHolder extends RecyclerView.ViewHolder {
    private TextView text;

    private Course course;

    CourseHolder(@NonNull View itemView) {
        super(itemView);

        text = itemView.findViewById(R.id.CourseTitle);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), course.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void bindCourse(Course course) {
        this.course = course;
        text.setText(course.getName());
    }
}