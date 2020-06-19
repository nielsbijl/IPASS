package bodyConscious.algorithm;

import bodyConscious.algorithm.BMR.HarrisBenedict;
import bodyConscious.algorithm.BMR.HarrisBenedictRevised;
import bodyConscious.algorithm.BMR.KatchMcArdle;
import bodyConscious.algorithm.BMR.MifflinStJeor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BMRTest {

    @Test
    public void harrisBenedict() {
        Body niels = new Body(83, 185, 18, "male", 17);
        niels.setCaloriesBurnedAtCompleteRest(new HarrisBenedict());
        Body roos = new Body(48, 165, 18, "female", 25);
        roos.setCaloriesBurnedAtCompleteRest(new HarrisBenedict());
        assertEquals("harrisBenedict formula failed for male", 2011.8763000000001, niels.getCaloriesBurnedAtCompleteRest(), 0);
        assertEquals("harrisBenedict formula failed for female", 1335.1619, roos.getCaloriesBurnedAtCompleteRest(),0);
    }

    @Test
    public void harrisBenedictRevised() {
        Body niels = new Body(83, 185, 18, "male", 17);
        niels.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Body roos = new Body(48, 165, 18, "female", 25);
        roos.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        assertEquals("harrisBenedict-revised formula failed for male", 1985.9420000000002, niels.getCaloriesBurnedAtCompleteRest(), 0);
        assertEquals("harrisBenedict-revised formula failed for female",1324.679, roos.getCaloriesBurnedAtCompleteRest(), 0);
    }

    @Test
    public void mifflinStJeor() {
        Body niels = new Body(83, 185, 18, "male", 17);
        niels.setCaloriesBurnedAtCompleteRest(new MifflinStJeor());
        Body roos = new Body(48, 165, 18, "female", 25);
        roos.setCaloriesBurnedAtCompleteRest(new MifflinStJeor());
        assertEquals("mifflinStJoer formula failed for male", 1901.25, niels.getCaloriesBurnedAtCompleteRest(), 0);
        assertEquals("mifflinStJoer formula failed for female", 1260.25, roos.getCaloriesBurnedAtCompleteRest(), 0);
    }

    @Test
    public void katchMcArdle() {
        Body niels = new Body(83, 185, 18, "male", 17);
        niels.setCaloriesBurnedAtCompleteRest(new KatchMcArdle());
        Body roos = new Body(48, 165, 18, "female", 25);
        roos.setCaloriesBurnedAtCompleteRest(new KatchMcArdle());
        assertEquals("katchMcArdle formula failed for male", 2162.8, niels.getCaloriesBurnedAtCompleteRest(), 0);
        assertEquals("katchMcArdle formula failed for female", 1406.8000000000002, roos.getCaloriesBurnedAtCompleteRest(), 0);
    }

}