module habitTracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens habitTracker to javafx.fxml;
    exports habitTracker;
    exports habitTracker.Controllers;
    opens habitTracker.Controllers to javafx.fxml;
    exports habitTracker.Models;
    opens habitTracker.Models to javafx.fxml;
}