package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeGUI extends Stage {

    private Button addPacientBT;
    private Button openListBT;
    private Button getPacientBT;
    private Button deletePacientBT;

    public HomeGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HomeGUI.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 250, 250);
            setScene(scene);

            addPacientBT = (Button) loader.getNamespace().get("addPatientBT");
            openListBT = (Button) loader.getNamespace().get("openListBT");
            getPacientBT = (Button) loader.getNamespace().get("getPatientBT");
            deletePacientBT = (Button) loader.getNamespace().get("deletePacientBT");

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private void init() {

        addPacientBT.setOnAction(event -> {



        }) ;

        openListBT.setOnAction(event -> {



        });

        getPacientBT.setOnAction(event -> {



        });

        deletePacientBT.setOnAction(event -> {



        });

    }
}
