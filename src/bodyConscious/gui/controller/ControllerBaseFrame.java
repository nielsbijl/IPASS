package bodyConscious.gui.controller;

//Dit is de controller class van de baseFrame.fxml
//Als baseFrame.fxml geladen wordt, dan wordt deze class met zijn functies aan geroepen

import bodyConscious.gui.GUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class ControllerBaseFrame extends GUI implements Initializable {

    @FXML
    private ImageView settingsButton;

    @FXML
    private Button bodyProperties;

    @FXML
    private Button exitButtonBaseFrame;

    @FXML
    private Button homePageSmallCloseButton;

    @FXML
    private BorderPane baseFrame;
    @FXML
    private VBox homePage;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Wanneer baseFrame.fxml wordt geopend wordt deze functie als eerste uitgevoerd
    }

    public void goHome(MouseEvent mouseEvent) {
        //Wanneer je op de home button clickt wordt deze functie uitgevoerd
        //Hij veranderd de center van de applicatie naar de standaard Vbox
        baseFrame.setCenter(homePage);
    }
    public void goToBodyProperties(MouseEvent mouseEvent) throws IOException {
        //Wanneer je op de BodyProperties button clickt wordt deze functie uitgevoerd
        //Hij veranderd de center van de applicatie naar de bodyproperties.fxml
        loadPage("../fxml/bodyproperties");
    }
    public void goToSimulation(MouseEvent mouseEvent) throws IOException {
        //Wanneer je op de Simulation button clickt wordt deze functie uitgevoerd
        //Hij veranderd de center van de applicatie naar de simulation.fxml
        loadPage("../fxml/simulation");
    }
    public void goToCharts(MouseEvent mouseEvent) throws IOException {
        //Wanneer je op de Charts button clickt wordt deze functie uitgevoerd
        //Hij veranderd de center van de applicatie naar de charts.fxml
        loadPage("../fxml/charts");
//        openPopup();
    }
    public void openSettings(MouseEvent mouseEvent) throws IOException {
        //Wanneer je op de Settings button clickt wordt deze functie uitgevoerd
        //Hij veranderd de center van de applicatie naar de settings.fxml
        loadPage("../fxml/settings");
    }

    public void exit(MouseEvent mouseEvent) throws IOException {
        //Wanneer je op de Exit button clickt wordt deze functie uitgevoerd
        //Hij sluit de applicatie op een nette manier af
        exit();
    }

    private void loadPage(String page) throws IOException {
        //Deze functie laat de fxml files
        //En zet de fxml file als baseFrame center
        //Als er null pointer exceptions zijn omdat er data niet is ingevult komt de popup te voor schijn
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
            root.setId(page);
        } catch (IOException e) {
            openPopup();
        }
        baseFrame.setCenter(root);
    }

}




