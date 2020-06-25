package bodyConscious;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //GUI startup
        //Opent de baseFrame.fxml
        //Iedere fxml file heeft zijn eigen controller class die alles per fxml file regelt
        Parent root = FXMLLoader.load(getClass().getResource("gui/fxml/baseFrame.fxml"));
        primaryStage.setTitle("Body Conscious");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
