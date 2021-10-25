package bmicalculator;

/**
 * **********************************************************************
 * Programmer: Alexander Quirindongo
 *
 * Course: CSCI 1471
 *
 * Date: September 10, 2019
 *
 * Assignment: Program #1: BMICalc
 *
 * Environment: Java with Netbeans IDE
 *
 * Files Included: BMICalculator.java, Java Problems.docx
 *
 * Purpose: Calculate Body Mass Index (BMI)
 *
 * Input: Weight in pounds (integer); Height in inches (integer)
 *
 * Preconditions/Assumptions: Only positive integers are input
 *
 * Output: BMI (double/float) = (weight in pounds x 703) divided by (height in
 * inches squared)
 *
 * Postconditions: (optional)
 *
 * Algorithm: Input Height Input Weight Calc BMI Output BMI and Chart      
**********************************************************************
 */
import java.util.Scanner; // program uses class Scanner

public class BMICalculator {

    public static void main(String[] args) // main method begins execution of Java application
    {
// create Scanner to obtain input from command line
        Scanner input = new Scanner(System.in);

        float weight; // first number to compare
        float height; // second number to compare

        System.out.print("Enter your weight: "); // prompt
        weight = input.nextInt(); // read first number from user
        System.out.print("Enter your height: "); // prompt
        height = input.nextInt(); // read second number from user

        System.out.printf("Your weight is %5.2f pounds and your height is %5.2f inches.\n", weight, height);

        float bmi = (weight * 703) / (height * height);

        System.out.printf("Your BMI is %5.2f\n", bmi);

        System.out.println("Undeweight: less than 18.5");
        System.out.println("Normal: Between 18.5 and 24.9");
        System.out.println("Overweight: Between 25 and 29.9");
        System.out.println("Obese: 30 or greater");

        if (bmi < 18.5) {
            System.out.print("You are underweight!");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.print("You are normal weight!");
        } else if (bmi >= 25 && bmi <= 29.9) {
            System.out.print("You are overweight!");
        } else {
            System.out.print("You are obese!");
        }

    } // end method main
} // end class Comparison
