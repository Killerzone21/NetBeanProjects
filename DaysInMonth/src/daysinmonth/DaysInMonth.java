/**
 * **********************************************************************
 * Programmer: Alexander Quirindongo
 *
 * Course: CSCI 1471
 *
 * Date: October 2, 2019
 *
 * Assignment: Program #7: Days in Month
 *
 * Environment: Java with Netbeans IDE
 *
 * Files Included: DaysInMonth.java, Java Problems.docx
 *
 * Purpose: Allows user to input an integer number and get back the days in that month
 *
 * Input: Integer for month, integer for year if February is picked
 * 
 * Preconditions/Assumptions: Only positive integer between 1 and 12 is picked for month, positive integer for year is picked 
 *
 * Output: Month and how many days it has in it. Also accounts for leap year for February
 *
 * Postconditions: (optional)
 *
 * Algorithm: Ask for user input on what month they want
 *            If user inputs 2, ask for what year they want
 *            Check if the year is a leapyear using the formula provided
 *            Using a switch-case, determine what month they want and output that statement
 *            If February is picked, check to see if the year chosen is a leapyear. Output the appropriate statement.        
**********************************************************************
* **/

package daysinmonth;

import java.util.Scanner;

public class DaysInMonth {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to the Days in a Month program!\nPlease enter an integer between 1 - 12 for the month (January is 1, Febuary is 2, ... etc):");
        int i = input.nextInt();

        boolean isLeapyear = false;

        if (i == 2) {
            System.out.println("Please enter the year: ");
            int year = input.nextInt();

            if (year % 4 == 0 && (!(year % 100 == 0) || year % 400 == 0)) {
                isLeapyear = true;
            }
        }
        switch (i) {
            case 1:
                System.out.println("January has 31 days in their month!");
                break;
            case 2:
                if (isLeapyear) {
                    System.out.println("February has 29 days!");
                } else {
                    System.out.println("February has 28 days!");
                }
                break;
            case 3:
                System.out.println("March has 31 days in their month");
                break;
            case 4:
                System.out.println("April has 30 days in their month");
                break;
            case 5:
                System.out.println("May has 31 days in their month");
                break;
            case 6:
                System.out.println("June has 30 days in their month");
                break;
            case 7:
                System.out.println("July has 31 days in their month");
                break;
            case 8:
                System.out.println("August has 31 days in their month");
                break;
            case 9:
                System.out.println("September has 30 days in their month");
                break;
            case 10:
                System.out.println("October has 31 days in their month");
                break;
            case 11:
                System.out.println("November has 30 days in their month");
                break;
            case 12:
                System.out.println("December has 31 days in their month");
                break;
        }
    }
}
