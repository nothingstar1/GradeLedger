package com.example.demouser.gradeledger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // read data from XML file and create entire model hierarchy

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // save entire model to XML file
    }
}
