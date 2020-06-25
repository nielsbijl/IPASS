package bodyConscious.gui;

import bodyConscious.algorithm.Body;
import bodyConscious.algorithm.Goal;
import bodyConscious.algorithm.Person;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class GUI {
    public void openPopup() throws IOException {
        //Opent die popup.fxml in een nieuwe window
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/popup.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
    public void exit(){
        //sluit het programma op een nette manier af
        Platform.exit();
        System.exit(0);
    }

    public ArrayList readSavedBodyPropertiesFromJSON() throws IOException, ParseException {
        //Deze functie leest de profile.json file en returnt het als arraylist
        //Deze functie staat in GUI abstract class omdat verschillende controllers hier gebruik van moeten maken

        ArrayList bodyData = new ArrayList();

        JSONParser parser = new JSONParser();
        JSONObject profile;

        profile = (JSONObject) parser.parse(new FileReader("src/bodyConscious/gui/profile.json"));
        String name = (String)profile.get("Name");
        String age = (String)profile.get("Age");
        Boolean male = (Boolean) profile.get("Male");
        Boolean female = (Boolean) profile.get("Female");
        String pal = (String)profile.get("Pal");
        String height = (String)profile.get("Height");
        String bodyfat = (String)profile.get("Bodyfat");
        String mass = (String)profile.get("Mass");
        String goal = (String)profile.get("Goal");
        Boolean goalLoseBodyfat = (Boolean) profile.get("GoalLoseBodyfat");
        Boolean goalGainBodyfat = (Boolean) profile.get("GoalGainBodyfat");

        bodyData.add(name);
        bodyData.add(age);
        bodyData.add(male);
        bodyData.add(female);
        bodyData.add(pal);
        bodyData.add(height);
        bodyData.add(bodyfat);
        bodyData.add(mass);
        bodyData.add(goal);
        bodyData.add(goalLoseBodyfat);
        bodyData.add(goalGainBodyfat);

        return bodyData;
    }

    //------------------------------------------------------------------------------//
    //-------------------------De body/goal/person Creators-------------------------//
    //------------------------------------------------------------------------------//

    public Body createBodyWithBodyFatFromArrayList(ArrayList arrayList) throws IOException, ParseException {
        //Deze functie maakt van de arraylist die de functie readSavedBodyPropertiesFromJSON() maakt
        //een Body object met de lichaamsvet percentage er bij
        //Deze functie staat in GUI abstract class omdat verschillende controllers hier gebruik van moeten maken

        ArrayList bodyProperties = arrayList;
        Body body = null;
        //bodyProperties = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String: height, String: bodyfat, String: mass, String: goal, Boolean: goalLoseBodyfat, Boolean: goalGainBodyfat)
        if ((boolean)bodyProperties.get(2)){ //if male
            body = new Body(Double.parseDouble((String) bodyProperties.get(7)), Double.parseDouble((String) bodyProperties.get(5)), Integer.parseInt((String) bodyProperties.get(1)), "male", Integer.parseInt((String) bodyProperties.get(6)));
        }
        else {
            body = new Body(Double.parseDouble((String) bodyProperties.get(7)), Double.parseDouble((String) bodyProperties.get(5)), Integer.parseInt((String) bodyProperties.get(1)), "female", Integer.parseInt((String) bodyProperties.get(6)));
        }

        return body;
    }
    public Body createBodyWithoutBodyFatFromArrayList(ArrayList arrayList) throws IOException, ParseException {
        //Deze functie maakt van de arraylist die de functie readSavedBodyPropertiesFromJSON() maakt
        //een Body object zonder de lichaamsvet percentage er bij
        //Deze functie staat in GUI abstract class omdat verschillende controllers hier gebruik van moeten maken

        ArrayList bodyProperties = arrayList;
        Body body = null;
        //bodyProperties = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String: height, String: bodyfat, String: mass, String: goal, Boolean: goalLoseBodyfat, Boolean: goalGainBodyfat)
        if ((boolean) bodyProperties.get(2)){ //if male
            body = new Body(Double.parseDouble((String) bodyProperties.get(7)), Double.parseDouble((String) bodyProperties.get(5)), Integer.parseInt((String) bodyProperties.get(1)), "male");
        }
        else {
            body = new Body(Double.parseDouble((String) bodyProperties.get(7)), Double.parseDouble((String) bodyProperties.get(5)), Integer.parseInt((String) bodyProperties.get(1)), "female");
        }
        return body;
    }
    public Body createBodyFromArrayList(ArrayList arrayList) throws IOException, ParseException {
        //Deze functie maakt van de arraylist die de functie readSavedBodyPropertiesFromJSON() maakt
        //een Body object en kijkt zelf of die gemaakt wordt met of zonder vetpercentage
        //Deze functie staat in GUI abstract class omdat verschillende controllers hier gebruik van moeten maken

        ArrayList bodyProperties = arrayList;
        //bodyProperties = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String: height, String: bodyfat, String: mass, String: goal, Boolean: goalLoseBodyfat, Boolean: goalGainBodyfat)
        Body body;
        if (Double.parseDouble((String) bodyProperties.get(6)) < 1){//(if bodyfat < 1) --> create body without body fat percentage
            body = createBodyWithoutBodyFatFromArrayList(arrayList);
        }
        else {
            body = createBodyWithBodyFatFromArrayList(arrayList);
        }
        return body;
    }
    public Goal createGoalFromArrayList(ArrayList arrayList){
        //Deze functie maakt van de arraylist die de functie readSavedBodyPropertiesFromJSON() maakt
        //een Gaol object
        //Deze functie staat in GUI abstract class omdat verschillende controllers hier gebruik van moeten maken

        ArrayList bodyProperties = arrayList;
        //bodyProperties = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String: height, String: bodyfat, String: mass, String: goal, Boolean: goalLoseBodyfat, Boolean: goalGainBodyfat)
        Goal goal = new Goal((boolean) bodyProperties.get(9), (boolean) bodyProperties.get(10), Double.parseDouble((String) bodyProperties.get(8)));
        return goal;
    }
    public Person createPersonFromArrayList(ArrayList arrayList) throws IOException, ParseException {
        //Deze functie maakt van de arraylist die de functie readSavedBodyPropertiesFromJSON() maakt
        //een Person object
        //Deze functie staat in GUI abstract class omdat verschillende controllers hier gebruik van moeten maken

        ArrayList bodyProperties = arrayList;
        //bodyProperties = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String: height, String: bodyfat, String: mass, String: goal, Boolean: goalLoseBodyfat, Boolean: goalGainBodyfat)
        Person person = new Person((String) bodyProperties.get(0), createBodyFromArrayList(arrayList), createGoalFromArrayList(arrayList), Double.parseDouble((String) bodyProperties.get(4)));
        return person;
    }

}
