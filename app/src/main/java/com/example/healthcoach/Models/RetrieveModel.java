package com.example.healthcoach.Models;

public class RetrieveModel {

    private String exercise;
    private String Food;
    private Double Foodcalorie;
    private int calorieBurned;

    public RetrieveModel(String exercise, String food, Double foodcalorie, int calorieBurned) {
        this.exercise = exercise;
        Food = food;
        Foodcalorie = foodcalorie;
        this.calorieBurned = calorieBurned;
    }

    public String getExercise() {
        return exercise;
    }

    public String getFood() {
        return Food;
    }

    public Double getFoodcalorie() {
        return Foodcalorie;
    }

    public int getCalorieBurned() {
        return calorieBurned;
    }
}
