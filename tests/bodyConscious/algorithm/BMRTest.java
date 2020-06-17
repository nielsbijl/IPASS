package bodyConscious.algorithm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BMRTest {

    @Test
    public void harrisBenedict() {
        Body niels = new Body("Niels", 83, 185, 18, "male", 17);
        Body roos = new Body("Roos", 48, 165, 18, "female", 25);
        assertEquals("harrisBenedict formula failed for male", 2011.8763000000001, BMR.harrisBenedict(niels), 0);
        assertEquals("harrisBenedict formula failed for female", 1335.1619, BMR.harrisBenedict(roos),0);
    }

    @Test
    public void harrisBenedictRevised() {
        Body niels = new Body("Niels", 83, 185, 18, "male", 17);
        Body roos = new Body("Roos", 48, 165, 18, "female", 25);
        assertEquals("harrisBenedict-revised formula failed for male", 1985.9420000000002, BMR.harrisBenedictRevised(niels), 0);
        assertEquals("harrisBenedict-revised formula failed for female",1324.679, BMR.harrisBenedictRevised(roos), 0);
    }

    @Test
    public void mifflinStJeor() {
        Body niels = new Body("Niels", 83, 185, 18, "male", 17);
        Body roos = new Body("Roos", 48, 165, 18, "female", 25);
        assertEquals("mifflinStJoer formula failed for male", 1901.25, BMR.mifflinStJeor(niels), 0);
        assertEquals("mifflinStJoer formula failed for female", 1260.25, BMR.mifflinStJeor(roos), 0);
    }

    @Test
    public void katchMcArdle() {
        Body niels = new Body("Niels", 83, 185, 18, "male", 17);
        Body roos = new Body("Roos", 48, 165, 18, "female", 25);
        assertEquals("katchMcArdle formula failed for male", 2162.8, BMR.katchMcArdle(niels), 0);
        assertEquals("katchMcArdle formula failed for female", 1406.8000000000002, BMR.katchMcArdle(roos), 0);
    }

}