package bodyConscious.gui.controller;

import bodyConscious.gui.GUI;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerPopup extends GUI {
    public Button closePopupButton;

    public void closePopup(MouseEvent mouseEvent) {
        Stage stage = (Stage) closePopupButton.getScene().getWindow();
        stage.close();
    }
}
