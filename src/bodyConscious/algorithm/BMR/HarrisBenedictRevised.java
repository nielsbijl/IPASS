package bodyConscious.algorithm.BMR;

import bodyConscious.algorithm.Body;

public class HarrisBenedictRevised implements BMR{
    @Override
    public double BMREquation(Body body) {
        double productionOfHeatAtCompleteRest;
        if (body.getGender().intern() == "male"){
            productionOfHeatAtCompleteRest = (13.397 * body.getMass()) / 1 + (4.799 * body.getHeight()) / 1 - (5.677 * body.getAge()) / 1 + 88.362;
        }
        else {
            productionOfHeatAtCompleteRest = (9.247 * body.getMass()) / 1 + (3.098 * body.getHeight()) / 1 - (4.330 * body.getAge()) / 1 + 447.593;
        }
        return productionOfHeatAtCompleteRest;
    }
}
