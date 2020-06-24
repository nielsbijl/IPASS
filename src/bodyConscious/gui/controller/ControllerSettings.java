package bodyConscious.gui.controller;

import bodyConscious.algorithm.BMR.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
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

public class ControllerSettings implements Initializable {
    @FXML
    private ToggleGroup BMRequation;

    @FXML
    private RadioButton radioButtonHarrisBenedict;
    @FXML
    private RadioButton radioButtonHarrisBenedictRevised;
    @FXML
    private RadioButton radioButtonKatchMcArdle;
    @FXML
    private RadioButton radioButtonMifflinStJeor;

    public void saveSettings(MouseEvent mouseEvent) throws IOException {
        writeSettings();
    }

    public void writeSettings() throws IOException {
        JSONObject profile = new JSONObject();
        profile.put("HarrisBenedict", radioButtonHarrisBenedict.isSelected());
        profile.put("HarrisBenedictRevised", radioButtonHarrisBenedictRevised.isSelected());
        profile.put("KatchMcArdle", radioButtonKatchMcArdle.isSelected());
        profile.put("MifflinStJeor", radioButtonMifflinStJeor.isSelected());

        FileWriter file = new FileWriter("src/bodyConscious/gui/settings.json");
        file.write(profile.toJSONString());
        file.close();

        System.out.println("JSON file created: "+profile);
    }

    public static ArrayList<Boolean> readSavedSettingsFromJSON() throws IOException, ParseException {
        ArrayList<Boolean> savedSettings = new ArrayList();

        JSONParser parser = new JSONParser();
        JSONObject profile = (JSONObject) parser.parse(new FileReader("src/bodyConscious/gui/settings.json"));
        Boolean harrisBenedict = (Boolean) profile.get("HarrisBenedict");
        Boolean harrisBenedictRevised = (Boolean) profile.get("HarrisBenedictRevised");
        Boolean katchMcArdle = (Boolean) profile.get("KatchMcArdle");
        Boolean mifflinStJeor = (Boolean) profile.get("MifflinStJeor");

        savedSettings.add(harrisBenedict);
        savedSettings.add(harrisBenedictRevised);
        savedSettings.add(katchMcArdle);
        savedSettings.add(mifflinStJeor);
        System.out.println(savedSettings);

        return savedSettings;
    }
    public static BMR getBMREquation() throws IOException, ParseException {
        ArrayList<Boolean> savedSettings = readSavedSettingsFromJSON();
        if (savedSettings.get(0)){
            return new HarrisBenedict();
        }
        else if (savedSettings.get(1)){
            return new HarrisBenedictRevised();
        }
        else if (savedSettings.get(2)){
            return new KatchMcArdle();
        }
        else if (savedSettings.get(3)){
            return new MifflinStJeor();
        }
        return new HarrisBenedictRevised(); //default
    }

    private void setSettings(Boolean harrisBenedict, Boolean harrisBenedictRevised, Boolean katchMcArdle, Boolean mifflinStJeor){
        if (harrisBenedict){
            this.BMRequation.selectToggle(radioButtonHarrisBenedict);
        }
        else if (harrisBenedictRevised){
            this.BMRequation.selectToggle(radioButtonHarrisBenedictRevised);
        }
        else if (katchMcArdle){
            this.BMRequation.selectToggle(radioButtonKatchMcArdle);
        }
        else if (mifflinStJeor){
            this.BMRequation.selectToggle(radioButtonMifflinStJeor);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BMRequation.selectToggle(radioButtonKatchMcArdle);
        try {
            //hardcoded to keep it clear
            boolean harrisBenedict = readSavedSettingsFromJSON().get(0);
            boolean harrisBenedictRevised = readSavedSettingsFromJSON().get(1);
            boolean katchMcArdle = readSavedSettingsFromJSON().get(2);
            boolean mifflinStJeor = readSavedSettingsFromJSON().get(3);
            setSettings(harrisBenedict, harrisBenedictRevised, katchMcArdle, mifflinStJeor);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
