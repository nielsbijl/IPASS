package bodyConscious.gui.controller;

//Dit is de controller class van de bodyproperties.fxml
//Als bodyproperties.fxml geladen wordt, dan wordt deze class met zijn functies aan geroepen
//Deze class regelt alles wat er in de fxml file gebeurt

import bodyConscious.gui.GUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerBodyProperties extends GUI implements Initializable {
    //Dit zijn alle input velden voor de bodyproperties
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
        //Deze functie wordt aangeroepen als je op de save button clickt
        //Hij schrijft dan alle input velden weg naar een JSON file om ze op te kunnen slaan

        writeSavedBodyPropertiesToJSON();
    }

    public void writeSavedBodyPropertiesToJSON() throws IOException {
        //Deze functie leest de input velden en schrijft ze weg naar de profile.json file

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

    private void setInputFields(String name, String age, String pal, String height, String mass, String bodyfatpercentage, Boolean male, Boolean female, String goal, Boolean goalLoseBodyfat, Boolean goalGainBodyfat){
        //Deze functie krijgt als input alle bodyproperties mee
        //Dan kun je als de bodyproperties.fxml geopend wordt de opgeslagen properties in de input velden zetten

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




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Deze functie wordt als eerst aangeroepen wanneer de bodyproperties.fxml wordt geopend
        //Hij leest als eerste de profile.json uit een slaat het op als arraylist
        //Dan zet hij de input velden naar de opgeslagen properties
        //Als dit fout gaat komt er een popup

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
