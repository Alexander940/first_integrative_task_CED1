package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.MedicalCenter;
import model.Patient;

import java.io.IOException;

public class GetPatientInningConfirmGUI extends Stage {

    private Patient patient;
    MedicalCenter.Area area;
    private Label patientLabel;
    private Label areaLabel;
    private Button confirmBtn;
    private Button backBtn;

    public GetPatientInningConfirmGUI(Patient patient, MedicalCenter.Area area) {
        try{
            this.patient = patient;
            this.area = area;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GetPatientInningConfirmGUI.fxml"));
            Parent root = loader.load();

            patientLabel = (Label) loader.getNamespace().get("patientLabel");
            areaLabel = (Label) loader.getNamespace().get("areaLabel");
            confirmBtn = (Button) loader.getNamespace().get("confirmBtn");
            backBtn = (Button) loader.getNamespace().get("backBtn");

            Scene scene = new Scene(root, 300, 250);
            setScene(scene);

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private void init() {
        patientLabel.setText(patient.getName() + " " + patient.getLastname());
        areaLabel.setText(String.valueOf(area));

        confirmBtn.setOnAction(event -> {
            MedicalCenter.getInstance().enterPatient(patient, area);
            this.close();
        });

        backBtn.setOnAction(event -> {
            GetPatientInningAreaGUI getPatientInningAreaGUI = new GetPatientInningAreaGUI(patient);
            getPatientInningAreaGUI.show();
            this.close();
        });
    }
}
