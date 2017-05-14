# Programming Assignment 1 - Health Profile

Computerizing health records could make it easier for patients to share their health profiles and histories among their various health-care professionals. This could improve the quality of health care, help avoid drug conflicts and erroneous drug prescription, reduce costs, and in case of emergencies, could save lives.

Write a Java Program in which you design HealthProfile class for a person. The class attributes should include the person’s first name, last name, gender, date of birth (consisting of separate attributes for the month, day, and year of birth), height (in inches), and weight (in pounds). Your class should have a constructor that receives this data. For each attribute, provide set and get methods. The class should also include methods that calculate and return the user’s age in years, maximum heart rate, and target-heart-rate range, and Boby Mass Index (BMI).  

The formula to calculate maximum heart rate (beats per minute) = 220 – age (in years)

The target-heart-rate is a range that is 50-85% of the maximum heart range (American Health Association)

The formula to calculate BMI = (weightInPounds * 703)/(heightInInches * heightInInches)

You’ll need to write a java application that prompts for the person’s information, instantiates an object of class HealthProfile for that person and prints the information from that object (first name, last name, gender, date of birth, height and weight) then calculates and prints the person’s age in years, BMI, maximum heart rate and target-heart-rate range. It should also display the BMI values using chart shown below:

Underweight: BMI < 18.5

Normal: 18.5 < BMI < 24.9

Overweight: 25 < BMI < 29.9

Obese: BMI >= 30

## Requirements

- [Java SE](http://www.oracle.com/technetwork/java/javase/overview)
- [Gradle](http://www.gradle.org)

---

Copyright &copy; 2017 Mark Pro.
