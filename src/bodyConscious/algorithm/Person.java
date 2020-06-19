package bodyConscious.algorithm;

public class Person {
    private String name;
    private Body body;
    private double physicalActivityLevel;
    private int TDEE;
    private Goal goal;

    public Person(String name, Body body, Goal goal, double physicalActivityLevel){
        this.name = name;
        this.body = body;
        this.goal = goal;
        this.physicalActivityLevel = physicalActivityLevel;
        this.TDEE = calculateTDEE(body.getCaloriesBurnedAtCompleteRest(), physicalActivityLevel);
    }

    public int calculateTDEE(double BRM, double physicalActivityLevel){
        //Total Daily Energy Expenditure
        //Basal metabolic rate * physical activity level
        int tdee = (int) (BRM * physicalActivityLevel);
        return tdee;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Body getBody() {
        return body;
    }
    public void setBody(Body body) {
        this.body = body;
    }
    public int getTDEE() {
        return TDEE;
    }
    public void setTDEE() {
        this.TDEE = calculateTDEE(this.body.getCaloriesBurnedAtCompleteRest(), this.physicalActivityLevel);
    }
    public Goal getGoal() {
        return goal;
    }
    public void setGoal(Goal goal) {
        this.goal = goal;
    }
    public double getPhysicalActivityLevel() {
        return physicalActivityLevel;
    }
    public void setPhysicalActivityLevel(double physicalActivityLevel) {
        this.physicalActivityLevel = physicalActivityLevel;
    }
}
