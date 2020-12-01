package com.example.healthcoach;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/*
import com.sdc19.coolhealthdashboard.ExerciseReporter.ExerciseSummary;
import com.sdc19.coolhealthdashboard.StepCountReporter.StepCountSummary;
*/

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        setTitle("Health Coach");


    }

}