package com.example.healthcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthcoach.Forms.ExericseForm;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ExerciseTrack extends AppCompatActivity {

    FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_track);

        add =findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ExerciseTrack.this, ExericseForm.class);
                startActivity(intent);
            }
        });
    }
}