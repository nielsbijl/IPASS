package bodyConscious.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerCharts implements Initializable {
    @FXML
    private LineChart<?, ?> calorieChart;

    @FXML
    private LineChart<?, ?> fatChart;

    public void fillCalorieChart(){
        ArrayList<Number> calories = new ArrayList<>();
        calories.add(2000);
        calories.add(2200);
        calories.add(2400);
        calories.add(2600);
        calories.add(2800);

        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < calories.size(); i++) {
            series.getData().add(new XYChart.Data<>("week " + i, calories.get(i)));
        }

        calorieChart.getData().add(series);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillCalorieChart();

    }
}
