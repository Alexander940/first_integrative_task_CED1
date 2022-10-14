package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerGUI extends Stage {

    public ControllerGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ControllerGUI.fxml"));
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
