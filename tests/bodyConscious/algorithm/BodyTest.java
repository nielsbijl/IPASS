package bodyConscious.algorithm;

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
        test.setProductionOfHeatAtCompleteRest(10);
        assertEquals("setProductionOfHeatAtCompleteRest failed", 10, test.getProductionOfHeatAtCompleteRest(), 0);
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
        Body test = new Body("test", 0, 0, 0,"male", 0);
        test.setProductionOfHeatAtCompleteRest(1000);
        assertEquals("getProductionOfHeatAtCompleteRest failed", 1000, test.getProductionOfHeatAtCompleteRest(), 0);
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

    @Test
    public void calculateBMRharrisBenedict() {
        Body niels = new Body("Niels", 83, 185, 18, "male", 17);

        niels.calculateBMRharrisBenedict();
        assertEquals("calculateBMRharrisBenedict failed", 2011.8763000000001, niels.getProductionOfHeatAtCompleteRest(), 0);
    }

    @Test
    public void calculateBMRharrisBenedictRevised() {
        Body niels = new Body("Niels", 83, 185, 18, "male", 17);

        niels.calculateBMRharrisBenedictRevised();
        assertEquals("calculateBMRharrisBenedictRevised failed", 1985.9420000000002, niels.getProductionOfHeatAtCompleteRest(), 0);
    }

    @Test
    public void calculateBMRmifflinStJeor() {
        Body niels = new Body("Niels", 83, 185, 18, "male", 17);

        niels.calculateBMRmifflinStJeor();
        assertEquals("calculateBMRmifflinStJeor failed", 1901.25, niels.getProductionOfHeatAtCompleteRest(), 0);
    }

    @Test
    public void calculateBMRkatchMcArdle() {
        Body niels = new Body("Niels", 83, 185, 18, "male", 17);

        niels.calculateBMRkatchMcArdle();
        assertEquals("calculateBMRkatchMcArdle failed", 2162.8, niels.getProductionOfHeatAtCompleteRest(), 0);
    }

}