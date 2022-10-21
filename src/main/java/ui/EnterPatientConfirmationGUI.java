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

public class EnterPatientConfirmationGUI extends Stage {

    private Button confirmBtn;
    private Label patientNameLabel;
    private Label enterAttentionLabel;
    private MedicalCenter.Area area;

    public EnterPatientConfirmationGUI(MedicalCenter.Area area) {
        this.area = area;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EnterPatientConfirmationGUI.fxml"));
            Parent root = loader.load();

            confirmBtn = (Button) loader.getNamespace().get("confirmBtn");
            patientNameLabel = (Label) loader.getNamespace().get("patientNameLabel");
            enterAttentionLabel = (Label) loader.getNamespace().get("enterAttentionLabel");

            Scene scene = new Scene(root, 300, 250);
            setScene(scene);

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    private void init() {
        Patient patient = MedicalCenter.getInstance().seeNextPatient(area);
        patientNameLabel.setText(patient.getName() + " " + patient.getLastname());
        enterAttentionLabel.setText(String.valueOf(area));

        confirmBtn.setOnAction(event -> {
            MedicalCenter.getInstance().enterPatientToAttention(area);
            this.close();
        });
    }
}
