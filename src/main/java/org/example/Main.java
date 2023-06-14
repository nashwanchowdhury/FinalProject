package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import org.example.FoodService;
import org.example.StatisticsService;
import org.example.SleepService;
import org.example.ExerciseService;
import org.example.Exercise;
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        FoodService calorieEntryService = new FoodService();
        ExerciseService exerciseEntryService = new ExerciseService();
        SleepService sleepEntryService = new SleepService();
        StatisticsService healthAnalysisService = new StatisticsService();
        FileManager fileManager = new FileManager(userService);
        fileManager.loadData();
        Scanner scanner = new Scanner(System.in);

        boolean start = true;

        while (true) {
            System.out.println("Are you an ");
            System.out.println("1. New User");
            System.out.println("2. Returning User");
            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                case 1:
                    System.out.println("Please enter a new account username: ");
                    String usernameInput = scanner.nextLine();
                    userService.register(usernameInput);
                    System.out.println("New account created successfully");
                    break;
                case 2:
                    System.out.println("Enter your username: ");
                    String returningUser = scanner.nextLine();
                    userService.login(returningUser);
                    boolean menu = true;
                    while (menu) {
                        System.out.println("Login Successful");
                        System.out.println("Please choose an option: ");
                        System.out.println("Calorie Menu");
                        System.out.println("1. Add new meal data");
                        System.out.println("2. Calculate Daily Caloric Balance");
                        System.out.println("Exercise Menu");
                        System.out.println("3. Add new exercise data");
                        System.out.println("4. Display Exercise Log");
                        System.out.println("Sleep Menu");
                        System.out.println("5. Add new sleep data");
                        System.out.println("6. Calculate average hours of sleep");
                        System.out.println("7. Generate Health Summary");
                        System.out.println("8. Logout");
                        int choice = Integer.parseInt(scanner.nextLine());
                        User currentUser = userService.getCurrentUser();

                        switch (choice) {
                            case 1:
                                FoodService.setUser(currentUser);
                                System.out.println("Please enter the food item name: ");
                                String foodItem = scanner.nextLine();
                                System.out.println("How many calories are in that food item?");
                                int calories = Integer.parseInt(scanner.nextLine());
                                FoodService.enterCaloriesIntake(LocalDate.now(), foodItem, calories);
                            case 2:
                                StatisticsService.setUser(currentUser);
                                StatisticsService.caloricBalance(LocalDate.now());
                            case 3:
                                ExerciseService.setUser(currentUser);
                                System.out.println("Enter exercise: ");
                                String exercise = scanner.nextLine();
                                System.out.println("Enter the exercise duration: ");
                                int duration = Integer.parseInt(scanner.nextLine());
                                System.out.println("Enter the number of calories burned: ");
                                int caloriesBurned = Integer.parseInt(scanner.nextLine());
                                ExerciseService.enterExercise(exercise, duration, caloriesBurned, LocalDate.now());
                            case 4:
                                ExerciseService.setUser(currentUser);
                                ExerciseService.showEntries();
                            case 5:
                                System.out.println("Enter sleep start time: ");
                                LocalTime starttime = LocalTime.parse(scanner.nextLine());
                                System.out.println("Enter sleep end time: ");
                                LocalTime endtime = LocalTime.parse(scanner.nextLine());
                                SleepService.setUser(currentUser);
                                SleepService.enterSleepEntry(LocalDate.from(starttime), endtime, LocalDate.now());
                                fileManager.saveData();
                            case 6:
                                StatisticsService.setUser(currentUser);
                                StatisticsService.averageHoursOfSleep(LocalDate.now());
                                fileManager.saveData();
                            case 7:
                                StatisticsService.setUser(currentUser);
                            case 8:
                                userService.logout();
                        }
                    }

            }
        }
    }
            }

