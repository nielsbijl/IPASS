package bodyConscious.algorithm;

import bodyConscious.algorithm.BMR.BMR;
import bodyConscious.algorithm.BMR.HarrisBenedict;
import bodyConscious.algorithm.BMR.MifflinStJeor;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BodyTest {

    @Test
    public void setProductionOfHeatAtCompleteRest() throws IOException, ParseException {
        Body test = new Body(0, 0, 0,"male", 0);
        BMR harrisBenedict = new HarrisBenedict();
        test.setCaloriesBurnedAtCompleteRest(harrisBenedict);
        assertEquals("setProductionOfHeatAtCompleteRest failed", harrisBenedict, test.getCaloriesBurnedAtCompleteRestEquation());
    }

    @Test
    public void setMass() throws IOException, ParseException {
        Body test = new Body(0, 0, 0,"male", 0);
        test.setMass(100);

        assertEquals("setProductionOfHeatAtCompleteRest failed", 100, test.getMass(), 0);
    }

    @Test
    public void setHeight() throws IOException, ParseException {
        Body test = new Body(0, 0, 0,"male", 0);
        test.setHeight(100);

        assertEquals("setHeight failed", 100, test.getHeight(), 0);
    }

    @Test
    public void setAge() throws IOException, ParseException {
        Body test = new Body( 0, 0, 0,"male", 0);
        test.setAge(100);

        assertEquals(100, test.getAge());
    }

    @Test
    public void setBodyFatPercentage() throws IOException, ParseException {
        Body test = new Body( 0, 0, 0,"male", 0);
        test.setBodyFatPercentage(20);

        assertEquals(20, test.getBodyFatPercentage());
    }

    @Test
    public void getProductionOfHeatAtCompleteRest() throws IOException, ParseException {
        Body test = new Body(83, 185, 18, "male", 17);
        test.setCaloriesBurnedAtCompleteRest(new MifflinStJeor());
        assertEquals("getProductionOfHeatAtCompleteRest failed", 1901.25, test.getCaloriesBurnedAtCompleteRest(), 0);
    }

    @Test
    public void getMass() throws IOException, ParseException {
        Body test = new Body(0, 0, 0,"male", 0);
        assertEquals("getMass failed", 0, test.getMass(), 0);
    }

    @Test
    public void getHeight() throws IOException, ParseException {
        Body test = new Body(0, 0, 0,"male", 0);
        assertEquals("getHeight failed", 0, test.getHeight(), 0);
    }

    @Test
    public void getAge() throws IOException, ParseException {
        Body test = new Body(0, 0, 0,"male", 0);
        assertEquals("getAge failed", 0, test.getAge(), 0);
    }

    @Test
    public void getGender() throws IOException, ParseException {
        Body test = new Body(0, 0, 0,"male", 0);
        assertEquals("male", test.getGender());
    }

    @Test
    public void getBodyFatPercentage() throws IOException, ParseException {
        Body test = new Body(0, 0, 0,"male", 0);
        assertEquals(0, test.getBodyFatPercentage());
    }

}