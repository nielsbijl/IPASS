package bodyConscious.gui.controller;

import bodyConscious.algorithm.Body;
import bodyConscious.algorithm.Goal;
import bodyConscious.algorithm.Person;
import bodyConscious.gui.GUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerBodyProperties extends GUI implements Initializable {
    @FXML
    private RadioButton radioButtonGainBodyfat;
    @FXML
    private RadioButton radioButtonLoseBodyfat;
    @FXML
    private RadioButton radioButtonMale;
    @FXML
    private RadioButton radioButtonFemale;

    @FXML
    private ToggleGroup Gender;
    @FXML
    private ToggleGroup Goal;

    @FXML
    private TextField bodyfatInput;
    @FXML
    private TextField weightInput;
    @FXML
    private TextField heightInput;
    @FXML
    private TextField palInput;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField goalInput;
    @FXML
    private TextField ageInput;

    public void saveBodyProperties(MouseEvent mouseEvent) throws IOException {
        System.out.println("Save");
        writeSavedBodyPropertiesToJSON();
    }

    public void writeSavedBodyPropertiesToJSON() throws IOException {
        JSONObject profile = new JSONObject();
        profile.put("Name", nameInput.getText());
        profile.put("Mass", weightInput.getText());
        profile.put("Height", heightInput.getText());
        profile.put("Age", ageInput.getText());
        profile.put("Male", radioButtonMale.isSelected());
        profile.put("Female", radioButtonFemale.isSelected());
        profile.put("Pal", palInput.getText());
        profile.put("Bodyfat", bodyfatInput.getText());
        profile.put("Goal", goalInput.getText());
        profile.put("GoalLoseBodyfat", radioButtonLoseBodyfat.isSelected());
        profile.put("GoalGainBodyfat", radioButtonGainBodyfat.isSelected());

        FileWriter file = null;
        try {
            file = new FileWriter("src/bodyConscious/gui/profile.json");
            file.write(profile.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            openPopup();
        }

        System.out.println("JSON file created: "+profile);
    }
    public static ArrayList readSavedBodyPropertiesFromJSON() throws IOException, ParseException {
        ArrayList bodyData = new ArrayList();

        JSONParser parser = new JSONParser();
        JSONObject profile = (JSONObject) parser.parse(new FileReader("src/bodyConscious/gui/profile.json"));
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
    private void setInputFields(String name, String age, String pal, String height, String mass, String bodyfatpercentage, Boolean male, Boolean female, String goal, Boolean goalLoseBodyfat, Boolean goalGainBodyfat){
        this.nameInput.setText(name);
        this.ageInput.setText(age);
        this.palInput.setText(pal);
        this.heightInput.setText(height);
        this.weightInput.setText(mass);
        this.bodyfatInput.setText(bodyfatpercentage);
        this.goalInput.setText(goal);

        if (male){
            this.Gender.selectToggle(radioButtonMale);
        }
        else if (female){
            this.Gender.selectToggle(radioButtonFemale);
        }
        if (goalLoseBodyfat){
            this.Goal.selectToggle(radioButtonLoseBodyfat);
        }
        else if (goalGainBodyfat){
            this.Goal.selectToggle(radioButtonGainBodyfat);
        }
    }
    public static Body createBodyWithBodyFatFromArrayList(ArrayList arrayList) throws IOException, ParseException {
        ArrayList bodyProperties = arrayList;
        Body body;
        //bodyProperties = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String: height, String: bodyfat, String: mass, String: goal, Boolean: goalLoseBodyfat, Boolean: goalGainBodyfat)
        if ((boolean)bodyProperties.get(2)){ //if male
            body = new Body(Double.parseDouble((String) bodyProperties.get(7)), Double.parseDouble((String) bodyProperties.get(5)), Integer.parseInt((String) bodyProperties.get(1)), "male", Integer.parseInt((String) bodyProperties.get(6)));
        }
        else {
            body = new Body(Double.parseDouble((String) bodyProperties.get(7)), Double.parseDouble((String) bodyProperties.get(5)), Integer.parseInt((String) bodyProperties.get(1)), "female", Integer.parseInt((String) bodyProperties.get(6)));
        }
        return body;
    }
    public static Body createBodyWithoutBodyFatFromArrayList(ArrayList arrayList) throws IOException, ParseException {
        ArrayList bodyProperties = arrayList;
        Body body;
        //bodyProperties = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String: height, String: bodyfat, String: mass, String: goal, Boolean: goalLoseBodyfat, Boolean: goalGainBodyfat)
        if ((boolean) bodyProperties.get(2)){ //if male
            body = new Body(Double.parseDouble((String) bodyProperties.get(7)), Double.parseDouble((String) bodyProperties.get(5)), Integer.parseInt((String) bodyProperties.get(1)), "male");
        }
        else {
            body = new Body(Double.parseDouble((String) bodyProperties.get(7)), Double.parseDouble((String) bodyProperties.get(5)), Integer.parseInt((String) bodyProperties.get(1)), "female");
        }
        return body;
    }
    public static Body createBodyFromArrayList(ArrayList arrayList) throws IOException, ParseException {
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
    public static Goal createGoalFromArrayList(ArrayList arrayList){
        ArrayList bodyProperties = arrayList;
        //bodyProperties = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String: height, String: bodyfat, String: mass, String: goal, Boolean: goalLoseBodyfat, Boolean: goalGainBodyfat)
        Goal goal = new Goal((boolean) bodyProperties.get(9), (boolean) bodyProperties.get(10), Double.parseDouble((String) bodyProperties.get(8)));
        return goal;
    }
    public static Person createPersonFromArrayList(ArrayList arrayList) throws IOException, ParseException {
        ArrayList bodyProperties = arrayList;
        //bodyProperties = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String: height, String: bodyfat, String: mass, String: goal, Boolean: goalLoseBodyfat, Boolean: goalGainBodyfat)
        Person person = new Person((String) bodyProperties.get(0), createBodyFromArrayList(arrayList), createGoalFromArrayList(arrayList), Double.parseDouble((String) bodyProperties.get(4)));
        return person;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //This is the startup when the bodyproperties.fxml is opened
        //The set the saved body properties to the input fields by
        //fetching the saved profile in the profile.json
        try {
            //bodyData = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String: height, String: bodyfat, String: mass, String: goal, Boolean: goalLoseBodyfat, Boolean: goalGainBodyfat)
            ArrayList bodyData = readSavedBodyPropertiesFromJSON();

            setInputFields((String) bodyData.get(0), (String) bodyData.get(1), (String) bodyData.get(4), (String) bodyData.get(5), (String) bodyData.get(7), (String) bodyData.get(6),
                    (Boolean) bodyData.get(2), (Boolean) bodyData.get(3), (String) bodyData.get(8), (Boolean) bodyData.get(9), (Boolean) bodyData.get(10));
        } catch (IOException e) {
            try {
                openPopup();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        } catch (ParseException e) {
            try {
                openPopup();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
