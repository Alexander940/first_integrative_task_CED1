package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPatientGUI extends Stage {

    TextField patientNameTF;
    Button enqueuePatientBtn;

    public AddPatientGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddPatientGUI.fxml"));
            Parent root = loader.load();

            patientNameTF = (TextField) loader.getNamespace().get("patientNameTF");
            enqueuePatientBtn = (Button) loader.getNamespace().get("enqueuePatientBtn");

            Scene scene = new Scene(root, 250, 250);
            setScene(scene);

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }

    }

    private void init() {

    }
}
