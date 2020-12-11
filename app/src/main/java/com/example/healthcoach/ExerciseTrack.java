package com.example.healthcoach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
 import com.example.healthcoach.Forms.ExericseForm;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ExerciseTrack extends AppCompatActivity {

    FloatingActionButton add;
    public RecyclerView recyclerView;
   // FirebaseRecyclerOptions<ExerciseModel> adapter;

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