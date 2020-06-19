package bodyConscious.algorithm;

public class Goal {
    private boolean loseBodyFat;
    private boolean gainBodyFat;
    private double amountOfBodyFat;

    public Goal(boolean loseBodyFat, boolean gainBodyFat, double amountOfBodyFat){
        //if loseBodyfat and gainBodyfat are both false the goal is to stay the same
        this.loseBodyFat = loseBodyFat;
        this.gainBodyFat = gainBodyFat;
        this.amountOfBodyFat = amountOfBodyFat;
    }

    public boolean isLoseBodyFat() {
        return loseBodyFat;
    }

    public void setLoseBodyFat(boolean loseBodyFat) {
        this.loseBodyFat = loseBodyFat;
    }

    public boolean isGainBodyFat() {
        return gainBodyFat;
    }

    public void setGainBodyFat(boolean gainBodyFat) {
        this.gainBodyFat = gainBodyFat;
    }

    public double getAmountOfBodyFat() {
        return amountOfBodyFat;
    }

    public void setAmountOfBodyFat(double amountOfBodyFat) {
        this.amountOfBodyFat = amountOfBodyFat;
    }
}
