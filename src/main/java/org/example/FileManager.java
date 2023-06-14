package org.example;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class FileManager {
    UserService userService;

    public FileManager(UserService userService) {
        this.userService = userService;
    }


    public void saveData() {
        try {
            // Write the users and their health data to a file(s)
            FileWriter writer = new FileWriter("userdata.txt");
            for (Map.Entry<String, User> entry : userService.getUsers().entrySet()) {
                writer.write(entry.getValue().getUsername() + "," + entry.getValue().getFoodItems() + "," + entry.getValue().getExerciseActivities() + "," + entry.getValue().getSleep() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("userdata.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\\[");
                String username = parts[0];
                User user = userService.getUserByUsername(username);
                if (user == null) {
                    user = new User(username);
                    userService.getUsers().put(username,user);
                }

                // Parse calorie entries
                String calorieEntriesStr = parts[1];
                String[] calorieEntriesArr = calorieEntriesStr.substring(1, calorieEntriesStr.length() - 1).split("\\},\\s*\\{");
                for (String entry : calorieEntriesArr) {
                    String[] splitEntry = entry.split(",\\{");
                    String [] result = splitEntry[0].split(",");
                    String foodName = result[0].replaceAll("\\{", "");
                    int calories = Integer.parseInt(result[1]);
                    LocalDate date = LocalDate.parse(result[2].replaceAll("}", ""));
                    Food food = new Food(date, foodName, calories);

                    if (user.getFoodItems().size() == 0) {
                        user.getFoodItems().add(food);
                    }
                }

                // Parse exercise entries
                String exerciseEntriesStr = parts[2];
                String[] exerciseEntriesArr = exerciseEntriesStr.substring(1, exerciseEntriesStr.length() - 1).split("\\},\\s*\\{");
                for (String entry : exerciseEntriesArr) {
                    String[] splitEntry = entry.split(",\\{");
                    String [] result = splitEntry[0].split(",");
                    String exerciseName = result[0].replaceAll("\\{", "");;
                    int duration = Integer.parseInt(result[1]);
                    int caloriesBurned = Integer.parseInt(result[2]);
                    String category = result[3];
                    LocalDate date = LocalDate.parse(result[4].replaceAll("}", ""));
                    Exercise exerciseEntry = new Exercise(exerciseName, duration, caloriesBurned, date);

                    if (user.getExerciseActivities().size() == 0) {
                        user.getExerciseActivities().add(exerciseEntry);
                    }
                }

                // Parse sleep entries
                String sleepEntriesStr = parts[3];
                String[] sleepEntriesArr = sleepEntriesStr.substring(1, sleepEntriesStr.length() - 1).split("\\},\\s*\\{");
                for (String entry : sleepEntriesArr) {
                    String[] splitEntry = entry.split(",\\{");
                    String [] result = splitEntry[0].split(",");
                    LocalTime startTime = LocalTime.parse(result[0].replaceAll("\\{", ""));
                    LocalTime endTime = LocalTime.parse(result[1]);
                    LocalDate date = LocalDate.parse(result[3].replaceAll("}", ""));
                    Sleep sleepEntry = new Sleep(date, startTime, endTime);
                    if (user.getSleep().size() == 0) {
                        user.getSleep().add(sleepEntry);
                    }
                }

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
