package bodyConscious.algorithm.BMR;

import bodyConscious.algorithm.Body;

public class MifflinStJeor implements BMR{
    @Override
    public double BMREquation(Body body) {
        double productionOfHeatAtCompleteRest;
        int s = -161;
        if (body.getGender().intern() == "male"){
            s = 5;
        }
        productionOfHeatAtCompleteRest = (10.0 * body.getMass()) / 1 + (6.25 * body.getHeight()) / 1 - (5.0 * body.getAge()) / 1 + s;
        return productionOfHeatAtCompleteRest;
    }
}
