package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginGUI extends Stage {

    public LoginGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginGUI.fxml"));
            Parent root = loader.load();

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
