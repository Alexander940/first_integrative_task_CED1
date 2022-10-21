package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.MedicalCenter;
import model.Patient;

import java.io.IOException;

public class ShowListPriorityPatientsHematologyGUI extends Stage {

    private TableView<Patient> tableView;

    public ShowListPriorityPatientsHematologyGUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShowListPriorityPatientsHematologyGUI.fxml"));
            Parent root = loader.load();

            tableView = (TableView<Patient>) loader.getNamespace().get("tableView");

            TableColumn<Patient, String> nameColumn = new TableColumn<>("NAME");
            TableColumn<Patient, String> lastnameColumn = new TableColumn<>("LASTNAME");
            TableColumn<Patient, Boolean> priorityColumn = new TableColumn<>("PRIORITY");
            TableColumn<Patient, String> ageColumn = new TableColumn<>("AGE");

            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
            ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

            tableView.getColumns().addAll(nameColumn, lastnameColumn, ageColumn, priorityColumn);
            tableView.setItems(MedicalCenter.getInstance().getListPriorityPatientsHematology());

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void init() {
    }
}
