package bodyConscious.gui.controller;

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

    public static ArrayList readSavedSettingsFromJSON() throws IOException, ParseException {
        ArrayList bodyData = new ArrayList();

        JSONParser parser = new JSONParser();
        JSONObject profile = (JSONObject) parser.parse(new FileReader("src/bodyConscious/gui/settings.json"));
        Boolean harrisBenedict = (Boolean) profile.get("HarrisBenedict");
        Boolean harrisBenedictRevised = (Boolean) profile.get("HarrisBenedictRevised");
        Boolean katchMcArdle = (Boolean) profile.get("KatchMcArdle");
        Boolean mifflinStJeor = (Boolean) profile.get("MifflinStJeor");

        bodyData.add(harrisBenedict);
        bodyData.add(harrisBenedictRevised);
        bodyData.add(katchMcArdle);
        bodyData.add(mifflinStJeor);
        System.out.println(bodyData);

        return bodyData;
    }

    private void setInputFields(Boolean harrisBenedict, Boolean harrisBenedictRevised, Boolean katchMcArdle, Boolean mifflinStJeor){
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
            //hard coded to keep it clear
            boolean harrisBenedict = (boolean) readSavedSettingsFromJSON().get(0);
            boolean harrisBenedictRevised = (boolean) readSavedSettingsFromJSON().get(1);
            boolean katchMcArdle = (boolean) readSavedSettingsFromJSON().get(2);
            boolean mifflinStJeor = (boolean) readSavedSettingsFromJSON().get(3);
            setInputFields(harrisBenedict, harrisBenedictRevised, katchMcArdle, mifflinStJeor);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void saveSettings(MouseEvent mouseEvent) throws IOException {
        writeSettings();
    }
}
