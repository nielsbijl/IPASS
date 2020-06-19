package bodyConscious.algorithm.BMR;

import bodyConscious.algorithm.Body;

public class HarrisBenedict implements BMR{
    @Override
    public double BMREquation(Body body) {
        double productionOfHeatAtCompleteRest;
        if (body.getGender().intern() == "male"){
            productionOfHeatAtCompleteRest = (13.7516 * body.getMass()) / 1 + (5.0033 * body.getHeight()) / 1 - (6.7550 * body.getAge()) / 1 + 66.4730;
        }
        else {
            productionOfHeatAtCompleteRest = (9.5634 * body.getMass()) / 1 + (1.8496 * body.getHeight()) / 1 - (4.6756 * body.getAge()) / 1 + 655.0955;
        }
        return productionOfHeatAtCompleteRest;
    }
}
