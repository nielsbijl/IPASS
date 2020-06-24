package bodyConscious.algorithm;

import java.util.ArrayList;

public class CalorieCalculations {
    public static ArrayList<Number> calculateCaloriesPerDayPlan(int calorieDefecitOrSurplus, int days, Person person){
        //Creates a daily plan how many calories the person needs to eat
        ArrayList<Number> dailyCaloriesPlan = new ArrayList<>();
        Person newPerson = person;
        for (int i = 0; i < days; i++) {
            //calculate todays calories
            double BMR = newPerson.getBody().getCaloriesBurnedAtCompleteRest();
            int TDEE = newPerson.calculateTDEE();
            int caloriesToday = TDEE + calorieDefecitOrSurplus;
            dailyCaloriesPlan.add(caloriesToday);

            //set new body properties
            double lostOrGainedMass = (Calorie.humanFatMass * calorieDefecitOrSurplus) / 1000; //kg
            double newBodyMass = newPerson.getBody().getMass() + lostOrGainedMass;
            newPerson.getBody().setMass(newBodyMass);
        }
        return dailyCaloriesPlan;
    }
    public static ArrayList calculateCaloriesPerWeekPlan(ArrayList<Number> caloriesPerDayPlan){
        ArrayList<Number> weeklyCaloriesPlan = new ArrayList<>();
        int dayscounter = 0;
        int totalCaloriesWeek = 0;
        for (Number dailyCalorie : caloriesPerDayPlan){
            if (dayscounter == 7){
                weeklyCaloriesPlan.add(totalCaloriesWeek / 7);
                totalCaloriesWeek = 0;
                dayscounter = 0;
            }
            totalCaloriesWeek += (int) dailyCalorie;
            dayscounter ++;
        }
        return weeklyCaloriesPlan;
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
        int totalAmountOfCalories = (int) (goal.getAmountOfBodyFat() * 1000 * oneGram); //goal.getAmountOfBodyFat() KG -> Gram
        return totalAmountOfCalories / Math.abs(calorieDefecitOrSurplusDaily);
    }
    public static int calorieDeficitOrSurplusDaily(int amountOfCalories, Person person){
        int calorieDeficitOrSurplusDaily = amountOfCalories;
        if (person.getGoal().isGainBodyFat()){
            calorieDeficitOrSurplusDaily = amountOfCalories;
        }
        else if (person.getGoal().isLoseBodyFat()){
            calorieDeficitOrSurplusDaily = -amountOfCalories;
        }
        return calorieDeficitOrSurplusDaily;
    }
    public static ArrayList amountOfFatPerWeek(int calorieDeficitOrSurplusDaily, int amountOfWeeks){
        ArrayList<Number> amountOfFatLossPerWeek = new ArrayList<>();
        int calorieDeficitOrSurplusWeekly = calorieDeficitOrSurplusDaily * 7;
        double amountOfFatPerWeek = (calorieDeficitOrSurplusWeekly * Calorie.humanFatMass) / 1000; //kg
        double totalFat = 0;
        for (int i = 0; i < amountOfWeeks; i++) {
            totalFat = totalFat + amountOfFatPerWeek;
            amountOfFatLossPerWeek.add(totalFat);
        }
        return amountOfFatLossPerWeek;
    }
}
