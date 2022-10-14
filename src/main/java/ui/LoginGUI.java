package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MedicalCenter;
import model.Patient;

import java.io.IOException;

public class LoginGUI extends Stage {

    private Button button;
    private TextField nameTF;
    private PasswordField passwordPF;

    public LoginGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginGUI.fxml"));
            Parent root = loader.load();

            button = (Button) loader.getNamespace().get("button");
            nameTF = (TextField) loader.getNamespace().get("nameTF");
            passwordPF = (PasswordField) loader.getNamespace().get("passwordPF");

            Scene scene = new Scene(root, 250, 250);
            setScene(scene);

            init();
        }catch (IOException exception){
            exception.printStackTrace();
        }

    }

    private void init() {
        MedicalCenter med = new MedicalCenter();
        HomeGUI home = new HomeGUI();
        button.setOnAction(event -> {
            if (med.compPassword(passwordPF.getText(), nameTF.getText())) {

                home.show();

            }
        });
    }
}