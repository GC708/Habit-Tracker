package habitTracker;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

/**
 * Author: Gerbert R. Castro Granados
 *
 * This class initializes the JFX UI and sets up the main components:
 * - Stage: The app window
 * - Scene: Holds all UI elements
 * - Scene-Graph: Roots, branches, leaves (for layout containers, buttons, labels, etc.)
 */

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Load FXML layout file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/table-view.fxml"));
            Parent root = loader.load();

            // Create Scene with loaded UI
            Scene scene = new Scene(root, 690, 430);

            // Apply CSS
            String css = getClass().getResource("/css/remove-empty-table-rows.css").toExternalForm();
            scene.getStylesheets().add(css);

            // Set up icon
            Image icon = new Image(getClass().getResource("/images/basic-program-icon.png").toExternalForm());
            stage.getIcons().add(icon);

            // Set the stage
            stage.setTitle("Habit Tracker");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("Something went wrong.");
        }
    }

    public static void main(String[] args) {
        launch(args); // Starts the JavaFX application
    }
}


