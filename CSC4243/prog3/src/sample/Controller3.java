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

public class Controller3 {

    @FXML
    private Button tb_button;

    @FXML
    private Button intro_button;

    @FXML
    private Button stjohn_button;

    @FXML
    private Button gulf_button;

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
    private void handleTbButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me");
        Parent state_page_parent = FXMLLoader.load(getClass().getResource("sample4.fxml"));
        Scene state_page_scene = new Scene(state_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.setScene(state_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleStjohnButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me");
        Parent state_page_parent = FXMLLoader.load(getClass().getResource("sample6.fxml"));
        Scene state_page_scene = new Scene(state_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.setScene(state_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleGulfButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me");
        Parent state_page_parent = FXMLLoader.load(getClass().getResource("sample5.fxml"));
        Scene state_page_scene = new Scene(state_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.setScene(state_page_scene);
        app_stage.show();
    }

}
