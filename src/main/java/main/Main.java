package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.PatientInventory;
import ui.LoginGUI;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.show();
    }
}