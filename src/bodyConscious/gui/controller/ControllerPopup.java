package bodyConscious.gui.controller;

//Dit is de controller class van de popup.fxml
//Als popup.fxml geladen wordt, dan wordt deze class met zijn functies aan geroepen
//Deze class regelt alles wat er in de fxml file gebeurt

import bodyConscious.gui.GUI;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerPopup extends GUI {
    public Button closePopupButton;

    public void closePopup(MouseEvent mouseEvent) {
        //Als je op de closePupupButton klikt met de text "Ok" dan wordt de popup afgesloten
        Stage stage = (Stage) closePopupButton.getScene().getWindow();
        stage.close();
    }
}
