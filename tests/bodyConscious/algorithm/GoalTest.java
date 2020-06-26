package bodyConscious.algorithm;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoalTest {

    @Test
    public void isLoseBodyFat() {
        Goal goaltest = new Goal(true, false, 10);

        Assert.assertEquals(true, goaltest.isLoseBodyFat());
    }

    @Test
    public void setLoseBodyFat() {
        Goal goaltest = new Goal(true, false, 10);
        goaltest.setLoseBodyFat(false);

        Assert.assertEquals(false, goaltest.isLoseBodyFat());
    }

    @Test
    public void isGainBodyFat() {
        Goal goaltest = new Goal(true, false, 10);

        Assert.assertEquals(false, goaltest.isGainBodyFat());
    }

    @Test
    public void setGainBodyFat() {
        Goal goaltest = new Goal(false, false, 10);
        goaltest.setGainBodyFat(true);

        Assert.assertEquals(true, goaltest.isGainBodyFat());
    }

    @Test
    public void getAmountOfBodyFat() {
        Goal goaltest = new Goal(true, false, 10);

        Assert.assertEquals("get amount of bodyfat fial", 10, goaltest.getAmountOfBodyFat(), 0);
    }

    @Test
    public void setAmountOfBodyFat() {
        Goal goaltest = new Goal(true, false, 10);
        goaltest.setAmountOfBodyFat(20);

        Assert.assertEquals("set amount of bodyfat fial",20, goaltest.getAmountOfBodyFat(), 0);
    }
}