package org.example;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseService {
    private Scanner scanner;
    private static User user;
    public ExerciseService() {
        this.scanner = new Scanner(System.in);
    }
    public User getUser() {
        return user;
    }

    public static void setUser(User user) {
        ExerciseService.user = user;
    }

    public static void showEntries() {
        for (Exercise entry : user.getExerciseActivities()) {
            System.out.println(entry.toString());
        }
    }

    public static void addEntry(Exercise entry) {
        user.getExerciseActivities().add(entry);
    }
    public static void enterExercise(String exercise, int duration, int caloriesBurned, LocalDate now) {
        addEntry(new Exercise(exercise, duration, caloriesBurned, LocalDate.now()));
    }
}
