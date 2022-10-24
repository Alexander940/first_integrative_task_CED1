package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeGUI extends Stage {

    private Button enterPatientBT;
    private Button openListBT;
    private Button getPatientBT;
    private Button deletePatientBT;

    public HomeGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HomeGUI.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 600, 400);
            setScene(scene);

            enterPatientBT = (Button) loader.getNamespace().get("enterPatientBT");
            openListBT = (Button) loader.getNamespace().get("openListBT");
            getPatientBT = (Button) loader.getNamespace().get("getPatientBT");
            deletePatientBT = (Button) loader.getNamespace().get("deletePatientBT");

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private void init() {

        enterPatientBT.setOnAction(event -> {
            EnterPatientGUI enterPatientGUI = new EnterPatientGUI();
            enterPatientGUI.show();
        }) ;

        openListBT.setOnAction(event -> {
            ShowListGUI showListGUI = new ShowListGUI();
            showListGUI.show();
            this.close();

        });

        getPatientBT.setOnAction(event -> {
            GetPatientInningGUI getPatientInningGUI = new GetPatientInningGUI();
            getPatientInningGUI.show();
        });

        deletePatientBT.setOnAction(event -> {



        });

    }
}
