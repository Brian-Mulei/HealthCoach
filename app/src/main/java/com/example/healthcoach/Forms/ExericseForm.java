package com.example.healthcoach.Forms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthcoach.ExerciseTrack;
import com.example.healthcoach.FoodTrack;
import com.example.healthcoach.HomePage;
import com.example.healthcoach.R;
import com.example.healthcoach.mydbhandler;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Math.round;

public class ExericseForm extends AppCompatActivity {
    Button cancel ,add;
    EditText set,rep,exercise;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exericse_form);
         GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
         String personName = acct.getDisplayName();

         set=findViewById(R.id.sets);
        rep=findViewById(R.id.reps);
        exercise=findViewById(R.id.exercise);
        add =findViewById(R.id.add);
        cancel=findViewById(R.id.cancel);

//method for add button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
                startActivity(new Intent(ExericseForm.this, ExerciseTrack.class));

            }
        });

         //method for cancel button

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
        String exercises=exercise.getText().toString().trim();


         Double repitiion = Double.parseDouble(rep.getText().toString());
        Double setition = Double.parseDouble(set.getText().toString());

        double calorieBurner =repitiion*setition*15;

        String calorieBurned=String.valueOf(calorieBurner);

         Date date = Calendar.getInstance().getTime();
         DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
         String strDate = dateFormat.format(date);


            mydbhandler handler=new mydbhandler(ExericseForm.this);
            handler.addEx(exercises,sets,reps,calorieBurned,strDate);

             startActivity(new Intent(ExericseForm.this, FoodTrack.class));

        }
    }


