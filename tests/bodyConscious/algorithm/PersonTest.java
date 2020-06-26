package bodyConscious.algorithm;

import bodyConscious.algorithm.BMR.HarrisBenedictRevised;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void calculateTDEE() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        Assert.assertEquals(1972, testPerson.calculateTDEE());
    }

    @Test
    public void getName() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        Assert.assertEquals("test", testPerson.getName());
    }

    @Test
    public void setName() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        testPerson.setName("testTested");

        Assert.assertEquals("testTested", testPerson.getName());
    }

    @Test
    public void getBody() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        Assert.assertEquals(test, testPerson.getBody());
    }

    @Test
    public void setBody() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        Body test2 = new Body(60, 170, 18, "female");
        testPerson.setBody(test2);

        Assert.assertEquals(test2, testPerson.getBody());
    }

    @Test
    public void getTDEE() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        Assert.assertEquals(1972, testPerson.getTDEE());
    }

    @Test
    public void setTDEE() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        testPerson.setTDEE();

        Assert.assertEquals(1972, testPerson.getTDEE());
    }

    @Test
    public void getGoal() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        Assert.assertEquals(goal, testPerson.getGoal());
    }

    @Test
    public void setGoal() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        Goal goaltest = new Goal(false, true, 5);
        testPerson.setGoal(goaltest);

        Assert.assertEquals(goaltest, testPerson.getGoal());
    }

    @Test
    public void getPhysicalActivityLevel() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        Assert.assertEquals("getPhysicalActivityLevel fail", 1, testPerson.getPhysicalActivityLevel(), 0);
    }

    @Test
    public void setPhysicalActivityLevel() throws IOException, ParseException {
        Body test = new Body(82, 185, 18, "male");
        test.setCaloriesBurnedAtCompleteRest(new HarrisBenedictRevised());
        Goal goal = new Goal(true, false, 5);
        Person testPerson = new Person("test", test, goal, 1);

        testPerson.setPhysicalActivityLevel(1.2);

        Assert.assertEquals("getPhysicalActivityLevel fail", 1.2, testPerson.getPhysicalActivityLevel(), 0);
    }
}