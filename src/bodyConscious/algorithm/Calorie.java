package bodyConscious.algorithm;

public class Calorie {
    final static double humanFatMass = 0.12959782; //1 calorie = 0.12959782 gram human fat tissue

    public static int calculateFatLosingOrGaining(int days, int caloriesNeededPerDay, int caloriesEatenPerDay){
        //if caloriesCurrentlyGainingOrLosing < 0 ---> losing weight
        //if caloriesCurrentlyGainingOrLosing > 0 ---> gaining weight
        double caloriesCurrentlyGainingOrLosing = caloriesNeededPerDay - caloriesEatenPerDay;
        return (int) Math.round(caloriesCurrentlyGainingOrLosing * humanFatMass); //return the amount of human fat tissue lost or gained in grams
    }
}
