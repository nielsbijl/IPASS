package bodyConscious.gui.controller;

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

public class ControllerBodyProperties implements Initializable {

    @FXML
    private RadioButton radioButtonMale;

    @FXML
    private RadioButton radioButtonFemale;

    @FXML
    private TextField bodyfatInput;

    @FXML
    private TextField weightInput;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private TextField heightInput;

    @FXML
    private TextField palInput;

    @FXML
    private TextField nameInput;

    public void saveBodyProperties(MouseEvent mouseEvent) throws IOException {
        System.out.println("Save");
        writeSavedBodyPropertiesToJSON();

    }
    public void writeSavedBodyPropertiesToJSON() throws IOException {
        JSONObject profile = new JSONObject();
        profile.put("Name", nameInput.getText());
        profile.put("Mass", weightInput.getText());
        profile.put("Height", heightInput.getText());
        profile.put("Age", "18");
        profile.put("Male", radioButtonMale.isSelected());
        profile.put("Female", radioButtonFemale.isSelected());
        profile.put("Pal", palInput.getText());
        profile.put("Bodyfat", bodyfatInput.getText());

        FileWriter file = new FileWriter("src/bodyConscious/gui/profile.json");
        file.write(profile.toJSONString());
        file.close();

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


        bodyData.add(name);
        bodyData.add(age);
        bodyData.add(male);
        bodyData.add(female);
        bodyData.add(pal);
        bodyData.add(height);
        bodyData.add(bodyfat);
        bodyData.add(mass);

        return bodyData;
    }
    private void setInputFields(String name, String pal, String height, String mass, String bodyfatpercentage, Boolean male, Boolean female){
        JSONObject profile = new JSONObject();
        this.nameInput.setText(name);
        this.palInput.setText(pal);
        this.heightInput.setText(height);
        this.weightInput.setText(mass);
        this.bodyfatInput.setText(bodyfatpercentage);

        if (male){
            this.Gender.selectToggle(radioButtonMale);
        }
        if (female){
            this.Gender.selectToggle(radioButtonFemale);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //This is the startup when the bodyProperties.fxml is opened
        //The set the saved body properties to the input fields by
        //fetching the saved profile in the profile.json
        try {
            //bodyData = (String: name, String: age, Boolean: male, Boolean: female, String: pal, String height, String bodyfat, String mass)
            ArrayList bodyData = readSavedBodyPropertiesFromJSON();

            setInputFields((String) bodyData.get(0), (String) bodyData.get(4), (String) bodyData.get(5), (String) bodyData.get(7), (String) bodyData.get(6),
                    (Boolean) bodyData.get(2), (Boolean) bodyData.get(3));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
