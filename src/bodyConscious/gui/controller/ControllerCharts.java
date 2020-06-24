package bodyConscious.gui.controller;

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
    private Person person;
    private int weeks;

    @FXML
    private LineChart<?, ?> calorieChart;

    @FXML
    private LineChart<?, ?> fatChart;

    public ArrayList createCaloriePlan() {
        int calorieDeficitOrSurplusDaily = CalorieCalculations.calorieDeficitOrSurplusDaily(500, this.person);
        int amountOfDays = CalorieCalculations.amountOfDaysToAchieveGoal(calorieDeficitOrSurplusDaily, this.person);
        ArrayList caloriesDailyPlan = CalorieCalculations.calculateCaloriesPerDayPlan(calorieDeficitOrSurplusDaily, amountOfDays, this.person);
        ArrayList calories = CalorieCalculations.calculateCaloriesPerWeekPlan(caloriesDailyPlan);
        return calories;
    }
    public ArrayList createCalorieBMRPlan() {
        double bmr = this.person.calculateTDEE();
        ArrayList bmrPlan = new ArrayList();
        for (int i = 0; i < this.weeks; i++) {
            bmrPlan.add(bmr);
        }
        return bmrPlan;
    }

    public void fillCalorieChart(){
        ArrayList caloriesToAchieveGoal = createCaloriePlan();
        ArrayList caloriesToChangeNothings = createCalorieBMRPlan();
        System.out.println(caloriesToChangeNothings);
        System.out.println(caloriesToAchieveGoal);
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
        int calorieDeficitOrSurplusDaily = CalorieCalculations.calorieDeficitOrSurplusDaily(500, this.person);
        ArrayList fatWeekly = CalorieCalculations.amountOfFatPerWeek(calorieDeficitOrSurplusDaily, 10);
        System.out.println(fatWeekly);
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < fatWeekly.size(); i++) {
            series.getData().add(new XYChart.Data<>("week " + i, fatWeekly.get(i)));
        }
        series.setName("Amount of kg fat");

        this.fatChart.getData().add(series);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ArrayList bodyProperties = ControllerBodyProperties.readSavedBodyPropertiesFromJSON();
            this.person = ControllerBodyProperties.createPersonFromArrayList(bodyProperties);
            this.weeks = CalorieCalculations.amountOfDaysToAchieveGoal(CalorieCalculations.calorieDeficitOrSurplusDaily(500, this.person), this.person) / 7;
            fillCalorieChart();
            fillFatChart();
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
