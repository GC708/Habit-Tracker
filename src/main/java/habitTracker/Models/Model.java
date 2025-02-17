package habitTracker.Models;

import javafx.beans.property.SimpleStringProperty;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Model {
    // SimpleStringProperty to link the habit text to the UI (TableView)
    public SimpleStringProperty userHabit;
    private SimpleStringProperty timeStamp;

    public Model(String userHabit) {
        this.userHabit = new SimpleStringProperty(userHabit);
        this.timeStamp = new SimpleStringProperty("");
        setCurrentTime(); // Automatically sets timestamp when user creates habit
    }

    // Default constructor for buttonShow method in Controller
    public Model() {
    }

    public String getUserHabit() {
        return userHabit.get(); // Retrieves the value of the userHabit property
    }

    public void setUserHabit(String userHabit) {
        this.userHabit = new SimpleStringProperty(userHabit);
    }

    public String getTimeStamp() {
        return timeStamp.get(); // Retrieves the value of timeStamp property
    }

    public void setCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMM dd HH:mm:ss z yyyy");
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Los_Angeles")); // Set to Pacific Time Zone (PST/PDT)
        this.timeStamp.set(now.format(formatter)); // Set the formatted timestamp in the timeStamp Property
    }
}
