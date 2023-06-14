package org.example;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Sleep {
    private LocalDate date;
    private LocalTime sleepTime;
    private LocalTime wakeTime;

    public Sleep(LocalDate date, LocalTime sleepTime, LocalTime wakeTime) {
        this.date = LocalDate.from(date);
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
    }

    public int getHoursSlept() {
        Duration hours = Duration.between(sleepTime, wakeTime);
        return (int) hours.toHours();
    }

    public void getDate() {
        this.date = date;
    }
}
