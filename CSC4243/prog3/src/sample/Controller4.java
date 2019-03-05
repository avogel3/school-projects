package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller4 {

    @FXML
    private Button intro_button;

    @FXML
    private Button video_button;


    @FXML
    private void handleIntroButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me");
        Parent state_page_parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene state_page_scene = new Scene(state_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.setScene(state_page_scene);
        app_stage.show();
    }


    @FXML
    private void handleVideoButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me");
        Parent state_page_parent = FXMLLoader.load(getClass().getResource("sample3.fxml"));
        Scene state_page_scene = new Scene(state_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.setScene(state_page_scene);
        app_stage.show();
    }
}