package bodyConscious.gui.controller;

//Dit is de controller class van de settings.fxml
//Als settings.fxml geladen wordt, dan wordt deze class met zijn functies aan geroepen
//Deze class regelt alles wat er in de fxml file gebeurt

import bodyConscious.gui.GUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSettings extends GUI implements Initializable{
    //Dit zijn alle radio buttons om te kiezen welke Basal Metalbolic Rate equation je wilt gebruiken
    //De ToggleGroup is er voor zodat je maar 1 equation kunt gebruiken
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

    public void saveSettings(MouseEvent mouseEvent) throws IOException{
        //Deze functie wordt aan geroepen als je op de save button klikt
        //Hij schrijft je keuze weg naar de settings.json file
        writeSettings();
    }

    public void writeSettings() throws IOException {
        //Deze functie schrijft je gekozen Basal Metabolic Rate keuze weg naar de settings.json file
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

    private void setSettings(Boolean harrisBenedict, Boolean harrisBenedictRevised, Boolean katchMcArdle, Boolean mifflinStJeor){
        //Deze functie krijgt alle settings mee
        //Hij zet de opeslagen settings in de input velden zoals ze eerder opgeslagen waren
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
        //Deze functie wordt aangeroepen als de settings.fxml geladen wordt
        //Hij zet als eerste de HarrisBenedictRevised setting als gekozen omdat dit de default setting is
        //Dan kijkt die welke settings eerder opgeslagen waren en veranderd de settings hier naar
        BMRequation.selectToggle(radioButtonHarrisBenedictRevised);
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
