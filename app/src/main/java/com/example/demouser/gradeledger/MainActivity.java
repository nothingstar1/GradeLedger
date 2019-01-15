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
import com.example.demouser.gradeledger.Model.Class;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addClass = findViewById(R.id.AddClassButton);
        final Intent EDIT_CLASS = new Intent(this, ClassView.class);
        addClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(EDIT_CLASS);
            }
        });

        // read data from XML file and create entire model hierarchy
        // or start an empty model
        DataManager.loadModel();
    }

    @Override
    protected void onStart() {
        super.onStart();
        final Intent intent = new Intent(this, ClassView.class);

        LinearLayout container = findViewById(R.id.ClassContainer);
        container.removeAllViews();
        List<Class> classes = DataManager.getClasses();
        for(Class c: classes) {
            // make a button
            Button button = new Button(this);
            button.setText(c.getName());
            final Class specialClass = c;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataManager.reportClick(specialClass);
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
