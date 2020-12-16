package com.example.healthcoach.Forms;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcoach.FoodTrack;
import com.example.healthcoach.HomePage;
import com.example.healthcoach.R;
import com.example.healthcoach.mydbhandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FoodForm extends AppCompatActivity {

    EditText calorie,foodName,meall;
    Button cancel ,add;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_form);

        //link to layout components
         calorie=findViewById(R.id.calorie);
         meall=findViewById(R.id.meal);
        foodName=findViewById(R.id.foodName);
        add =findViewById(R.id.add);
        cancel=findViewById(R.id.cancel);

        //methods for add button
         add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                        send();
                 startActivity(new Intent(FoodForm.this, HomePage.class));

             }
         });
         //methods for cancel button

         cancel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(FoodForm.this, HomePage.class));
             }
         });

    }

    //send data to database
    private void send() {

    String meal=meall.getText().toString().trim();
    String calories=calorie.getText().toString().trim();
    String food=foodName.getText().toString().trim();
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    String strDate = dateFormat.format(date);
        if (TextUtils.isEmpty(food)  ) {
            Toast.makeText(this, "Enter Required details", Toast.LENGTH_SHORT).show(); }
        else {

            mydbhandler handler=new mydbhandler(FoodForm.this);
            handler.addFood(food,meal,calories,strDate);

            Toast.makeText(this, "Food Information Sent", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(FoodForm.this, FoodTrack.class));

        }
    }

}