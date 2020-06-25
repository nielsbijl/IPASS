package bodyConscious.gui.controller;

//Dit is de controller class van de charts.fxml
//Als charts.fxml geladen wordt, dan wordt deze class met zijn functies aan geroepen
//Deze class regelt alles wat er in de fxml file gebeurt

import bodyConscious.algorithm.CalorieCalculations;
import bodyConscious.algorithm.Person;
import bodyConscious.gui.GUI;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerCharts extends GUI implements Initializable {
    //De person object waarmee gerekend wordt
    private Person person;

    //Het aantal weken total iemand zijn doel behaald heeft
    private int weeks;

    @FXML
    private LineChart<?, ?> calorieChart;

    @FXML
    private LineChart<?, ?> fatChart;

    public ArrayList createCaloriePlan() {
        //Deze functie maakt een plan waarbij te zien is hoeveel calorieën dagelijks per week gegeten moet worden om zijn of haar doel te halen
        int calorieDeficitOrSurplusDaily = CalorieCalculations.calorieDeficitOrSurplusDaily(500, this.person);
        int amountOfDays = CalorieCalculations.amountOfDaysToAchieveGoal(calorieDeficitOrSurplusDaily, this.person);
        ArrayList caloriesDailyPlan = CalorieCalculations.calculateCaloriesPerDayPlan(calorieDeficitOrSurplusDaily, amountOfDays, this.person);
        ArrayList calories = CalorieCalculations.calculateCaloriesPerWeekPlan(caloriesDailyPlan);
        return calories;
    }
    public ArrayList createCalorieBMRPlan() {
        //Deze functie laat het Basal Metabolic Rate van de persoon zijn
        //Als de persoon op het BMR blijft eten zal er geen veranderingen komen in de persoon zijn vet percentage
        double bmr = this.person.calculateTDEE();
        ArrayList bmrPlan = new ArrayList();
        for (int i = 0; i < this.weeks; i++) {
            bmrPlan.add(bmr);
        }
        return bmrPlan;
    }

    public void fillCalorieChart(){
        //Deze functie vult de grafiek van de calorie berekeningen
        //Het calorie plan om het doel te halen wordt er in gezet
        //En het Basal Metalbolic Rate wordt er ook in gezet

        ArrayList caloriesToAchieveGoal = createCaloriePlan();
        ArrayList caloriesToChangeNothings = createCalorieBMRPlan();
        XYChart.Series seriesCaloriesToAchieveGoal = new XYChart.Series();
        XYChart.Series seriesCaloriesToChangeNothing= new XYChart.Series();
        for (int i = 0; i < caloriesToAchieveGoal.size(); i++) {
            seriesCaloriesToAchieveGoal.getData().add(new XYChart.Data<>("week " + i, caloriesToAchieveGoal.get(i)));
            seriesCaloriesToChangeNothing.getData().add(new XYChart.Data<>("week " + i, caloriesToChangeNothings.get(i)));
        }
        seriesCaloriesToAchieveGoal.setName("Calories you need to eat to achieve your goal");
        seriesCaloriesToChangeNothing.setName("Calories you need to eat to stay the same");

        this.calorieChart.getData().add(seriesCaloriesToAchieveGoal);
        this.calorieChart.getData().add(seriesCaloriesToChangeNothing);
    }
    public void fillFatChart(){
        //Deze functie vult de Fat grafiek
        //Je kan hier zijn hoeveel vet je in totaal bent verloren of bent aangekomen
        //Er wordt in de hele applicatie gewerkt met een 500 calorie tekort of overschot omdat dit door wetenschappers optimaal wordt gezien

        int calorieDeficitOrSurplusDaily = CalorieCalculations.calorieDeficitOrSurplusDaily(500, this.person);
        ArrayList fatWeekly = CalorieCalculations.amountOfFatPerWeek(calorieDeficitOrSurplusDaily, 10);
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < fatWeekly.size(); i++) {
            series.getData().add(new XYChart.Data<>("week " + i, fatWeekly.get(i)));
        }
        series.setName("Amount of kg fat");

        this.fatChart.getData().add(series);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Deze functie wordt aangeroepen bij het openen van de charts.fxml
        //Hij haalt eerst de body properties op en maakt daar een person object van
        //Dan berekent die hoeveel weken je bezig gaat zijn om op een gezonde manier je doel te behalen
        //Dan vult hij de grafieken in
        //Als hier dingen mis gaan komt de popup te voor schijn
        try {
            ArrayList bodyProperties = readSavedBodyPropertiesFromJSON();
            this.person = createPersonFromArrayList(bodyProperties);
            this.weeks = CalorieCalculations.amountOfDaysToAchieveGoal(CalorieCalculations.calorieDeficitOrSurplusDaily(500, this.person), this.person) / 7;
            fillCalorieChart();
            fillFatChart();
        } catch (IOException | ParseException e) {
            try {
                openPopup();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
