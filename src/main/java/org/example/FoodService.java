package org.example;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FoodService {
    private Scanner scanner;
    private static User user;

    public FoodService() {
        this.scanner = new Scanner(System.in);
    }

    public static void enterCaloriesIntake(LocalDate now, String foodItem, int calories) {
        addEntry(new Food(LocalDate.now(), foodItem, calories));
    }


    public User getUser() {
        return user;
    }

    public static void setUser(User user) {
        FoodService.user = user;
    }

    public void showEntries() {
        for (Food entry : user.getFoodItems()) {
            System.out.println(entry.toString());
        }
    }

    public static void addEntry(Food entry) {
        user.getFoodItems().add(entry);
    }
    public static void enterCaloriesIntake(String food, int calories) {
        addEntry(new Food(LocalDate.now(), food, calories));
    }
}
