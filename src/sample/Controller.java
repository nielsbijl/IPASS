package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;



public class Controller implements Initializable {

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
    public void goPage1(MouseEvent mouseEvent) {
        loadPage("fxml/bodyProperties");
    }
    public void goPage2(MouseEvent mouseEvent) {
        loadPage("fxml/page2");
    }
    public void goPage3(MouseEvent mouseEvent) {
        loadPage("fxml/page3");
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




