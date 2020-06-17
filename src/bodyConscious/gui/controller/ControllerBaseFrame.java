package bodyConscious.gui.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class ControllerBaseFrame implements Initializable {

    @FXML
    private BorderPane bp;

    @FXML
    private AnchorPane ap;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void goHome(MouseEvent mouseEvent) {
        bp.setCenter(ap);
    }
    public void goToBodyProperties(MouseEvent mouseEvent) {
        loadPage("../fxml/bodyProperties");
    }
    public void goToSimulation(MouseEvent mouseEvent) {
        loadPage("../fxml/simulation");
    }
    public void goToCharts(MouseEvent mouseEvent) {
        loadPage("../fxml/charts");
    }

    public void exit(MouseEvent mouseEvent) {
        Platform.exit();
        System.exit(0);
    }

    private void loadPage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bp.setCenter(root);
    }

}




