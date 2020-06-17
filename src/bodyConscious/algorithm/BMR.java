package bodyConscious.algorithm;

public class BMR {

    public static double harrisBenedict (Body body){
        double productionOfHeatAtCompleteRest;
        if (body.gender == "male"){
            productionOfHeatAtCompleteRest = (13.7516 * body.getMass()) / 1 + (5.0033 * body.getHeight()) / 1 - (6.7550 * body.getAge()) / 1 + 66.4730;
        }
        else {
            productionOfHeatAtCompleteRest = (9.5634 * body.getMass()) / 1 + (1.8496 * body.getHeight()) / 1 - (4.6756 * body.getAge()) / 1 + 655.0955;
        }
        return productionOfHeatAtCompleteRest;
    }

    public static double harrisBenedictRevised(Body body){
        double productionOfHeatAtCompleteRest;
        if (body.gender == "male"){
            productionOfHeatAtCompleteRest = (13.397 * body.getMass()) / 1 + (4.799 * body.getHeight()) / 1 - (5.677 * body.getAge()) / 1 + 88.362;
        }
        else {
            productionOfHeatAtCompleteRest = (9.247 * body.getMass()) / 1 + (3.098 * body.getHeight()) / 1 - (4.330 * body.getAge()) / 1 + 447.593;
        }
        return productionOfHeatAtCompleteRest;
    }
    public static double mifflinStJeor(Body body){
        double productionOfHeatAtCompleteRest;
        int s = -161;
        if (body.gender == "male"){
            s = 5;
        }
        productionOfHeatAtCompleteRest = (10.0 * body.getMass()) / 1 + (6.25 * body.getHeight()) / 1 - (5.0 * body.getAge()) / 1 + s;
        return productionOfHeatAtCompleteRest;
    }
    public static double katchMcArdle(Body body){
        double productionOfHeatAtCompleteRest;
        double leanBodyMass = body.getMass() * (1- body.getBodyFatPercentage()/100);
        productionOfHeatAtCompleteRest = 370 + 21.6 * leanBodyMass;
        return productionOfHeatAtCompleteRest;
    }
}
