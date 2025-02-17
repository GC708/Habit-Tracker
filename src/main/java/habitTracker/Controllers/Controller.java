package habitTracker.Controllers;

import habitTracker.Models.Model;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    // FXML elements from the UI
    @FXML
    private AnchorPane HabitTracker; // Main layout container

    @FXML
    private TableView<Model>  tableView; // displays table

    @FXML
    private TableColumn<Model,String> colHabit; // column for user habits

    @FXML
    private TableColumn<Model, String> colDate; // Column for date & time

    @FXML
    private TextField textFieldHabit; // Input field for new habits

    /**
     * The initialize method sets up table columns and makes the table editable.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // set up columns to use appropriate getters from Model class
        colHabit.setCellValueFactory(new PropertyValueFactory<>("UserHabit"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("timeStamp"));

        // Make table editable and allow text and editing in the userHabit column
        tableView.setEditable(true);
        colHabit.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    /**
     * Adds a new habit to the table.
     * @param actionEvent Event triggered by Add button click.
     */
    public void buttonAdd(ActionEvent actionEvent) {
        Model model = new Model(textFieldHabit.getText());
        tableView.getItems().add(model);
    }

    /**
     * Habits entered by the user are displayed in console.
     * @param actionEvent Event triggered by Show button click.
     */
    public void buttonShow(ActionEvent actionEvent) {
        Model model = new Model();

        List <List<String>> arrList = new ArrayList<>();

        // Add each habit to the list
        for (int i = 0; i < tableView.getItems().size(); i++) {
            model = tableView.getItems().get(i);
            arrList.add(new ArrayList<>());
            arrList.get(i).add(model.userHabit.get());
        }

        // Print all habits to the console
        for (int i = 0; i < arrList.size(); i++) {
            for (int j = 0; j < arrList.get(i).size(); j++) {
                System.out.println(arrList.get(i).get(j));
            }
        }
    }

    /**
     * Removes selected habit from table.
     * @param actionEvent Event triggered by Remove button click.
     */
    public void buttonRemove(ActionEvent actionEvent) {
        ObservableList<Model> allModels,singleModel;
        allModels = tableView.getItems();
        singleModel = tableView.getSelectionModel().getSelectedItems();
        singleModel.forEach(allModels::remove);
    }

    /**
     * Edits a preexisting habit in the selected row.
     * @param modelStringCellEditEvent Event triggered by editing cell.
     */
    public void editRow(TableColumn.CellEditEvent<Model, String> modelStringCellEditEvent) {
        Model model = tableView.getSelectionModel().getSelectedItem();
        model.setUserHabit(modelStringCellEditEvent.getNewValue());
    }

    /**
     * Clears all rows from the table.
     * @param actionEvent Event triggered by Clear button click.
     */
    public void buttonDeleteAllRows(ActionEvent actionEvent) {
        tableView.getItems().clear();
    }
}
