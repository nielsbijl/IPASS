package bodyConscious.gui.controller;

import bodyConscious.algorithm.Body;
import bodyConscious.algorithm.CalorieCalculations;
import bodyConscious.algorithm.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerCharts implements Initializable {
    @FXML
    private LineChart<?, ?> calorieChart;

    @FXML
    private LineChart<?, ?> fatChart;

    public void fillCalorieChart() throws IOException, ParseException {
        ArrayList bodyProperties = ControllerBodyProperties.readSavedBodyPropertiesFromJSON();
        Body body = ControllerBodyProperties.createBodyWithBodyFatFromArrayList(bodyProperties);
        Person person = ControllerBodyProperties.createPersonFromArrayList(bodyProperties);
        int calorieDefecitOrSurplusDaily = 0;
        if (person.getGoal().isGainBodyFat()){
            calorieDefecitOrSurplusDaily = 500;
        }
        else if (person.getGoal().isLoseBodyFat()){
            calorieDefecitOrSurplusDaily = -500;
        }

        int amountOfDays = CalorieCalculations.amountOfDaysToAchieveGoal(calorieDefecitOrSurplusDaily, person); //ERROR
//        int amountOfDays = 60;
        ArrayList caloriesDailyPlan = CalorieCalculations.calculateCaloriesPerDayPlan(calorieDefecitOrSurplusDaily, amountOfDays, person);
        ArrayList calories = CalorieCalculations.calculateCaloriesPerWeekPlan(caloriesDailyPlan);

        System.out.println(calories);
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < calories.size(); i++) {
            series.getData().add(new XYChart.Data<>("week " + i, calories.get(i)));
        }
        series.setName("Calories you need to eat");

        calorieChart.getData().add(series);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            fillCalorieChart();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
