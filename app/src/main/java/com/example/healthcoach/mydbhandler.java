package com.example.healthcoach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class mydbhandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "MY_DATABASE";

    private static final String EXERCISE  = "EX_TABLE";
    private static final String FOOD  = "FOOD_TABLE";

    private static final String EXERCISE_NAME = "name";
    private static final String EX_SET = "sets";
    private static final String EX_REP = "repis";
    private static final String EX_CALORIE = "calorie";

    private static final String FOOD_NAME = "name";
    private static final String FOOD_TYPE = "type";
    private static final String FOOD_TIME="dofinput";

    private static final String EX_TIME="dofinput";

    private static final String FOOD_CALORI = "calorie";
      private final Context context;
    private String CREATE_EX_TABLE= "CREATE TABLE " + EXERCISE  + "(" + EXERCISE_NAME + " TEXT," + EX_SET +" TEXT," + EX_REP + " TEXT," + EX_CALORIE + " TEXT ,"+ EX_TIME + " TEXT,"+ "TEXT"+ ")";

    private String CREATE_FOOD_TABLE= "CREATE TABLE " + FOOD  + "(" + FOOD_NAME + " TEXT," + FOOD_TYPE +" TEXT," + FOOD_CALORI + " TEXT," + FOOD_TIME + " TEXT," + "TEXT"+ ")";

    private String DROP_TABLE = "DROP TABLE IF EXISTS " + EXERCISE ;
    private String DROP_TABLE1 = "DROP TABLE IF EXISTS " + FOOD ;

    public mydbhandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }
    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EX_TABLE);
       db.execSQL(CREATE_FOOD_TABLE);

    }
    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL(DROP_TABLE); onCreate(db);
      db.execSQL(DROP_TABLE1); onCreate(db);

    }
    public void addEx(String exercise, String sets, String reps, String calorieBurned,String time) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(mydbhandler.EXERCISE_NAME,exercise);
        values.put(mydbhandler.EX_SET,sets);
        values.put(mydbhandler.EX_REP,reps);
        values.put(mydbhandler.EX_CALORIE,calorieBurned);
        values.put(mydbhandler.EX_TIME,time);

        long status=db.insert(EXERCISE ,null,values);
        if(status<=0){
            Toast.makeText(context, "Insertion Unsuccessful", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Insertion Successful", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
    public void addFood(String name, String meal, String calories, String time) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(mydbhandler.FOOD_NAME,name);
        values.put(mydbhandler.FOOD_TYPE,meal);
        values.put(mydbhandler.FOOD_CALORI,calories);
        values.put(mydbhandler.FOOD_TIME,time);

        long status=db.insert(FOOD ,null,values);
        if(status<=0){
            Toast.makeText(context, "Insertion Unsuccessful", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Insertion Successful", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

     public String loadEX() {
        String result = "";
        String query = "Select*FROM " + EXERCISE ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext())
        {
            String result_0 = cursor.getString(0);
            String result_1 = cursor.getString(1);
            String result_2 = cursor.getString(2);
            String result_3 = cursor.getString(3);
            String result_4 = cursor.getString(4);

            result += result_4+"\n"+ "  Exercise " +result_0 + " " +"\n" + result_1 + "  Sets " +"\n" + result_2 + "  Reps " +"\n" + result_3 + "  Calories Burned" +"\n"  +"\n";
            System.getProperty("line.separator");
            System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public String loadFOOD() {
        String result = "";
        String query = "Select*FROM " + FOOD ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext())
        {
            // ADD DAY/DATE TO DBASE
            String result_0 = cursor.getString(0);
            String result_1 = cursor.getString(1);
            String result_2 = cursor.getString(2);
            String result_3 = cursor.getString(3);

            result += result_3+ "\n"+" food: " +result_0  + "\n" +" meal: " + result_1 +"\n"+ "  calories: " + result_2 + "\n" +"\n";
            System.getProperty("line.separator");
            System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

}
