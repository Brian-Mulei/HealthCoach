package com.example.healthcoach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.healthcoach.List.ExerciseList;
import com.example.healthcoach.Models.ExerciseModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
 import com.example.healthcoach.Forms.ExericseForm;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTrack extends AppCompatActivity {

    FloatingActionButton add;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_track);

        add =findViewById(R.id.add);
        t= findViewById(R.id.t);
        mydbhandler dbHandler = new mydbhandler(this);
        t.setText(dbHandler.loadEX());

        //what happens when + button is clicked
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ExerciseTrack.this, ExericseForm.class);
                startActivity(intent);
            }
        });

    }


}