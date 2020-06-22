package bodyConscious;

import bodyConscious.algorithm.BMR.HarrisBenedict;
import bodyConscious.algorithm.Body;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //GUI startup
        Parent root = FXMLLoader.load(getClass().getResource("gui/fxml/baseFrame.fxml"));
        primaryStage.setTitle("Body Conscious");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


        //Algorithm code
//        System.out.println("-----------------------------------\n" +
//                            "--------------MALE BODY------------\n" +
//                            "-----------------------------------\n");
//
//
//        niels.calculateBMRharrisBenedict();
//        System.out.println("harrisBenedict = " + niels.getProductionOfHeatAtCompleteRest() + " cal");
//        System.out.println("Rounded integer = " + Math.round(niels.getProductionOfHeatAtCompleteRest()) + " cal \n");
//
//        niels.calculateBMRharrisBenedictRevised();
//        System.out.println("harrisBenedictRevised = " + niels.getProductionOfHeatAtCompleteRest() + " cal");
//        System.out.println("Rounded integer = " + Math.round(niels.getProductionOfHeatAtCompleteRest()) + " cal \n");
//
//        niels.calculateBMRmifflinStJeor();
//        System.out.println("mifflinStJeor = " + niels.getProductionOfHeatAtCompleteRest() + " cal");
//        System.out.println("Rounded integer = " + Math.round(niels.getProductionOfHeatAtCompleteRest()) + " cal \n");
//
//        niels.calculateBMRkatchMcArdle();
//        System.out.println("katchMcArdle = " + niels.getProductionOfHeatAtCompleteRest() + " cal");
//        System.out.println("Rounded integer = " + Math.round(niels.getProductionOfHeatAtCompleteRest()) + " cal \n");
//
//
//        System.out.println("\n-----------------------------------\n" +
//                "-------------FEMALE BODY-----------\n" +
//                "-----------------------------------\n");
//
//        Body roos = new Body("Roos", 48, 165, 18, "female", 25);
//
//        roos.calculateBMRharrisBenedict();
//        System.out.println("harrisBenedict = " + roos.getProductionOfHeatAtCompleteRest() + " cal");
//        System.out.println("Rounded integer = " + Math.round(roos.getProductionOfHeatAtCompleteRest()) + " cal \n");
//
//        roos.calculateBMRharrisBenedictRevised();
//        System.out.println("harrisBenedictRevised = " + roos.getProductionOfHeatAtCompleteRest() + " cal");
//        System.out.println("Rounded integer = " + Math.round(roos.getProductionOfHeatAtCompleteRest()) + " cal \n");
//
//        roos.calculateBMRmifflinStJeor();
//        System.out.println("mifflinStJeor = " + roos.getProductionOfHeatAtCompleteRest() + " cal");
//        System.out.println("Rounded integer = " + Math.round(roos.getProductionOfHeatAtCompleteRest()) + " cal \n");
//
//        roos.calculateBMRkatchMcArdle();
//        System.out.println("katchMcArdle = " + roos.getProductionOfHeatAtCompleteRest() + " cal");
//        System.out.println("Rounded integer = " + Math.round(roos.getProductionOfHeatAtCompleteRest()) + " cal \n");

//        BodyConscious test = new BodyConscious();
//        System.out.println(BodyConscious.calculateCaloriesPerDay(-500, 100, niels, 1.4));

        Body niels = new Body(83, 185, 18, "male", 17);
        niels.setCaloriesBurnedAtCompleteRest(new HarrisBenedict());
        System.out.println(niels.getCaloriesBurnedAtCompleteRest());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
