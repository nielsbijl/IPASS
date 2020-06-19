package bodyConscious.algorithm;

import java.util.ArrayList;

public class CalorieCalculations {
    public static ArrayList calculateCaloriesPerDay(int calorieDefecitOrSurplus, int days, Person person){
        ArrayList<Integer> dailyCalories = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            //calculate todays calories
            double BMR = person.getBody().getCaloriesBurnedAtCompleteRest();
            int TDEE = person.calculateTDEE(BMR, person.getPhysicalActivityLevel());
            int caloriesToday = TDEE + calorieDefecitOrSurplus;
            dailyCalories.add(caloriesToday);

            //set new body properties
            double lostOrGainedMass = (Calorie.humanFatMass * calorieDefecitOrSurplus) / 1000; //kg
            double newBodyMass = person.getBody().getMass() + lostOrGainedMass;
            person.getBody().setMass(newBodyMass);
        }
        return dailyCalories;
    }
}
