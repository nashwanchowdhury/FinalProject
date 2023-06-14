package org.example;

import java.time.LocalDate;

public class Food {
    private static LocalDate date;
    private String foodItem;

    private static int calories;

    public Food(LocalDate date, String foodItem, int calories) {
        this.date = date;
        this.foodItem = foodItem;
        this.calories = calories;
    }

    public static LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public static int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    @Override
    public String toString() {
        return "FoodItem [name=" + foodItem + ", calories=" + calories + ", date=" + date + "]";
    }

}
