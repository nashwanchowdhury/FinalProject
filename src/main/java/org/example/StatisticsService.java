package org.example;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class StatisticsService {
    private Scanner scanner;

    private static User user;

    public StatisticsService() {
        this.scanner = new Scanner(System.in);
    }

    public User getUser() {
        return user;
    }

    public static void setUser(User user) {
        StatisticsService.user = user;
    }

    public static void caloricBalance(LocalDate day) {
        Map<LocalDate, Integer> intake = new HashMap<>();
        Map<LocalDate, Integer> burned = new HashMap<>();

        for(Food entry : user.getFoodItems()) {
            LocalDate date = entry.getDate();
            int calories = entry.getCalories();
            if (intake.containsKey(date)) {
                int existingValue = intake.get(date);
                calories += existingValue;
            }

            intake.put(date, calories);
        }

        for(Exercise entry : user.getExerciseActivities()) {
            LocalDate date = entry.getDate();
            int caloriesBurned = entry.getCaloriesBurned();
            if (burned.containsKey(date)) {
                int existingValue = intake.get(date);
                caloriesBurned += existingValue;
            }

            burned.put(date, caloriesBurned);
        }

        int caloric = intake.get(day) - burned.get(day);

        System.out.println("Daily Caloric Balance is " + caloric);

    }

    public static void averageHoursOfSleep(LocalDate day) {
        LocalDate startDate = day.minusDays(7);

        long total = 0;

        for (Sleep entry : user.getSleep()) {
            total += entry.getHoursSlept();
        }
        System.out.println("Average hours slept in past week is " + total);
    }
    public void displayExercises() {
        for (Exercise entry : user.getExerciseActivities()) {
            System.out.println("Exercise: " + entry.getType());
            System.out.println("Duration: " + entry.getDuration());
            System.out.println("Calories Burned: " + entry.getCaloriesBurned());
            System.out.println("Date: " + entry.getDate());
            System.out.println();
        }
    }

}
