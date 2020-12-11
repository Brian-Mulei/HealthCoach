package com.example.healthcoach.Forms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthcoach.ExerciseModel;
import com.example.healthcoach.FoodTrack;
import com.example.healthcoach.HomePage;
import com.example.healthcoach.Model;
import com.example.healthcoach.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExericseForm extends AppCompatActivity {
    Button cancel ,add;
    EditText set,rep,exercise;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exericse_form);

        set=findViewById(R.id.sets);
        rep=findViewById(R.id.reps);
        exercise=findViewById(R.id.exercise);
        add =findViewById(R.id.add);
        cancel=findViewById(R.id.cancel);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExericseForm.this, HomePage.class));
            }
        });

    }

    private void send() {

        String sets= set.getText().toString().trim();
        String reps=rep.getText().toString().trim();
       Double repitiion = Double.parseDouble(rep.getText().toString());
        Double setition = Double.parseDouble(set.getText().toString());
        Double calorieBurned =repitiion*setition*15;

        String exercises=exercise.getText().toString().trim();
        DatabaseReference mDatabase;

        mDatabase = FirebaseDatabase.getInstance().getReference();

        if (TextUtils.isEmpty(exercises)  ) {
            Toast.makeText(this, "Enter Required details", Toast.LENGTH_SHORT).show(); }
        else {

            ExerciseModel exmodel = new ExerciseModel( exercises,sets,reps,calorieBurned);
            mDatabase.child("Exercise").child(exercises).setValue(exmodel);

            Toast.makeText(this, "Exercise Information Sent", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ExericseForm.this, FoodTrack.class));

        }
    }


}