package bodyConscious.algorithm;

import bodyConscious.algorithm.BMR.HarrisBenedictRevised;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CalorieCalculationsTest {

    @Test
    public void calculateCaloriesPerDayPlan() throws IOException, ParseException {
        ArrayList<Number> dailyCaloriesPlanExpected = new ArrayList<>();
        dailyCaloriesPlanExpected.add(2472);
        dailyCaloriesPlanExpected.add(2473);
        dailyCaloriesPlanExpected.add(2474);
        dailyCaloriesPlanExpected.add(2475);
        dailyCaloriesPlanExpected.add(2476);

        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        Assert.assertEquals(dailyCaloriesPlanExpected, CalorieCalculations.calculateCaloriesPerDayPlan(500, 5, testPerson));
    }

    @Test
    public void calculateCaloriesPerWeekPlan() throws IOException, ParseException {
        ArrayList<Number> dailyCaloriesWeekExpected = new ArrayList<>();
        dailyCaloriesWeekExpected.add(2474);
        dailyCaloriesWeekExpected.add(2480);

        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);
        ArrayList caloriesPerDayPlan = CalorieCalculations.calculateCaloriesPerDayPlan(500, 15, testPerson);
        ArrayList caloriesPerWeekPlan = CalorieCalculations.calculateCaloriesPerWeekPlan(caloriesPerDayPlan);

        Assert.assertEquals(dailyCaloriesWeekExpected, caloriesPerWeekPlan);
    }

    @Test
    public void calculateFatLosingOrGaining() {
        int fatLosingOrGaining = CalorieCalculations.calculateFatLosingOrGaining(10, 2000, 1500);
        Assert.assertEquals(65, fatLosingOrGaining);
    }

    @Test
    public void amountOfDaysToAchieveGoal() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        int days = CalorieCalculations.amountOfDaysToAchieveGoal(-500, testPerson);

        Assert.assertEquals(77, days);
    }

    @Test
    public void calorieDeficitOrSurplusDaily() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);
        int calories = CalorieCalculations.calorieDeficitOrSurplusDaily(500, testPerson);

        Assert.assertEquals(-500, calories);

        goal.setLoseBodyFat(false);
        goal.setGainBodyFat(true);

        calories = CalorieCalculations.calorieDeficitOrSurplusDaily(500, testPerson);

        Assert.assertEquals(500, calories);

    }

    @Test
    public void amountOfFatPerWeek() {
        ArrayList<Number> amountOfFatLossPerWeekExpected = new ArrayList<>();
        amountOfFatLossPerWeekExpected.add(0.45359237);
        amountOfFatLossPerWeekExpected.add(0.90718474);
        amountOfFatLossPerWeekExpected.add(1.3607771100000001);

        Assert.assertEquals(amountOfFatLossPerWeekExpected, CalorieCalculations.amountOfFatPerWeek(500, 3));

    }
}