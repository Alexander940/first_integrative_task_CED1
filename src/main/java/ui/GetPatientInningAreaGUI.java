package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MedicalCenter;
import model.Patient;

import java.io.IOException;

public class GetPatientInningAreaGUI extends Stage {

    private Button hematologyBtn;
    private Button generalBtn;
    private Button backBtn;
    private Patient patient;

    public GetPatientInningAreaGUI(Patient patient) {
        try{
            this.patient = patient;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GetPatientInningAreaGUI.fxml"));
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
            GetPatientInningConfirmGUI getPatientInningConfirmGUI = new GetPatientInningConfirmGUI(patient, MedicalCenter.Area.HEMATOLOGY);
            getPatientInningConfirmGUI.show();
            this.close();
        });

        generalBtn.setOnAction(event -> {
            GetPatientInningConfirmGUI getPatientInningConfirmGUI = new GetPatientInningConfirmGUI(patient, MedicalCenter.Area.GENERAL);
            getPatientInningConfirmGUI.show();
            this.close();
        });

        backBtn.setOnAction(event -> {
            GetPatientInningGUI getPatientInningGUI = new GetPatientInningGUI();
            getPatientInningGUI.show();
            this.close();
        });
    }
}
