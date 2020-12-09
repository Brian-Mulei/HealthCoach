package com.example.healthcoach.Forms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.healthcoach.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FoodForm extends AppCompatActivity {

    EditText calorie,foodName,Meal,Date;
    Button cancel ,add;
    final Calendar myCalendar = Calendar.getInstance();
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_form);

        Date= findViewById(R.id.mealDate);
        calorie=findViewById(R.id.calorie);
        foodName=findViewById(R.id.foodName);
        add =findViewById(R.id.add);
        cancel=findViewById(R.id.cancel);


         Spinner dropdown = findViewById(R.id.menuDropDown);
//create a list of items for the spinner.
         String[] items = new String[]{"Breakfast", "Lunch", "Supper"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
         ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
         dropdown.setAdapter(adapter);
         DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

             @Override
             public void onDateSet(DatePicker view, int year, int monthOfYear,
                                   int dayOfMonth) {
                 // TODO Auto-generated method stub
                 myCalendar.set(Calendar.YEAR, year);
                 myCalendar.set(Calendar.MONTH, monthOfYear);
                 myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                 updateLabel();
             }

         };
         Date.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 // TODO Auto-generated method stub
                 new DatePickerDialog(FoodForm.this, date, myCalendar
                         .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                         myCalendar.get(Calendar.DAY_OF_MONTH)).show();
             }
         });

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        Date.setText(sdf.format(myCalendar.getTime()));
    }

}