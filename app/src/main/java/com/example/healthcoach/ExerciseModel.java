package com.example.healthcoach;

public class ExerciseModel {
     String Exercise;
    String sets;
    String reps;

    public ExerciseModel(String exercise, String sets, String reps) {
        Exercise = exercise;
        this.sets = sets;
        this.reps = reps;
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
}
