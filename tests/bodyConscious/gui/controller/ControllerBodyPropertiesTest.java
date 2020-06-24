package bodyConscious.gui.controller;

import bodyConscious.algorithm.Body;
import bodyConscious.algorithm.Goal;
import bodyConscious.algorithm.Person;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerBodyPropertiesTest {

    @Test
    public void createBodyWithBodyFatFromArrayList() throws IOException, ParseException {
        //arraylist [Niels, 18, true, false, 1.4, 185, 17, 82, 10, true, false]
        ArrayList bodyProperties = ControllerBodyProperties.readSavedBodyPropertiesFromJSON();
        Body bodyActual = new Body(82, 185, 18, "male", 17);
        Body bodyDesired = ControllerBodyProperties.createBodyWithBodyFatFromArrayList(bodyProperties);

        Assert.assertEquals(bodyActual.getAge(), bodyDesired.getAge());
        Assert.assertEquals(bodyActual.getGender(), bodyDesired.getGender());
        Assert.assertEquals(bodyActual.getBodyFatPercentage(), bodyDesired.getBodyFatPercentage());
        Assert.assertEquals("body mass failed", bodyActual.getMass(), bodyDesired.getMass(), 0);
        Assert.assertEquals("body height failed", bodyActual.getHeight(), bodyDesired.getHeight(), 0);
    }

    @Test
    public void createBodyWithoutBodyFatFromArrayList() throws IOException, ParseException {
        //arraylist [Niels, 18, true, false, 1.4, 185, 17, 82, 10, true, false]
        ArrayList bodyProperties = ControllerBodyProperties.readSavedBodyPropertiesFromJSON();
        Body bodyActual = new Body(82, 185, 18, "male");
        Body bodyDesired = ControllerBodyProperties.createBodyWithBodyFatFromArrayList(bodyProperties);

        Assert.assertEquals(bodyActual.getAge(), bodyDesired.getAge());
        Assert.assertEquals(bodyActual.getGender(), bodyDesired.getGender());
        Assert.assertEquals("body mass failed", bodyActual.getMass(), bodyDesired.getMass(), 0);
        Assert.assertEquals("body height failed", bodyActual.getHeight(), bodyDesired.getHeight(), 0);
    }

    @Test
    public void createBodyFromArrayList() throws IOException, ParseException {
        //arraylist [Niels, 18, true, false, 1.4, 185, 17, 82, 10, true, false]
        ArrayList bodyProperties = ControllerBodyProperties.readSavedBodyPropertiesFromJSON();
        Body bodyActual = new Body(82, 185, 18, "male", 17);
        Body bodyDesired = ControllerBodyProperties.createBodyFromArrayList(bodyProperties);

        Assert.assertEquals(bodyActual.getAge(), bodyDesired.getAge());
        Assert.assertEquals(bodyActual.getGender(), bodyDesired.getGender());
        Assert.assertEquals(bodyActual.getBodyFatPercentage(), bodyDesired.getBodyFatPercentage());
        Assert.assertEquals("body mass failed", bodyActual.getMass(), bodyDesired.getMass(), 0);
        Assert.assertEquals("body height failed", bodyActual.getHeight(), bodyDesired.getHeight(), 0);
    }

    @Test
    public void createGoalFromArrayList() throws IOException, ParseException {
        //arraylist [Niels, 18, true, false, 1.4, 185, 17, 82, 10, true, false]
        ArrayList bodyProperties = ControllerBodyProperties.readSavedBodyPropertiesFromJSON();
        Goal goalActual = new Goal(true, false, 10);
        Goal goalDesired = ControllerBodyProperties.createGoalFromArrayList(bodyProperties);

        Assert.assertEquals("goal amount of body fat failed", goalActual.getAmountOfBodyFat(), goalDesired.getAmountOfBodyFat(), 0);
        Assert.assertEquals(goalActual.isGainBodyFat(), goalDesired.isGainBodyFat());
        Assert.assertEquals(goalActual.isLoseBodyFat(), goalDesired.isLoseBodyFat());
    }

    @Test
    public void createPersonFromArrayList() throws IOException, ParseException {
        //arraylist [Niels, 18, true, false, 1.4, 185, 17, 82, 10, true, false]
        ArrayList bodyProperties = ControllerBodyProperties.readSavedBodyPropertiesFromJSON();

        Body niels = new Body(82, 185, 18, "male", 17);
        Goal goal = new Goal(true, false, 10);

        Person personActual = new Person("Niels", niels , goal, 1.4);
        Person personDesired = ControllerBodyProperties.createPersonFromArrayList(bodyProperties);

        Assert.assertEquals(personActual.getPhysicalActivityLevel(), personDesired.getPhysicalActivityLevel(), 0);
        Assert.assertEquals(personActual.getName(), personDesired.getName());
        Assert.assertEquals(personActual.getTDEE(), personDesired.getTDEE());
    }
}