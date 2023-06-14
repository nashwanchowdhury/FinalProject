package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class UserService {
    private Map<String, User> users;
    private Scanner scanner;
    private User currentUser;

    public UserService() {
        this.scanner = new Scanner(System.in);
        this.users = new HashMap<>();
        User user1 = new User("nash");

        user1.getFoodItems().add(new Food(LocalDate.of(2012, 5, 11), "hamburger", 500));
        user1.getExerciseActivities().add(new Exercise("running", 60, 200, LocalDate.of(2023, 6, 10)));
        user1.getSleep().add(new Sleep(LocalDate.of(2023, 6, 10), LocalTime.of(23,0), LocalTime.of(6,0)));
    }
    public void addUser(String username, User user) {
        users.put(username, user);
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public boolean verifyUser(String username) {
        return users.containsKey(username);
    }

    public void login(String username) {
        User user = getUserByUsername(username);

        if (username != null && verifyUser(username)) {
            // User is logged in successfully
            currentUser = user;
            System.out.println("Logged in as " + username);
        } else {
            // Invalid username or password
            System.out.println("Invalid username or password");
        }
    }

    public void register(String username) {

        if (!verifyUser(username)) {
            users.put(username, new User(username));

            // Inform the user that the registration was successful
            System.out.println("Registration successful. Please log in with your new account.");
        } else {
            // Username is not valid (e.g., already exists)
            System.out.println("Username is already taken. Please choose a different username.");
        }
    }

    public void logout() {
        // Logic for user logout
        // Perform any necessary cleanup or session management
        System.out.println("Logged out");
    }

    public void exit() {
        // Logic to exit the application
        System.out.println("Exiting the application");
        System.exit(0);
    }
}
