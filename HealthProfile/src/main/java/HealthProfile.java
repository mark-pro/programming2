import java.time.LocalDate;
import java.time.Period;

class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate dateOfBirth;
    //. A persons height in inches
    private int height;
    //. A persons weight in pounds
    private int weight;

    public HealthProfile(
        String fullName , char gender ,
        LocalDate dateOfBirth , int height, int weight) {
        String[] names = fullName.split(",");
        this.firstName = names[0].trim();
        this.lastName = names[1].trim();
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
    }
    public HealthProfile(
        String firstName , String lastName , char gender ,
        LocalDate dateOfBirth , int height, int weight) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
    }

    //. Getters
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public char getGender() {
        return this.gender;
    }
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
    public int getHeight() {
        return this.height;
    }
    public int getWeight() {
        return this.weight;
    }

    //. Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }    
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setDateOfBirth(int year, int month, int day) {
        setDateOfBirth(LocalDate.of(year, month, day));
    }
    public void setDateOfBirth(String year, String month, String day) {
        setDateOfBirth(Integer.parseInt(year), 
            Integer.parseInt(month), 
            Integer.parseInt(day));
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    //. Helper methods
    public String getFullName() {
        return this.lastName + ", " + this.firstName;
    }
    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
    public int getMaxHeartRate() {
        return 220 - this.getAge();
    }
    public Range getTargetHeartRate() {
        int low = (int) ((double) this.getMaxHeartRate() * .5);
        int high = (int) ((double) this.getMaxHeartRate() * .85);
        return new Range(low , high);
    }
    public double getBodyMassIndex() {
        return (this.weight * 703) / Math.pow(this.height, 2);
    }
    public String getBodyMassIndexSummary() {
        double bmi = this.getBodyMassIndex();
        return 
            bmi < 18.5 ? "Underweight" :
            bmi < 25 ? "Normal" :
            bmi < 30 ? "Overweight" :
            "Obese";
    }

    //. Overrides
    @Override
    public String toString() {
        return "Name: " + this.getFullName() +
        "\nAge: " + this.getAge() +
        "\nDate of Birth: " + 
            this.dateOfBirth.getMonthValue() + "/" + 
            this.dateOfBirth.getDayOfMonth() + "/" + 
            this.dateOfBirth.getYear() +
        "\nHeight: " + this.height + "\"" +
        "\nWeight: " + this.weight + " lbs" +
        "\nBody Mass Index: " + 
            String.format("%.2f", this.getBodyMassIndex()) + " - " + 
            this.getBodyMassIndexSummary() +
        "\nMax Heart Rate: " + this.getMaxHeartRate() +
        "\nTarget Heart Rate: " + 
            this.getTargetHeartRate().getLow() + " - " +
            this.getTargetHeartRate().getHigh(); 
    }
}