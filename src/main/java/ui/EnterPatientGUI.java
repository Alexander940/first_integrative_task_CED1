package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.MedicalCenter;
import model.Patient;
import util.AlertUtil;

import java.io.IOException;

public class EnterPatientGUI extends Stage {

    private Button hematologyBtn;
    private Button generalBtn;
    private Button backBtn;

    public EnterPatientGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EnterPatientGUI.fxml"));
            Parent root = loader.load();

            hematologyBtn = (Button) loader.getNamespace().get("hematologyBtn");
            generalBtn = (Button) loader.getNamespace().get("generalBtn");
            backBtn = (Button) loader.getNamespace().get("backBtn");

            Scene scene = new Scene(root, 300, 250);
            setScene(scene);

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }

    }

    private void init() {
        hematologyBtn.setOnAction(event -> {
            if(MedicalCenter.getInstance().getNormalPatientsHematology().isEmpty() || MedicalCenter.getInstance().getPriorityPatientsHematology().isEmpty()){
                AlertUtil.errorAlert("Error", "There aren't patients to atent in the queue", "");
            } else {

            }
            this.close();
        });

        generalBtn.setOnAction(event -> {

            this.close();
        });

        backBtn.setOnAction(event -> {

            this.close();
        });
    }
}
