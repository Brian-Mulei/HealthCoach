package com.example.healthcoach.Models;

public class Model {
    String Name;
    String Meal;
    String Calories;

    public Model(String name, String meal, String calories) {
        Name = name;
        Meal = meal;
        Calories = calories;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMeal() {
        return Meal;
    }

    public void setMeal(String meal) {
        Meal = meal;
    }

    public String getCalories() {
        return Calories;
    }

    public void setCalories(String calories) {
        Calories = calories;
    }
}
