# Computer Assisted Instruction

Create a program that will help teach kids how to do basic math.

# Program Guidelines

There are numerous efforts to improve the educational experience of students in schools. The use of computers in education is referred to as Computer-Assisted Instruction (CAI).

For this assignment, you will need to write a Java program that will help a 3th grade student learn multiplication. Use a SecureRandom object to produce two positive one-digit integer. The program should prompt the user with a question, such as:

How much is 5 times 8?

The student then inputs the answer. Next, the program checks for the student’s answer. If it is correct, the program displays only one of the four possible responses to a correct answer:

***Very Good!***

***Excellent!***

***Nice Work!***

***Keep up the good work!***

If the answer is wrong, the program should display only one of the four possible responses and let the student try the same question repeatedly until the student finally gets it right.

***No, please try again.***

***Wrong. Try once more.***

***Don’t give up!***

***No. Keep trying***

A separate method should be used to generate each new question. This method should be called once when the application begins execution and each time the user answers the question correctly.

**Hint:** Use random-number generation to choose a number from 1 to 4 that will be used to select one of the four appropriate responses to each correct or incorrect answer. Use a switch statement to issue the responses.

## Output
![output](output.png)

## Requirements

- [Java SE](http://www.oracle.com/technetwork/java/javase/overview)
- [Gradle](http://www.gradle.org)

---

Copyright &copy; 2017 Mark Pro.
