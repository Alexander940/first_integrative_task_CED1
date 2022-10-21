package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowListGUI extends Stage {

    private Button generalBtn;
    private Button priorityHematologyBtn;
    private Button normalHematologyBtn;
    private Button priorityGeneralBtn;
    private Button normalGeneralBtn;

    public ShowListGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShowListGUI.fxml"));
            Parent root = loader.load();

            generalBtn = (Button) loader.getNamespace().get("generalBtn");
            priorityHematologyBtn = (Button) loader.getNamespace().get("priorityHematologyBtn");
            normalHematologyBtn = (Button) loader.getNamespace().get("normalHematologyBtn");
            priorityGeneralBtn = (Button) loader.getNamespace().get("priorityGeneralBtn");
            normalGeneralBtn = (Button) loader.getNamespace().get("normalGeneralBtn");

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private void init() {

        generalBtn.setOnAction(event -> {
            ShowListAllPatientsGUI showListAllPatientsGUI = new ShowListAllPatientsGUI();
            showListAllPatientsGUI.show();
        });

        priorityHematologyBtn.setOnAction(event -> {
            ShowListPriorityPatientsHematologyGUI showListPriorityPatientsHematologyGUI = new ShowListPriorityPatientsHematologyGUI();
            showListPriorityPatientsHematologyGUI.show();
        });

        normalHematologyBtn.setOnAction(event -> {
            ShowListNormalPatientsHematologyGUI showListNormalPatientsHematologyGUI = new ShowListNormalPatientsHematologyGUI();
            showListNormalPatientsHematologyGUI.show();
        });

        priorityGeneralBtn.setOnAction(event -> {
            ShowListNormalPatientsGeneralGUI showListNormalPatientsGeneralGUI = new ShowListNormalPatientsGeneralGUI();
            showListNormalPatientsGeneralGUI.show();
        });

        normalGeneralBtn.setOnAction(event -> {
            ShowListNormalPatientsGeneralGUI showListNormalPatientsGeneralGUI = new ShowListNormalPatientsGeneralGUI();
            showListNormalPatientsGeneralGUI.show();
        });
    }
}
