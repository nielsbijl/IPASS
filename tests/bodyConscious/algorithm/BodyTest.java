package bodyConscious.algorithm;

import bodyConscious.algorithm.BMR.BMR;
import bodyConscious.algorithm.BMR.HarrisBenedict;
import bodyConscious.algorithm.BMR.MifflinStJeor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BodyTest {
    @Test
    public void setName() {
        Body test = new Body("null", 0, 0, 0,"male", 0);
        test.setName("test");

        assertEquals("test", test.getName());
    }

    @Test
    public void setProductionOfHeatAtCompleteRest() {
        Body test = new Body("test", 0, 0, 0,"male", 0);
        BMR harrisBenedict = new HarrisBenedict();
        test.setCaloriesBurnedAtCompleteRest(harrisBenedict);
        assertEquals("setProductionOfHeatAtCompleteRest failed", harrisBenedict, test.getCaloriesBurnedAtCompleteRestEquation());
    }

    @Test
    public void setMass() {
        Body test = new Body("null", 0, 0, 0,"male", 0);
        test.setMass(100);

        assertEquals("setProductionOfHeatAtCompleteRest failed", 100, test.getMass(), 0);
    }

    @Test
    public void setHeight() {
        Body test = new Body("null", 0, 0, 0,"male", 0);
        test.setHeight(100);

        assertEquals("setHeight failed", 100, test.getHeight(), 0);
    }

    @Test
    public void setAge() {
        Body test = new Body("null", 0, 0, 0,"male", 0);
        test.setAge(100);

        assertEquals(100, test.getAge());
    }

    @Test
    public void setBodyFatPercentage() {
        Body test = new Body("null", 0, 0, 0,"male", 0);
        test.setBodyFatPercentage(20);

        assertEquals(20, test.getBodyFatPercentage());
    }

    @Test
    public void getName() {
        Body test = new Body("test", 0, 0, 0,"male", 0);
        assertEquals("test", test.getName());
    }

    @Test
    public void getProductionOfHeatAtCompleteRest() {
        Body test = new Body("Niels", 83, 185, 18, "male", 17);
        test.setCaloriesBurnedAtCompleteRest(new MifflinStJeor());
        assertEquals("getProductionOfHeatAtCompleteRest failed", 1901.25, test.getCaloriesBurnedAtCompleteRest(), 0);
    }

    @Test
    public void getMass() {
        Body test = new Body("test", 0, 0, 0,"male", 0);
        assertEquals("getMass failed", 0, test.getMass(), 0);
    }

    @Test
    public void getHeight() {
        Body test = new Body("test", 0, 0, 0,"male", 0);
        assertEquals("getHeight failed", 0, test.getHeight(), 0);
    }

    @Test
    public void getAge() {
        Body test = new Body("test", 0, 0, 0,"male", 0);
        assertEquals("getAge failed", 0, test.getAge(), 0);
    }

    @Test
    public void getGender() {
        Body test = new Body("test", 0, 0, 0,"male", 0);
        assertEquals("male", test.getGender());
    }

    @Test
    public void getBodyFatPercentage() {
        Body test = new Body("test", 0, 0, 0,"male", 0);
        assertEquals(0, test.getBodyFatPercentage());
    }

}