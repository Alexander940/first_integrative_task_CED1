package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeGUI extends Stage {

    public HomeGUI() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HomeGUI.fxml"));
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
