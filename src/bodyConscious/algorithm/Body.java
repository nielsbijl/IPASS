package bodyConscious.algorithm;

public class Body {
    private String name;
    private double productionOfHeatAtCompleteRest;
    private double mass;
    private double height;
    private int age;
    final String gender;
    private int bodyFatPercentage;

    //constructor
    public Body(String name, double massKG, double heightCM, int ageYEARS, String gender){
        this.name = name;
        this.mass = massKG;
        this.height = heightCM;
        this.age = ageYEARS;
        this.gender = gender;
    }
    public Body(String name, double massKG, double heightCM, int ageYEARS, String gender, int bodyFatPercentage){
        this.name = name;
        this.mass = massKG;
        this.height = heightCM;
        this.age = ageYEARS;
        this.gender = gender;
        this.bodyFatPercentage = bodyFatPercentage;
    }

    //setters
    void setName(String name){
        this.name = name;
    }
    void setProductionOfHeatAtCompleteRest(double productionOfHeatAtCompleteRest){
        this.productionOfHeatAtCompleteRest = productionOfHeatAtCompleteRest;
    }
    void setMass(double massKG){
        this.mass = massKG;
    }
    void setHeight(double heightCM){
        this.height = heightCM;
    }
    void setAge(int ageYEARS){
        this.age = ageYEARS;
    }
    void setBodyFatPercentage(int bodyFatPercentage){
        this.bodyFatPercentage = bodyFatPercentage;
    }

    //getters
    public String getName(){
        return this.name;
    }
    public double getProductionOfHeatAtCompleteRest(){
        return this.productionOfHeatAtCompleteRest;
    }
    public double getMass(){
        return this.mass;
    }
    public double getHeight(){
        return this.height;
    }
    public int getAge(){
        return this.age;
    }
    public String getGender(){
        return this.gender;
    }
    public int getBodyFatPercentage(){
        return this.bodyFatPercentage;
    }

    //calculators
    void calculateBMRharrisBenedict(){
        this.productionOfHeatAtCompleteRest = BMR.harrisBenedict(this);
    }
    void calculateBMRharrisBenedictRevised(){
        this.productionOfHeatAtCompleteRest = BMR.harrisBenedictRevised(this);
    }
    void calculateBMRmifflinStJeor(){
        this.productionOfHeatAtCompleteRest = BMR.mifflinStJeor(this);
    }
    void calculateBMRkatchMcArdle(){
        this.productionOfHeatAtCompleteRest = BMR.katchMcArdle(this);
    }


}
