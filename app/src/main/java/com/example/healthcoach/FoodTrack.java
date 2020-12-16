package com.example.healthcoach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcoach.Forms.FoodForm;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FoodTrack extends AppCompatActivity {

    FloatingActionButton add;
    TextView t;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_track);

        add =findViewById(R.id.add);

        t= findViewById(R.id.t);
       mydbhandler dbHandler = new mydbhandler(this);
       t.setText(dbHandler.loadFOOD());


        //what happens when + button is clicked
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(FoodTrack.this, FoodForm.class);
                startActivity(intent);
            }
        });


}}