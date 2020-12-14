package com.example.healthcoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthcoach.Forms.FoodForm;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FoodTrack extends AppCompatActivity {

    FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_track);

        add =findViewById(R.id.add);
        //what happens when + button is clicked
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(FoodTrack.this, FoodForm.class);
                startActivity(intent);
            }
        });

    }
}