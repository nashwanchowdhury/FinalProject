package org.example;
import java.util.List;
import java.util.ArrayList;

public class User {
    private String username;
    private List<Food> food;
    private List<Exercise> exercise;
    private List<Sleep> sleep;

    public User(String username) {
        this.username = username;
        this.food = new ArrayList<>();
        this.exercise = new ArrayList<>();
        this.sleep = new ArrayList<>();
    }

    public String getUsername() {
        return this.username;
    }

    public List<Food> getFoodItems() {
        return this.food;
    }

    public List<Exercise> getExerciseActivities() {
        return this.exercise;
    }

    public List<Sleep> getSleep() {
        return this.sleep;
    }

    // setter methods
    public void addFood(Food foods) {
            food.add(foods);
        }


    public void addExercise(Exercise exercises) {
            exercise.add(exercises);
        }

    public void addSleepRecord(Sleep sleeps) {
            sleep.add(sleeps);
        }

    @Override
    public String toString() {
        return "User [username=" + username + "]";
    }


}
