package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeGUI extends Stage {

    private Button addPatientBT;
    private Button openListBT;
    private Button getPatientBT;
    private Button deletePatientBT;

    public HomeGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HomeGUI.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 250, 250);
            setScene(scene);

            addPatientBT = (Button) loader.getNamespace().get("addPatientBT");
            openListBT = (Button) loader.getNamespace().get("openListBT");
            getPatientBT = (Button) loader.getNamespace().get("getPatientBT");
            deletePatientBT = (Button) loader.getNamespace().get("deletePatientBT");

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private void init() {

        addPatientBT.setOnAction(event -> {



        }) ;

        openListBT.setOnAction(event -> {



        });

        getPatientBT.setOnAction(event -> {



        });

        deletePatientBT.setOnAction(event -> {



        });

    }
}
