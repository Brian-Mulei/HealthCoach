package com.example.healthcoach.Models;

public class ExerciseModel {
     String Exercise;
    String sets;
    String reps;
    Double calorieBurned;

    public ExerciseModel(String exercise, String sets, String reps, Double calorieBurned) {
        Exercise = exercise;
        this.sets = sets;
        this.reps = reps;
        this.calorieBurned = calorieBurned;
    }

    public String getExercise() {
        return Exercise;
    }

    public void setExercise(String exercise) {
        Exercise = exercise;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public Double getCalorieBurned() {
        return calorieBurned;
    }

    public void setCalorieBurned(Double calorieBurned) {
        this.calorieBurned = calorieBurned;
    }
}
