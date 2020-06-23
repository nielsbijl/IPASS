package bodyConscious.algorithm;

import java.util.ArrayList;

public class CalorieCalculations {
    public static ArrayList calculateCaloriesPerDayPlan(int calorieDefecitOrSurplus, int days, Person person){
        //Creates a daily plan how many calories the person needs to eat
        ArrayList<Integer> dailyCaloriesPlan = new ArrayList<>();
        Person newPerson = person;
        for (int i = 0; i < days; i++) {
            //calculate todays calories
            double BMR = newPerson.getBody().getCaloriesBurnedAtCompleteRest();
            int TDEE = newPerson.calculateTDEE(BMR, newPerson.getPhysicalActivityLevel());
            int caloriesToday = TDEE + calorieDefecitOrSurplus;
            dailyCaloriesPlan.add(caloriesToday);

            //set new body properties
            double lostOrGainedMass = (Calorie.humanFatMass * calorieDefecitOrSurplus) / 1000; //kg
            double newBodyMass = newPerson.getBody().getMass() + lostOrGainedMass;
            newPerson.getBody().setMass(newBodyMass);
        }
        return dailyCaloriesPlan;
    }
    public static int calculateFatLosingOrGaining(int days, int caloriesNeededPerDay, int caloriesEatenPerDay){
        //if caloriesCurrentlyGainingOrLosing < 0 ---> losing weight
        //if caloriesCurrentlyGainingOrLosing > 0 ---> gaining weight
        double caloriesCurrentlyGainingOrLosing = caloriesNeededPerDay - caloriesEatenPerDay;
        return (int) Math.round(caloriesCurrentlyGainingOrLosing * Calorie.humanFatMass); //return the amount of human fat tissue lost or gained in grams
    }
    public static int amountOfDaysToAchieveGoal(int calorieDefecitOrSurplusDaily, Person person){
        Goal goal = person.getGoal();
        double oneGram = 1 / Calorie.humanFatMass; //1gram humanFat = amount of calories....
        int totalAmountOfCalories = (int) (goal.getAmountOfBodyFat() * oneGram);
        return totalAmountOfCalories / calorieDefecitOrSurplusDaily;
    }
}
