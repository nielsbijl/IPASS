package bodyConscious.algorithm;

import bodyConscious.algorithm.BMR.BMR;
import bodyConscious.gui.controller.ControllerSettings;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Body {
    private BMR caloriesBurnedAtCompleteRest;
    private double mass;
    private double height;
    private int age;
    private String gender;
    private int bodyFatPercentage;

    //constructor
    public Body(double massKG, double heightCM, int ageYEARS, String gender) throws IOException, ParseException {
        this.mass = massKG;
        this.height = heightCM;
        this.age = ageYEARS;
        this.gender = gender;
        this.caloriesBurnedAtCompleteRest = ControllerSettings.getBMREquation(); //HarrisBenedictRevised default
    }
    public Body(double massKG, double heightCM, int ageYEARS, String gender, int bodyFatPercentage) throws IOException, ParseException {
        this.mass = massKG;
        this.height = heightCM;
        this.age = ageYEARS;
        this.gender = gender;
        this.bodyFatPercentage = bodyFatPercentage;
        this.caloriesBurnedAtCompleteRest = ControllerSettings.getBMREquation(); //HarrisBenedictRevised default
    }

    //setters
    public void setCaloriesBurnedAtCompleteRest(BMR equation){ this.caloriesBurnedAtCompleteRest = equation; }
    public void setMass(double massKG){
        this.mass = massKG;
    }
    public void setHeight(double heightCM){
        this.height = heightCM;
    }
    public void setAge(int ageYEARS){
        this.age = ageYEARS;
    }
    public void setBodyFatPercentage(int bodyFatPercentage){
        this.bodyFatPercentage = bodyFatPercentage;
    }

    //getters
    public double getCaloriesBurnedAtCompleteRest(){
        return this.caloriesBurnedAtCompleteRest.BMREquation(this);
    }
    public BMR getCaloriesBurnedAtCompleteRestEquation(){return this.caloriesBurnedAtCompleteRest;}
    public double getMass(){
        return this.mass;
    }
    public double getHeight(){
        return this.height;
    }
    public int getAge(){
        return this.age;
    }
    public String getGender(){
        return this.gender;
    }
    public int getBodyFatPercentage(){
        return this.bodyFatPercentage;
    }

}
