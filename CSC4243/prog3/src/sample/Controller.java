package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button state_button;

    @FXML
    private Button random_button;

    @FXML
    private Button next_view;

    @FXML
    private Button intro_button;

    @FXML
    private WebView video_view;

    @FXML
    private  WebEngine engine;

    @FXML
    public void initialize() {
        this.engine = this.video_view.getEngine();
        this.engine.load("http://vid40.photobucket.com/albums/e223/dstroyers4pulse/Water%20Conservation%20Video%20_%20Ashley%20Nicole%20Greene%20Narrator%20-%20HD%20720p%20File2HD.com.mp4");
    }



    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me");
        Parent state_page_parent = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Scene state_page_scene = new Scene(state_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.setScene(state_page_scene);

        //com.leapmotion.leap.Controller c = new com.leapmotion.leap.Controller();
        //LeapListener listener = new LeapListener();
        //c.addListener(listener);

        app_stage.show();
    }

}