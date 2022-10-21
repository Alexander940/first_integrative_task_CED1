package ui;

import exceptions.PatientNotFoundException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MedicalCenter;
import model.Patient;
import util.AlertUtil;

import java.io.IOException;

public class GetPatientInningGUI extends Stage {

    private TextField patientNameTF;
    private TextField patientLastnameTF;
    private Button enqueuePatientBtn;

    public GetPatientInningGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GetPatientInningGUI.fxml"));
            Parent root = loader.load();

            patientNameTF = (TextField) loader.getNamespace().get("patientNameTF");
            patientLastnameTF = (TextField) loader.getNamespace().get("patientLastnameTF");
            enqueuePatientBtn = (Button) loader.getNamespace().get("enqueuePatientBtn");

            Scene scene = new Scene(root, 300, 250);
            setScene(scene);

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }

    }

    private void init() {
        enqueuePatientBtn.setOnAction(event -> {
            if(patientNameTF.getText().equals("") || patientLastnameTF.getText().equals("")){
                AlertUtil.errorAlert("Error", "You should fill all fields", "");
            } else {
                try{
                    Patient patient = MedicalCenter.getInstance().findPatient(patientNameTF.getText()+patientLastnameTF.getText());
                    GetPatientInningAreaGUI getPatientInningAreaGUI = new GetPatientInningAreaGUI(patient);
                    getPatientInningAreaGUI.show();
                    this.close();
                } catch (PatientNotFoundException exception) {
                    AlertUtil.errorAlert("Error", "The patient was not found", "");
                    exception.printStackTrace();
                }

            }

        });
    }
}
