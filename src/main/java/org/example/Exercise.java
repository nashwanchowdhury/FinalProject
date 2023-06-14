package org.example;
import java.util.Date;
import java.time.LocalDate;

public class Exercise {
    private LocalDate date;
    private String type;
    private int duration;
    private int caloriesBurned;

    public Exercise(String type, int duration, int caloriesBurned, LocalDate date) {
        this.date = date;
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "Exercise [type=" + type + ", duration=" + duration + ", caloriesBurned=" + caloriesBurned + ", date=" + date + "]";
    }
}
