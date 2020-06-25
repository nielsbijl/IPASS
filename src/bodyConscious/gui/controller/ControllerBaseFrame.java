package bodyConscious.gui.controller;

import bodyConscious.gui.GUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class ControllerBaseFrame extends GUI implements Initializable {

    @FXML
    private ImageView settingsButton;

    @FXML
    public Button bodyProperties;

    @FXML
    public Button exitButtonBaseFrame;

    @FXML
    public Button homePageSmallCloseButton;

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
        loadPage("../fxml/bodyproperties");
    }
    public void goToSimulation(MouseEvent mouseEvent) {
        loadPage("../fxml/simulation");
    }
    public void goToCharts(MouseEvent mouseEvent) throws IOException {
        loadPage("../fxml/charts");
        openPopup();
    }
    public void openSettings(MouseEvent mouseEvent) { loadPage("../fxml/settings");}

    public void exit(MouseEvent mouseEvent) throws IOException {
        exit();
    }

    private void loadPage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
            root.setId(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bp.setCenter(root);
    }

}




