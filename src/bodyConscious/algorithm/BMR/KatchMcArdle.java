package bodyConscious.algorithm.BMR;

import bodyConscious.algorithm.Body;

public class KatchMcArdle implements BMR{
    @Override
    public double BMREquation(Body body) {
        double productionOfHeatAtCompleteRest;
        double leanBodyMass = body.getMass() * (1- body.getBodyFatPercentage()/100);
        productionOfHeatAtCompleteRest = 370 + 21.6 * leanBodyMass;
        return productionOfHeatAtCompleteRest;
    }
}
