package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SleepService {
    private Scanner scanner;

    private static User user;

    public SleepService() {
        this.scanner = new Scanner(System.in);
    }

    public User getUser() {
        return user;
    }

    public static void setUser(User user) {
        SleepService.user = user;
    }


    public static void addEntry(Sleep entry) {
        user.getSleep().add(entry);
    }

    public void showEntries() {
        for (Sleep entry : user.getSleep()) {
            System.out.println(entry.toString());
        }
    }

    public static void enterSleepEntry(LocalDate startTime, LocalTime endTime, LocalDate now) {
        Sleep sleepEntry = new Sleep(startTime, endTime, LocalTime.now());
        addEntry(sleepEntry);

    }
}
