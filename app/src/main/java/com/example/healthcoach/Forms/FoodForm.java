package com.example.healthcoach.Forms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.healthcoach.FoodTrack;
import com.example.healthcoach.HomePage;
import com.example.healthcoach.Model;
import com.example.healthcoach.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FoodForm extends AppCompatActivity {

    EditText calorie,foodName,meall;
    Button cancel ,add;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_form);

         calorie=findViewById(R.id.calorie);
         meall=findViewById(R.id.meal);

        foodName=findViewById(R.id.foodName);
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
                 startActivity(new Intent(FoodForm.this, HomePage.class));
             }
         });

    }

    private void send() {

    String meal=meall.getText().toString().trim();
    String calories=calorie.getText().toString().trim();
    String food=foodName.getText().toString().trim();
        DatabaseReference mDatabase;
// ...
        mDatabase = FirebaseDatabase.getInstance().getReference();

        if (TextUtils.isEmpty(food)  ) {
            Toast.makeText(this, "Enter Required details", Toast.LENGTH_SHORT).show(); }
        else {

             Model model = new Model(food,meal,calories);
            mDatabase.child("Food").child(meal).setValue(model);

            Toast.makeText(this, "Food Information Sent", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(FoodForm.this, FoodTrack.class));

        }
    }

}